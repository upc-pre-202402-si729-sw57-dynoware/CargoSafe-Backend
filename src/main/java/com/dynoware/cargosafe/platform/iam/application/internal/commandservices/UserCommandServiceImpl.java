package com.dynoware.cargosafe.platform.iam.application.internal.commandservices;

import com.dynoware.cargosafe.platform.iam.application.internal.outboundservices.hashing.HashingService;
import com.dynoware.cargosafe.platform.iam.application.internal.outboundservices.tokens.TokenService;
import com.dynoware.cargosafe.platform.iam.domain.model.aggregates.User;
import com.dynoware.cargosafe.platform.iam.domain.model.commands.SignInCommand;
import com.dynoware.cargosafe.platform.iam.domain.model.commands.SignUpCommand;
import com.dynoware.cargosafe.platform.iam.domain.services.UserCommandService;
import com.dynoware.cargosafe.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.dynoware.cargosafe.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.dynoware.cargosafe.platform.profiles.domain.model.aggregates.Profile;
import com.dynoware.cargosafe.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.dynoware.cargosafe.platform.profiles.domain.services.ProfileCommandService;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserCommandServiceImpl
 * <p>
 *     Implementation of UserCommandService.
 *     This class is responsible for handling the SignUpCommand and SignInCommand and persisting the user in the database.
 * </p>
 */
@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;
    private final RoleRepository roleRepository;
    private final ProfileCommandService profileCommandService;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService, RoleRepository roleRepository, ProfileCommandService profileCommandService) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
        this.profileCommandService = profileCommandService;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username())) {
            throw new RuntimeException("Username already exists");
        }

        var roles = command.roles().stream()
                .map(role -> roleRepository.findByName(role.getName())
                        .orElseThrow(() -> new RuntimeException("Role not found")))
                .toList();

        CreateProfileCommand createProfileCommand = new CreateProfileCommand(
                command.username(), command.username(), command.username() + "@example.com",
                "Street", "Number", "City", "PostalCode", "Country");
        Optional<Profile> profile = profileCommandService.handle(createProfileCommand);

        if (profile.isEmpty()) {
            return Optional.empty();
        }

        var user = new User(command.username(), hashingService.encode(command.password()), roles);
        user.setProfile(profile.get());
        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty()) throw new RuntimeException("User not found");
        var existingUser = user.get();
        if (!hashingService.matches(command.password(), existingUser.getPassword())) throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(existingUser.getUsername());
        return Optional.of(ImmutablePair.of(existingUser, token));
    }
}
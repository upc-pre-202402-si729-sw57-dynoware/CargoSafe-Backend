package com.dynoware.cargosafe.platform.profiles.application.internal.queryservices;

import com.dynoware.cargosafe.platform.profiles.domain.model.aggregates.Profile;
import com.dynoware.cargosafe.platform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.dynoware.cargosafe.platform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.dynoware.cargosafe.platform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.dynoware.cargosafe.platform.profiles.domain.model.queries.GetProfileByUsernameQuery;
import com.dynoware.cargosafe.platform.profiles.domain.services.ProfileQueryService;
import com.dynoware.cargosafe.platform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Profile Query Service Implementation
 */
@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    /**
     * Constructor
     *
     * @param profileRepository The {@link ProfileRepository} instance
     */
    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }


    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmailAddress(query.emailAddress());
    }




    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }


    @Override
    public Optional<Profile> handle(GetProfileByUsernameQuery query) {
        return profileRepository.findByUserUsername(query.username());
    }

}

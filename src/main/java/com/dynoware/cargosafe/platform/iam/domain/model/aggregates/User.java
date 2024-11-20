package com.dynoware.cargosafe.platform.iam.domain.model.aggregates;

import com.dynoware.cargosafe.platform.iam.domain.model.entities.Role;
import com.dynoware.cargosafe.platform.profiles.domain.model.aggregates.Profile;
import com.dynoware.cargosafe.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User aggregate root.
 */
@Getter
@Setter
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;
    /**
     * Default constructor.
     */
    public User() {
        this.roles = new HashSet<>();
    }



    /**
     * Constructor with username and password.
     *
     * @param username the username.
     * @param password the password.
     */
    public User(String username, String password, Profile profile) {
        this();
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    /**
     * Constructor with username, password and roles.
     *
     * @param username the username.
     * @param password the password.
     * @param roles    the roles.
     */
    public User(String username, String password, List<Role> roles) {
        this();
        this.username = username;
        this.password = password;
        this.addRoles(roles);
    }

    /**
     * Add a role to the user.
     *
     * @param role the role.
     * @return the user.
     */
    public User addRole(Role role) {
        this.roles.add(role);
        return this;
    }

    /**
     * Add a set of roles to the user.
     *
     * @param roles the roles.
     * @return the user.
     */
    public User addRoles(List<Role> roles) {
        var validatedRoles = Role.validateRoleSet(roles);
        this.roles.addAll(validatedRoles);
        return this;
    }

    public Profile getProfile() {
        return profile;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public User(Long id) {
        super(id);
    }
}

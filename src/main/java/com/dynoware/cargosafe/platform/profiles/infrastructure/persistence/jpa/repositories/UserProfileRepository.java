package com.dynoware.cargosafe.platform.profiles.infrastructure.persistence.jpa.repositories;

import com.dynoware.cargosafe.platform.iam.domain.model.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
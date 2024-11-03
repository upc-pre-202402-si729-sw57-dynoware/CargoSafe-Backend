package com.dynoware.cargosafe.platform.trips.infrastructure.persistence.jpa.repositories;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    Optional<Evidence> findByTripId(Long tripId);
    boolean existsByTripId(Long tripId);
}

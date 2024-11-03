package com.dynoware.cargosafe.platform.trips.infrastructure.persistence.jpa.repositories;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByModel(String model);
    boolean existsByModel(String model);
}

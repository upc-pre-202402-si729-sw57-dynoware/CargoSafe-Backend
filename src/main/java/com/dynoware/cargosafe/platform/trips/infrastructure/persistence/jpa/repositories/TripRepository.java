package com.dynoware.cargosafe.platform.trips.infrastructure.persistence.jpa.repositories;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Expense;
import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByUserId(Long userId);
    boolean existsById(Long id);
    List<Trip> findAll();
}
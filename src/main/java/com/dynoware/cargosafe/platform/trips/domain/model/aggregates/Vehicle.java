package com.dynoware.cargosafe.platform.trips.domain.model.aggregates;

import com.dynoware.cargosafe.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateVehicleCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateVehicleCommand;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.jsonwebtoken.lang.Strings;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "vehicles")
public class Vehicle extends AuditableAbstractAggregateRoot<Vehicle> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "plate", nullable = false)
    private String plate;

    @Column(name = "max_load", nullable = false)
    private float maxLoad;

    @Column(name = "volume", nullable = false)
    private float volume;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;

    public Vehicle() {
        this.model = Strings.EMPTY;
        this.plate = Strings.EMPTY;
        this.maxLoad = 0.0f;
        this.volume = 0.0f;
        this.photoUrl = Strings.EMPTY;
    }

    public Vehicle(String model, String plate, float maxLoad, float volume, String photoUrl) {
        this();
        this.model = model;
        this.plate = plate;
        this.maxLoad = maxLoad;
        this.volume = volume;
        this.photoUrl = photoUrl;
    }

    public Vehicle(CreateVehicleCommand command) {
        this();
        this.model = command.model();
        this.plate = command.plate();
        this.maxLoad = command.maxLoad();
        this.volume = command.volume();
        this.photoUrl = command.photoUrl();
    }

    public Vehicle updateVehicle(String model, String plate, float maxLoad, float volume, String photoUrl) {
        this.model = model;
        this.plate = plate;
        this.maxLoad = maxLoad;
        this.volume = volume;
        this.photoUrl = photoUrl;
        return this;
    }

    public Vehicle(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setMaxLoad(float maxLoad) {
        this.maxLoad = maxLoad;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
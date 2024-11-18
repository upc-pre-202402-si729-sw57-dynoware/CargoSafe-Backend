package com.dynoware.cargosafe.platform.trips.domain.model.aggregates;

import com.dynoware.cargosafe.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateVehicleCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateVehicleCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicles")
public class Vehicle extends AuditableAbstractAggregateRoot<Vehicle> {
    private Long id;
    private String model;
    private String plate;
    private float max_load;
    private float volume;
    private String photo_url;

    public Vehicle(CreateVehicleCommand command){
        this.model = command.model();
        this.plate = command.plate();
        this.max_load = command.max_load();
        this.volume = command.volume();
        this.photo_url = command.photo_url();
    }

    public Vehicle updateVehicle(UpdateVehicleCommand command) {
        this.model = command.model();
        this.plate = command.plate();
        this.max_load = command.max_load();
        this.volume = command.volume();
        this.photo_url = command.photo_url();
        return this;
    }

    public Vehicle(Long id) {
        this.id = id;
    }
}

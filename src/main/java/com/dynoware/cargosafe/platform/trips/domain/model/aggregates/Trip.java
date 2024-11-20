package com.dynoware.cargosafe.platform.trips.domain.model.aggregates;
import com.dynoware.cargosafe.platform.iam.domain.model.aggregates.User;
import com.dynoware.cargosafe.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateTripCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateTripCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Trip extends AuditableAbstractAggregateRoot<Trip> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private String unloadDirection;

    @Column(nullable = false)
    private String unloadLocation;

    @Column(nullable = false)
    private String unloadDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Column(nullable = false)
    private int numberPackages;

    @Column(nullable = false)
    private String holderName;

    @Column(nullable = false)
    private String destinationDate;

    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false)
    private String destinationAddress;

    @Column(nullable = false)
    private String loadDetail;

    @Column(nullable = false)
    private String pickupAddress;

    public Trip(CreateTripCommand command) {
        this.name = command.name();
        this.type = command.type();
        this.weight = command.weight();
        this.unloadDirection = command.unloadDirection();
        this.unloadLocation = command.unloadLocation();
        this.unloadDate = command.unloadDate();
        this.vehicle = null;
        this.driver = null;
        this.numberPackages = command.numberPackages();
        this.holderName = command.holderName();
        this.destinationDate = command.destinationDate();
        this.totalAmount = 0.0;
        this.destinationAddress = command.destinationAddress();
        this.loadDetail = command.loadDetail();
        this.pickupAddress = command.pickupAddress();
    }

    public void updateTrip(UpdateTripCommand command) {
        this.name = command.name();
        this.type = command.type();
        this.weight = command.weight();
        this.unloadDirection = command.unloadDirection();
        this.unloadLocation = command.unloadLocation();
        this.unloadDate = command.unloadDate();
        this.vehicle = command.vehicleId();
        this.driver = command.driverId();
        this.numberPackages = command.numberPackages();
        this.holderName = command.holderName();
        this.destinationDate = command.destinationDate();
        this.totalAmount = command.totalAmount();
        this.destinationAddress = command.destinationAddress();
        this.loadDetail = command.loadDetail();
        this.pickupAddress = command.pickupAddress();
    }
}
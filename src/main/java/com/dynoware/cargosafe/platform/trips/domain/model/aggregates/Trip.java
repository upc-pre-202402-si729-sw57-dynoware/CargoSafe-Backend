package com.dynoware.cargosafe.platform.trips.domain.model.aggregates;
import com.dynoware.cargosafe.platform.iam.domain.model.aggregates.User;
import com.dynoware.cargosafe.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
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

    @ManyToOne
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "alert_id", nullable = false)
    private Alert alert;

    @ManyToOne
    @JoinColumn(name = "ongoing_trip_id", nullable = false)
    private OnGoingTrip ongoingTrip;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String country;

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
}
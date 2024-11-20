package com.dynoware.cargosafe.platform.requestService.domain.model.aggregates;

import com.dynoware.cargosafe.platform.requestService.domain.model.entities.RequestServiceStatus;
import com.dynoware.cargosafe.platform.requestService.domain.model.entities.Status;
import com.dynoware.cargosafe.platform.requestService.domain.model.valueobjects.StatusName;
import com.dynoware.cargosafe.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class RequestService extends AuditableAbstractAggregateRoot<RequestService> {
    private String unloadDirection;
    private String type;
    private int numberPackages;
    private String country;
    private String department;
    private String district;
    private String destination;
    private String unloadLocation;
    private String unloadDate;
    private Double distance;
    private String holderName;
    private String pickupAddress;
    private double pickupLat;
    private double pickupLng;
    private String destinationAddress;
    private double destinationLat;
    private double destinationLng;
    private String loadDetail;
    private String weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estatus_id")
    private Status status;

    @OneToMany(mappedBy = "requestService", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequestServiceStatus> statuses = new ArrayList<>();
}
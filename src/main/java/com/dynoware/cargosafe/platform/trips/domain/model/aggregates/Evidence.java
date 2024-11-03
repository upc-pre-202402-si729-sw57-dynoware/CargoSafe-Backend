package com.dynoware.cargosafe.platform.trips.domain.model.aggregates;

import com.dynoware.cargosafe.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateEvidenceCommand;
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
@Table(name = "evidences")
public class Evidence extends AuditableAbstractAggregateRoot<Evidence> {
    private Long id;
    private String link;
    private Long tripId;

    public Evidence(CreateEvidenceCommand command){
        this.link = command.link();
        this.tripId = command.tripId();
    }
}

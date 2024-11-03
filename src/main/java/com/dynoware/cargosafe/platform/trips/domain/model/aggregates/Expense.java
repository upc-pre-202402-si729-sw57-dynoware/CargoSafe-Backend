package com.dynoware.cargosafe.platform.trips.domain.model.aggregates;

import com.dynoware.cargosafe.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateExpenseCommand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@Entity
public class Expense extends AuditableAbstractAggregateRoot<Expense> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int fuel_amount;

    @Column(nullable = false)
    private String fuel_description;

    @Column(nullable = false)
    private int viatics_amount;

    @Column(nullable = false)
    private String viatics_description;

    @Column(nullable = false)
    private int tolls_amount;

    @Column(nullable = false)
    private String tolls_description;

    protected Expense() {}

    public Expense(CreateExpenseCommand command) {
        this.fuel_amount = command.fuel_amount();
        this.fuel_description = command.fuel_description();
        this.viatics_amount = command.viatics_amount();
        this.viatics_description = command.viatics_description();
        this.tolls_amount = command.tolls_amount();
        this.tolls_description = command.tolls_description();

    }
}

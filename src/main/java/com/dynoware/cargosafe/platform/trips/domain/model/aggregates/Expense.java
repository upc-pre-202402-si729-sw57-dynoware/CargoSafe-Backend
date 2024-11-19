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
    private int fuelAmount;

    @Column(nullable = false)
    private String fuelDescription;

    @Column(nullable = false)
    private int viaticsAmount;

    @Column(nullable = false)
    private String viaticsDescription;

    @Column(nullable = false)
    private int tollsAmount;

    @Column(nullable = false)
    private String tollsDescription;

    protected Expense() {}

    public Expense(CreateExpenseCommand command) {
        this.fuelAmount = command.fuelAmount();
        this.fuelDescription = command.fuelDescription();
        this.viaticsAmount = command.viaticsAmount();
        this.viaticsDescription = command.viaticsDescription();
        this.tollsAmount = command.tollsAmount();
        this.tollsDescription = command.tollsDescription();

    }

    public Expense(Long id) {
        this.id = id;
    }
}

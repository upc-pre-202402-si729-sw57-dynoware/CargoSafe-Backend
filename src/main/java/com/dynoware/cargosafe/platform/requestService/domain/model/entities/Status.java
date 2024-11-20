package com.dynoware.cargosafe.platform.requestService.domain.model.entities;

import com.dynoware.cargosafe.platform.requestService.domain.model.valueobjects.StatusName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusName name;

    protected Status() {}

    public Status(StatusName name) {
        this.name = name;
    }
}
package com.minakov.railwayticketbooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "stations")
public class Station extends AbstractIdentifiable {

    @Column(name = "name")
    private String name;

    public Station(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public Station() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

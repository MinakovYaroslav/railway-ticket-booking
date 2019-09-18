package com.minakov.railwayticketbooking.model;

public abstract class AbstractIdentifiable {

    private Long id;

    public AbstractIdentifiable(Long id) {
        this.id = id;
    }

    public AbstractIdentifiable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

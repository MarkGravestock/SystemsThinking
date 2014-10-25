package com.markg1968.systemsthinking;

import static com.google.common.base.Preconditions.checkNotNull;

public class Stock {
    private String name;

    public Stock(String name) {
        checkNotNull(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Quantity getMeasure() {
        return Quantity.of(2, Unit.Litres);
    }
}

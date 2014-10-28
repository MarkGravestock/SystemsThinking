package com.markg1968.systemsthinking;

import static com.google.common.base.Preconditions.checkNotNull;

public class Flow {
    private String name;

    public Flow(String name) {
        checkNotNull(name);
        this.name = name;
    }

    public String getName() {

        return name;
    }

     public Quantity getMeasure(Time time) {

         return Quantity.of(1, Unit.Litres);
     }
}

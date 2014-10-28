package com.markg1968.systemsthinking;

import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;

public class Stock {
    private String name;
    private Flow inFlow;

    public Stock(String name, Flow inFlow) {
        checkNotNull(name);
        checkNotNull(inFlow);

        this.inFlow = inFlow;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Quantity getMeasure(Time time) {
        Stream<Time> times  = Time.asRange(time);
        ///CLOVER:OFF
        return times.map(inFlow::getMeasure).reduce(Quantity.of(0, Unit.Litres), (y, z) -> y.add(z));
        ///CLOVER:ON
    }
}

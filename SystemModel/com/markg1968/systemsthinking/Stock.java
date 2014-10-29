package com.markg1968.systemsthinking;

import java.util.Collection;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;

public class Stock {
    private String name;
    private Collection<Measurable> flow;
    private Quantity initialMeasure;

    public Stock(String name, Collection<Measurable> flow) {
        this(name, flow, Quantity.of(0, Unit.Litres));
    }

    public Stock(String name, Collection<Measurable> flow, Quantity initialMeasure) {
        checkNotNull(initialMeasure);
        checkNotNull(name);
        checkNotNull(flow);

        this.initialMeasure = initialMeasure;
        this.flow = flow;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Quantity getMeasure(Time time) {
        Stream<Time> times  = Time.asRange(time);
        ///CLOVER:OFF
        // TODO How do I create an intermediate Func<TResult, T1, T2> to aid comprehensibility
        return times.map(timeLocal -> flow.stream().map(x -> x.getMeasure(timeLocal)).reduce(Quantity.of(0, Unit.Litres), (total, current) -> total.add(current))).reduce(initialMeasure, (y, z) -> y.add(z));
        ///CLOVER:ON
    }
}

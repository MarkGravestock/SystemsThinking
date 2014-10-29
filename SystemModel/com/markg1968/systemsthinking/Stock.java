package com.markg1968.systemsthinking;

import com.google.common.collect.ImmutableSet;

import java.util.Collection;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;

public class Stock {
    private String name;
    private Collection<Measurable> flow;

    public Stock(String name, Measurable inFlow) {
        this(name, ImmutableSet.of(inFlow));
    }

    public Stock(String name, Collection<Measurable> flow) {
        checkNotNull(name);
        checkNotNull(flow);

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
        return times.map(timeLocal -> flow.stream().map(x -> x.getMeasure(timeLocal)).reduce(Quantity.of(0, Unit.Litres), (total, current) -> total.add(current))).reduce(Quantity.of(0, Unit.Litres), (y, z) -> y.add(z));
        ///CLOVER:ON
    }
}

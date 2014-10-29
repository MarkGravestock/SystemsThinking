package com.markg1968.systemsthinking;

import clover.com.google.common.collect.ImmutableSet;

public class FixedOutflow extends Flow {
    public FixedOutflow(String name) {
        super(name, ImmutableSet.of(new FixedRateFlowCalculator(Quantity.of(-1, Unit.Litres))));
    }
}

package com.markg1968.systemsthinking.system;

import clover.com.google.common.collect.ImmutableSet;
import com.markg1968.systemsthinking.*;

public class DelayedFixedInflow extends Flow {
    public DelayedFixedInflow(String name) {
        super(name, ImmutableSet.of(new DelayedFixedRateFlowCalculator(Quantity.of(1, Unit.Litres), Time.atSeconds(2)), new ZeroFlowCalculator()));
    }
}

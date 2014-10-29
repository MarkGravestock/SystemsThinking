package com.markg1968.systemsthinking.system;

import com.markg1968.systemsthinking.FixedRateFlowCalculator;
import com.markg1968.systemsthinking.Quantity;
import com.markg1968.systemsthinking.Time;

import static com.google.common.base.Preconditions.checkNotNull;

public class DelayedFixedRateFlowCalculator extends FixedRateFlowCalculator {

    private Time start;

    public DelayedFixedRateFlowCalculator(Quantity flowRate,  Time start) {

        super(flowRate);

        checkNotNull(start);
        this.start = start;
    }

    @Override
    public boolean canCalculate(Time atTime) {
        return atTime.isAfter(start);
    }
}

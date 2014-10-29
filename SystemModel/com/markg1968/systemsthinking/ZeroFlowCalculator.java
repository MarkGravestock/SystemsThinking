package com.markg1968.systemsthinking;

import java.math.BigDecimal;

public class ZeroFlowCalculator implements FlowCalculator {

    @Override
    public boolean canCalculate(Time atTime) {
        return true;
    }

    @Override
    public Quantity getMeasure(Time time) {
        return Quantity.of(BigDecimal.ZERO, Unit.Litres);
    }
}

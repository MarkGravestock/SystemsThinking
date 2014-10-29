package com.markg1968.systemsthinking;

public class FixedRateFlowCalculator implements FlowCalculator {
    private Quantity flowRate;

    public FixedRateFlowCalculator(Quantity flowRate) {
        this.flowRate = flowRate;
    }

    @Override
    public boolean canCalculate(Time atTime) {
        return true;
    }

    @Override
    public Quantity getMeasure(Time time) {
        return flowRate;
    }
}

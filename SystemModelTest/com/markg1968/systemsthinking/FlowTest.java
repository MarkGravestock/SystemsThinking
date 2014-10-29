package com.markg1968.systemsthinking;

import clover.com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FlowTest {
    public static final String FLOW_NAME = "Tap";

    private Quantity expectedFlowRate = Quantity.of(1, Unit.Litres);
    private Flow sut;

    @Before
    public void setup() {

        sut = new Flow(FLOW_NAME, ImmutableSet.of(new FixedRateFlowCalculator(expectedFlowRate)));
    }

    @Test
    public void aFlowHasAName() {

        assertThat(sut.getName(), is(equalTo(FLOW_NAME)));
    }

    @Test(expected = IllegalStateException.class)
    public void aFlowNeedsACalculatorThatCanCalculate() {
        sut = new Flow(FLOW_NAME, ImmutableSet.of());
        sut.getMeasure(Time.atSeconds(1));
    }

    @Test
    public void aFlowHasAMeasureAtAGivenTime() {

        assertThat(sut.getMeasure(Time.atSeconds(1)), is(equalTo(expectedFlowRate)));
    }

    @Test
    public void aFlowIsTakenFromFirstMatchingCalculator() {
        Quantity expectedFirstFlowRate = Quantity.of(2, Unit.Litres);

        sut = new Flow(FLOW_NAME, ImmutableSet.of(new NeverCanCalculateFlowCalculator(), new FixedRateFlowCalculator(expectedFirstFlowRate), new FixedRateFlowCalculator(Quantity.of(5, Unit.Litres))));

        assertThat(sut.getMeasure(Time.atSeconds(1)), is(equalTo(expectedFirstFlowRate)));
    }

    private class NeverCanCalculateFlowCalculator implements FlowCalculator {

        @Override
        public boolean canCalculate(Time atTime) {
            return false;
        }

        @Override
        public Quantity getMeasure(Time time) {
            return null;
        }
    }

}

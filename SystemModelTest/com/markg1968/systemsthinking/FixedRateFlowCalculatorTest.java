package com.markg1968.systemsthinking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FixedRateFlowCalculatorTest {

    private Quantity expectedFlowRate = Quantity.of(3, Unit.Litres);
    private FixedRateFlowCalculator sut;

    @Before
    public void setUp() throws Exception {
        sut = new FixedRateFlowCalculator(expectedFlowRate);
    }

    @Test
    public void testCanCaculate() throws Exception {
       assertThat(sut.canCalculate(Time.atSeconds(1)), is(true));
    }

    @Test
    public void testGetMeasure() throws Exception {
        assertThat(sut.getMeasure(Time.atSeconds(1)), is(equalTo(expectedFlowRate)));
    }
}
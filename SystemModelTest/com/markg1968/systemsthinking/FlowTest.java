package com.markg1968.systemsthinking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FlowTest {
    public static final String FLOW_NAME = "Tap";

    private Flow sut;

    @Before
    public void setup() {
        sut = new Flow(FLOW_NAME);
    }

    @Test
    public void aFlowHasAName() {
        assertThat(sut.getName(), is(equalTo(FLOW_NAME)));
    }

    @Test
    public void aFlowHasAMeasureAtAGivenTime() {
        assertThat(sut.getMeasure(Time.atSeconds(1)), is(equalTo(Quantity.of(1, Unit.Litres))));
    }
}

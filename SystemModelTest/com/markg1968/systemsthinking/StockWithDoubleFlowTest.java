package com.markg1968.systemsthinking;

import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class StockWithDoubleFlowTest {

    public static final String STOCK_NAME = "Bath";
    public static final String IN_FLOW_NAME = "Tap";
    public static final String OUT_FLOW_NAME = "Plug";

    private Stock sut;

    @Before
    public void setup() {

        sut = new Stock(STOCK_NAME, ImmutableSet.of(new FixedInflow(IN_FLOW_NAME), new FixedOutflow(OUT_FLOW_NAME)));
    }

    @Test
    public void aStockHasTheCorrectMeasureAtAPointTimeFromBothFlows() {

        assertThat(sut.getMeasure(Time.atSeconds(2)), is(equalTo(Quantity.of(0, Unit.Litres))));
    }

}

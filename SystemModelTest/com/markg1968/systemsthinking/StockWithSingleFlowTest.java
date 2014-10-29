package com.markg1968.systemsthinking;

import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class StockWithSingleFlowTest {

    public static final String STOCK_NAME = "Bath";
    public static final String FLOW_NAME = "Tap";

    private Stock sut;

    @Before
    public void setup() {

        sut = new Stock(STOCK_NAME, ImmutableSet.of(new FixedInflow(FLOW_NAME)));
    }

    @Test
    public void aStockHasAName() {

        assertThat(sut.getName(), is(equalTo(STOCK_NAME)));
    }

    @Test
    public void aStockHasTheCorrectMeasureAtAnInitialPointInTime() {

        assertThat(sut.getMeasure(Time.atSeconds(1)), is(equalTo(Quantity.of(1, Unit.Litres))));
    }

    @Test
    public void aStockHasTheCorrectMeasureAtALaterPointTime() {

        assertThat(sut.getMeasure(Time.atSeconds(2)), is(equalTo(Quantity.of(2, Unit.Litres))));
    }

    @Test
    public void aStockHasTheCorrectMeasureAtAnEvenLaterPointTime() {

        assertThat(sut.getMeasure(Time.atSeconds(10)), is(equalTo(Quantity.of(10, Unit.Litres))));
    }

    @Test
    public void aStockHasTheCorrectMeasureAtAPointTimeWhenItHasAnInitialMeasure() {
        sut = new Stock(STOCK_NAME, ImmutableSet.of(new FixedInflow(FLOW_NAME)), Quantity.of(10, Unit.Litres));

        assertThat(sut.getMeasure(Time.atSeconds(10)), is(equalTo(Quantity.of(20, Unit.Litres))));
    }
}

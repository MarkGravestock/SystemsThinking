package com.markg1968.systemsthinking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class StockTest {

    public static final String STOCK_NAME = "Bath";

    private Stock sut;

    @Before
    public void setup() {
        sut = new Stock(STOCK_NAME);
    }

    @Test
    public void aStockHasAName() {
        assertThat(sut.getName(), is(equalTo(STOCK_NAME)));
    }

    @Test
    public void aStockHasAMeasure() {
        assertThat(sut.getMeasure(), is(equalTo(Quantity.of(2, Unit.Litres))));
    }
}
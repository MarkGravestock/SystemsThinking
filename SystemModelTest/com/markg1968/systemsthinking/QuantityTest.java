package com.markg1968.systemsthinking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QuantityTest {

    @Test
    public void testPlus() throws Exception {
        assertThat(Quantity.of(5, Unit.Litres).add(Quantity.of(8, Unit.Litres)), is(equalTo(Quantity.of(13, Unit.Litres))));
    }
}
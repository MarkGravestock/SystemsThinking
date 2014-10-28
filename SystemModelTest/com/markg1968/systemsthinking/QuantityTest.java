package com.markg1968.systemsthinking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class QuantityTest {

    @Test
    public void testPlus() throws Exception {

        assertThat(Quantity.of(5, Unit.Litres).add(Quantity.of(8, Unit.Litres)), is(equalTo(Quantity.of(13, Unit.Litres))));
    }

    @Test
    public void whenAQuantityHasEqualPropertiesThenItIsEqual() {

        assertThat(Quantity.of(4, Unit.Litres), is(equalTo(Quantity.of(4, Unit.Litres))));
    }

    @Test
    public void whenAQuantityHasEqualPropertiesThenItHasAnEqualHashCode() {

        assertThat(Quantity.of(4, Unit.Litres).hashCode(), is(equalTo(Quantity.of(4, Unit.Litres).hashCode())));
    }

    @Test
    public void whenAQuantityHasEqualPropertiesButItIsNotTheSameInstance() {

        assertThat(Quantity.of(4, Unit.Litres), is(not(sameInstance(Quantity.of(4, Unit.Litres)))));
    }

    @Test
    public void aQuantityHasTheExpectedToString() {

        assertThat(Quantity.of(4, Unit.Litres).toString(), is(equalTo("4 Litres")));
    }

}
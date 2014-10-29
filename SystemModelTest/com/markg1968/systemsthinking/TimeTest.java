package com.markg1968.systemsthinking;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class TimeTest {

    @Test
    public void testAtSeconds() throws Exception {
        Time sut = Time.atSeconds(1);
        assertThat(sut, is(equalTo(Time.atSeconds(1))));
    }

    @Test
    public void afterComparisonHasCorrectResult() throws Exception {
        Time sut = Time.atSeconds(1);
        assertThat(sut.isAfter(Time.atSeconds(0)), is(true));
    }

    @Test
    public void testOfRange() throws Exception {
        Stream<Time> times = Time.asRange(Time.atSeconds(3));
        assertThat(times.count(), is(equalTo(3L)));
    }

    @Test
    public void testOfZeroRange() throws Exception {
        Stream<Time> times = Time.asRange(Time.atSeconds(0));
        assertThat(times.count(), is(equalTo(0L)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOfNegativeRange() throws Exception {
        Time.asRange(Time.atSeconds(-1));
    }
}
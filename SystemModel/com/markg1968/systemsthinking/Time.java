package com.markg1968.systemsthinking;

import com.google.common.base.Preconditions;
import com.google.common.collect.*;

import java.math.BigDecimal;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Time extends Quantity {
    protected Time(BigDecimal magnitude, Unit unit) {

        super(magnitude, unit);
    }

    public static Time atSeconds(long seconds) {

        return new Time(BigDecimal.valueOf(seconds), Unit.Seconds);
    }

    protected static Iterable<Time> ofRange(Time upper) {

        ImmutableSortedSet<Long> values = ContiguousSet.create(Range.closed(1L, upper.magnitude.longValue()), DiscreteDomain.longs());
        return Iterables.transform(values, Time::atSeconds);
    }

    public static Stream<Time> asRange(Time upper) {
        Preconditions.checkArgument(upper.isAfter(Time.atSeconds(-1)));

        return upper.magnitude.longValue() > 0 ? StreamSupport.stream(ofRange(upper).spliterator(), false) : Stream.<Time>empty();
    }

    public boolean isAfter(Time comparison) {
        return magnitude.compareTo(comparison.magnitude) > 0;
    }
}
package com.markg1968.systemsthinking;

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
        return Iterables.transform(values, o -> Time.atSeconds(o));
    }

    public static Stream<Time> asRange(Time upper) {
        return StreamSupport.stream(ofRange(upper).spliterator(), false);
    }
}
package com.markg1968.systemsthinking;

import com.google.common.base.Preconditions;
import com.google.common.collect.*;

import java.math.BigDecimal;

public class Quantity implements Comparable {
    protected BigDecimal magnitude;
    private Unit unit;

    protected  Quantity(BigDecimal magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }
    public static Quantity of(BigDecimal magnitude, Unit unit) {
        return new Quantity(magnitude, unit);
    }

    public static Quantity of(long amount, Unit unit) {
        return of(BigDecimal.valueOf(amount), unit);
    }

    public Quantity add(Quantity other) {
        Preconditions.checkArgument(unit.equals(other.unit));

        return of(other.magnitude.add(this.magnitude), unit);
    }

    protected static Iterable<Quantity> ofRange(long lower, long upper, Unit unit) {
        ImmutableSortedSet<Long> values = ContiguousSet.create(Range.closed(lower, upper), DiscreteDomain.longs());
        return Iterables.transform(values, o -> Quantity.of(o, unit));
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        return (other == this) || (
                other.getClass() == this.getClass() &&
                        equals((Quantity)other)
        );
    }

    private boolean equals(Quantity other) {
        return (other != null) && (
                other.unit.getClass() == this.unit.getClass() &&
                        other.magnitude.compareTo(this.magnitude) == 0
        );
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.magnitude != null ? this.magnitude.hashCode() : 0);
        hash = 97 * hash + (this.unit != null ? this.unit.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return magnitude + " " + unit.toString();
    }

    @Override
    public int compareTo(Object other) {
        return 0;
    }
}

package com.markg1968.systemsthinking;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.math.BigDecimal;

public class Quantity {
    protected BigDecimal magnitude;
    private Unit unit;

    protected Quantity(BigDecimal magnitude, Unit unit) {
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

        Preconditions.checkArgument(hasCompatibleUnits(other));

        return of(other.magnitude.add(this.magnitude), unit);
    }

    private boolean hasCompatibleUnits(Quantity other) {
        return unit.equals(other.unit);
    }

    @Override
    public boolean equals(Object other) {

        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {

        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {

        return magnitude + " " + unit.toString();
    }
}

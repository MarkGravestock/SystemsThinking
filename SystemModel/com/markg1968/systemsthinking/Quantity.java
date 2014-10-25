package com.markg1968.systemsthinking;

import java.math.BigDecimal;

public class Quantity {
    private BigDecimal magnitude;
    private Unit unit;

    public static Quantity of(BigDecimal magnitude, Unit unit) {
        Quantity quantity = new Quantity();
        quantity.magnitude = magnitude;
        quantity.unit = unit;
        return quantity;
    }

    public static Quantity of(int amount, Unit unit) {
        return of(BigDecimal.valueOf(amount), unit);
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
}

package org.nikolay.mortageplan.money;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Money class represents decimal based on double type.
 * Monay has immutable state
 */
public final class Money {

    private final double value;

    public static final Money ZERO = new Money(0.0);
    public static final Money ONE = new Money(1.0);

    /**
     * Create Money instance from double value
     * @param value represents amount of money
     */
    public Money(double value) {
        this.value = value;
    }

    /**
     * Adds provided Money value to current value with creating new Money instance
     *
     * @param value which will be added
     * @return new Money which is this + value
     */
    @NonNull
    Money add(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value + value.value);
    }

    /**
     * Subtract provided Money value from current value with creating new Money instance
     *
     * @param value which will be subtracted
     * @return new Money which is this - value
     */
    @NonNull
    Money sub(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value - value.value);
    }

    /**
     * Multiply current Money value by provided value
     *
     * @param value which is multiplier of current value
     * @return new Money which is this * value
     */
    @NonNull
    Money mul(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value * value.value);
    }

    /**
     * Divides current Money value by provided value.
     * It throws ArithmeticException in case if result of the operation cannot be represented
     *
     * @param value which is divider of current value
     * @return new Money which is this / value
     */
    @NonNull
    Money div(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value / value.value);
    }

    /**
     * Returns a BigDecimal whose value is (thisn), The power is computed exactly, to unlimited precision.
     * The parameter n must be in the range 0 through 450, inclusive. ZERO.pow(0) returns ONE.
     *
     * @param n
     * @return
     */
    @NonNull
    Money pow(int n) {
        if(n < 0 || n > 450) {
            throw new IllegalArgumentException("N value in pow function can't be less than 0 or more than 450: " + n);
        }

        double result = 1.0;

        for(int i = 0; i < n; ++i) {
            result *= value;
        }

        return new Money(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return Double.compare(money.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(round(value));
    }

    private static double round(double value) {
        return (long)(value * 100 + 0.5) / 100.0;
    }
}

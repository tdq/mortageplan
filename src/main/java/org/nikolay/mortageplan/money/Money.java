package org.nikolay.mortageplan.money;

import org.springframework.lang.NonNull;

// TODO get rid of java.Math
import java.util.Objects;

public final class Money {

    private static final double MULTIPLIER = 10000;

    private final long value;

    public static final Money ZERO = new Money(0);
    public static final Money ONE = new Money(1);

    public Money(double value) {
        this.value = (long) (value * MULTIPLIER);
    }

    public Money(long value) {
        this.value = (long) (value * MULTIPLIER);
    }

    private Money(long value, boolean raw) {
        this.value = (long) (value * (raw ? 1 : MULTIPLIER));
    }

    @NonNull
    Money add(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value + value.value, true);
    }

    @NonNull
    Money sub(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value - value.value, true);
    }

    @NonNull
    Money mul(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money((long) (this.value * (value.value / (double) MULTIPLIER)), true);
    }

    @NonNull
    Money div(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money((long) (this.value / (value.value / (double) MULTIPLIER)), true);
    }

    @NonNull
    Money pow(int n) {
        long result = 1;
        long value = (long) (this.value / (double) MULTIPLIER);

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
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf((long)((value / (double) MULTIPLIER + 0.005) * 100) / 100.0);
    }
}

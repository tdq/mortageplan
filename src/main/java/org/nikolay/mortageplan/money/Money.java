package org.nikolay.mortageplan.money;

import org.springframework.lang.NonNull;

import java.util.Objects;

/**
 * Money class represents decimal with fixed float point.
 * Link: https://habr.com/en/company/xakep/blog/257897/
 */
public final class Money {

    private static final long MULTIPLIER = (long) 1e+18;

    private final double value;

    public static final Money ZERO = new Money(0);
    public static final Money ONE = new Money(1);

    public Money(double value) {
        this.value = value;
    }

    @NonNull
    Money add(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value + value.value);
    }

    @NonNull
    Money sub(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value - value.value);
    }

    @NonNull
    Money mul(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value * value.value);
    }

    @NonNull
    Money div(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value / value.value);
    }

    @NonNull
    Money pow(int n) {
        long result = 1;

        for(int i = 0; i < n; ++i) {
            result *= value;
        }

        return new Money(result);
    }

    @Override
    public String toString() {
        return String.valueOf((long)(value * 100 + 0.5) / 100.0);
    }
}

package org.nikolay.mortageplan.money;

import org.springframework.lang.NonNull;

import java.util.Objects;

/**
 * Money class represents decimal with fixed float point.
 * Link: https://habr.com/en/company/xakep/blog/257897/
 */
public final class Money {

    private static final long MULTIPLIER = (long) 1e+18;

    private final long intValue;
    private final long floatValue;

    public static final Money ZERO = new Money(0, 0);
    public static final Money ONE = new Money(1, 0);

    public Money(double value) {
        // This looks like magic, but it find maximum int value which is less than double value
        this.intValue = value < 0 ? (long) (value - 0.5) : (long) value;
        this.floatValue = (long) ((value - intValue) * MULTIPLIER);
    }

    public Money(long value) {
        this.intValue = (long) (value * MULTIPLIER);
        this.floatValue = 0L;
    }

    private Money(long intValue, long floatValue) {
        this.intValue = intValue;
        this.floatValue = floatValue;
    }

    @NonNull
    Money add(@NonNull Money value) {
        Objects.requireNonNull(value);

        long newIntValue = intValue + value.intValue;
        long newFloatValue = floatValue + value.floatValue;

        // TODO check that newIntValue < MULTIPLIER

        if(newFloatValue >= MULTIPLIER) {
            newFloatValue -= MULTIPLIER;
            ++newIntValue;
        }

        return new Money(newIntValue, newFloatValue);
    }

    @NonNull
    Money sub(@NonNull Money value) {
        Objects.requireNonNull(value);

        long newIntValue = intValue - value.intValue;
        long newFloatValue;

        if(floatValue >= value.floatValue) {
            newFloatValue = floatValue - value.floatValue;
        } else {
            newFloatValue = MULTIPLIER - value.floatValue + floatValue;
            --newIntValue;
        }

        return new Money(newIntValue, newFloatValue);
    }

    @NonNull
    Money mul(@NonNull Money value) {
        Objects.requireNonNull(value);

        //return new Money((long) (this.value * (value.value / (double) MULTIPLIER)), true);
        return Money.ONE;
    }

    @NonNull
    Money div(@NonNull Money value) {
        Objects.requireNonNull(value);

        //return new Money((long) (this.value / (value.value / (double) MULTIPLIER)), true);
        return Money.ONE;
    }

    @NonNull
    Money pow(int n) {
        /*
        long result = 1;
        long value = (long) (this.value / (double) MULTIPLIER);

        for(int i = 0; i < n; ++i) {
            result *= value;
        }

        return new Money(result);

         */
        return Money.ONE;
    }

    @Override
    public String toString() {
        double value = intValue + floatValue / (double) MULTIPLIER;

        return String.valueOf((long)(value * 100 + 0.5) / 100.0);
    }
}

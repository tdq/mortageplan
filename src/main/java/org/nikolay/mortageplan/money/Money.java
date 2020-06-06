package org.nikolay.mortageplan.money;

import org.springframework.lang.NonNull;

// TODO get rid of java.Math
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private final BigDecimal value;

    public static final Money ZERO = new Money(0);
    public static final Money ONE = new Money(1);

    public Money(double value) {
        this.value = BigDecimal.valueOf(value);
    }

    public Money(long value) {
        this.value = BigDecimal.valueOf(value);
    }

    private Money(BigDecimal value) {
        this.value = value;
    }

    @NonNull
    Money add(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value.add(value.value));
    }

    @NonNull
    Money sub(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value.subtract(value.value));
    }

    @NonNull
    Money mul(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value.multiply(value.value));
    }

    @NonNull
    Money div(@NonNull Money value) {
        Objects.requireNonNull(value);

        return new Money(this.value.divide(value.value, 2, RoundingMode.HALF_UP));
    }

    @NonNull
    Money pow(int n) {
        return new Money(this.value.pow(n));
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
}

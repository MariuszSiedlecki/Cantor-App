package cantor.model;

import cantor.office.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeModel {
    private Currency currencyFrom;
    private Currency currencyTo;
    private BigDecimal value;
    private LocalDate date;
    private String rate;
    private BigDecimal margin;

    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getRate() {
        return rate;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public ExchangeModel(Builder builder) {
        this.currencyFrom = builder.currencyFrom;
        this.currencyTo = builder.currencyTo;
        this.value = builder.value;
        this.date = builder.date;
        this.rate = builder.rate;
        this.margin = builder.margin;
    }

    public static class Builder {
        private Currency currencyFrom;
        private Currency currencyTo;
        private BigDecimal value;
        private LocalDate date;
        private String rate;
        private BigDecimal margin;

        public Builder currencyFrom(Currency currencyFrom) {
            this.currencyFrom = currencyFrom;
            return this;
        }

        public Builder currencyTo(Currency currencyTo) {
            this.currencyTo = currencyTo;
            return this;
        }

        public Builder value(BigDecimal value) {
            this.value = value;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder rate(String rate) {
            this.rate = rate;
            return this;
        }

        public Builder margin(BigDecimal margin) {
            this.margin = margin;
            return this;
        }

        public ExchangeModel build() {
            return new ExchangeModel(this);
        }
    }
}

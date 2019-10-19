package cantor.model;

import cantor.office.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CurrencyApplicationModels {
    private BigDecimal result, margin, rate, amount;
    private Currency from, to;
    private LocalDate date;

    public CurrencyApplicationModels(Builder b) {
        this.result = b.result;
        this.margin = b.margin;
        this.rate = b.rate;
        this.amount = b.amount;
        this.from = b.from;
        this.to = b.to;
        this.date = b.date;
    }

    public BigDecimal getResult() {
        return result;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setFrom(Currency from) {
        this.from = from;
    }

    public void setTo(Currency to) {
        this.to = to;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static class Builder {
      private BigDecimal  result,margin,rate,amount;
        private Currency from, to;
        private LocalDate date;


        public Builder result(BigDecimal result) {
            this.result = result;
            return this;
        }

        public Builder margin(BigDecimal margin) {
            this.margin = margin;
            return this;
        }

        public Builder rate(BigDecimal rate) {
            this.rate = rate;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder from(Currency from) {
            this.from = from;
            return this;
        }

        public Builder to(Currency to) {
            this.to = to;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public CurrencyApplicationModels build(){
            return new CurrencyApplicationModels(this);
        }
    }
}
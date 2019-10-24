package cantor.office;

public enum Currency {
    PLN("PLN"),
    EUR("EUR"),
    RUB("RUB"),
    GBP("GBP"),
    CHF("CHF"),
    USD("USD");


    private String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

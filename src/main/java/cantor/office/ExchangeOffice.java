package cantor.office;

import cantor.model.CurrencyApplicationModels;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static cantor.library.Constance.MARGIN_VALUE;

public class ExchangeOffice {
    private Map<Currency, BigDecimal> availableFounds;
    public static final Logger LOGGER = Logger.getLogger(ExchangeOffice.class.getName());


    public ExchangeOffice(double startFounds) {
        this.availableFounds = new HashMap<>();
        for (Currency c : Currency.values()) {
            this.availableFounds.put(c, new BigDecimal(startFounds));

        }
    }

    public ExchangeOffice(Currency currency, double startFounds) {
        this.availableFounds = new HashMap<>();

        this.availableFounds.put(currency, new BigDecimal(startFounds));
    }

    public void showFunds() {
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        for (Map.Entry<Currency, BigDecimal> entry : availableFounds.entrySet()) {
            LOGGER.info("currency :" + decimalFormat.format(entry.getValue()) + " " + entry.getKey().getName() + "\n");
        }
    }

    public CurrencyApplicationModels exchange(BigDecimal amount, Currency from, Currency to) {
        BigDecimal available = availableFounds.get(to);
        BigDecimal course = CurrencyConverter.convert(from, to);
        BigDecimal marginValue = new BigDecimal(MARGIN_VALUE);
        BigDecimal needed = amount.multiply(marginValue).multiply(course);

        DecimalFormat decimalFormat = new DecimalFormat("##.00");

        if (available.intValue() >= needed.intValue()) {
            availableFounds.put(from, availableFounds.get(from).add(amount));
            availableFounds.put(to, availableFounds.get(to).subtract(needed));

            LOGGER.info("Exchange"
                    + decimalFormat.format(amount) + " "
                    + from.getName()
                    + "to"
                    + decimalFormat.format(needed)
                    + to.getName());

        } else {
            LOGGER.info("Cannot exchange " + decimalFormat.format(amount)
                    + " " + from.getName()
                    + "to " + decimalFormat.format(needed)
                    + " " + to.getName()
                    + "insufficient founds ! ");
        }
        return new CurrencyApplicationModels.Builder()
                .amount(amount)
                .from(from)
                .to(to)
                .margin(marginValue)
                .rate(course)
                .result(needed)
                .build();
    }
}



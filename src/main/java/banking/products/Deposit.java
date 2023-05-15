package banking.products;

import banking.FinancialProduct;
import banking.HasInterestRate;

import java.math.BigDecimal;

public class Deposit extends FinancialProduct implements HasInterestRate {
    private double percent;

    public Deposit(String currency, BigDecimal balance, String name, double percent) {
        super(currency, balance, name);
        this.percent = percent;
    }

    @Override
    public double getPercent() {
        return percent;
    }

    @Override
    public void setPercent(double percent) {
        this.percent = percent;
    }
}

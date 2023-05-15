package banking.products;

import banking.FinancialProduct;
import banking.HasOverdraft;
import banking.HasInterestRate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCard extends FinancialProduct implements HasInterestRate, HasOverdraft {
    private double percent;

    public CreditCard(String currency, BigDecimal balance, String name, double percent) {
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

    @Override
    public void withdrawAmountWithOverdraft(BigDecimal amt) throws Exception {
        if (amt.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("You are trying to withdraw negative amount");
        }
        setBalance(getBalance().subtract(amt).setScale(getRounding(), RoundingMode.HALF_UP));
    }
}


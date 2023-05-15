package banking;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class FinancialProduct {
    private final String currency;
    private BigDecimal balance;
    private String name;

    private final int AMT_ROUNDING_SCALE = 2;

    public void putAmount(BigDecimal amt) throws Exception {
        if (amt.compareTo(BigDecimal.ZERO) >= 0) {
            balance = balance.add(amt).setScale(AMT_ROUNDING_SCALE, RoundingMode.HALF_UP);
        } else {
            throw new Exception("You are trying to put negative amount");
        }
    }

    public void withdrawAmountWithoutOverdraft(BigDecimal amt) throws Exception {
        if (amt.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("You are trying to withdraw negative amount");
        }
        if (balance.subtract(amt).compareTo(BigDecimal.ZERO) >= 0) {
            balance = balance.subtract(amt).setScale(AMT_ROUNDING_SCALE, RoundingMode.HALF_UP);
        } else {
            throw new Exception("There is not enough money on the card");
        }
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRounding() {
        return AMT_ROUNDING_SCALE;
    }

    public FinancialProduct(String currency, BigDecimal balance, String name) {
        this.currency = currency;
        this.balance = balance.setScale(AMT_ROUNDING_SCALE, RoundingMode.HALF_UP);
        this.name = name;
    }

    public BigDecimal getDebt() {
        if (getBalance().compareTo(BigDecimal.ZERO) > 0) {
            return BigDecimal.ZERO;
        } else {
            return getBalance();
        }
    }
}

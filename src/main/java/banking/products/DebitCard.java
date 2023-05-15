package banking.products;

import banking.FinancialProduct;

import java.math.BigDecimal;

public class DebitCard extends FinancialProduct {
    public DebitCard(String currency, BigDecimal balance, String name) {
        super(currency, balance, name);
    }
}

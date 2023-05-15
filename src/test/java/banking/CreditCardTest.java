package banking;

import banking.products.CreditCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CreditCardTest {
    CreditCard creditCard;

    @BeforeEach
    public void setUp() {
        creditCard = new CreditCard("Rub", BigDecimal.valueOf(1000), "Credit Card", 9.25);
    }

    @Test
    public void getPercent() {
        Assertions.assertEquals(9.25, creditCard.getPercent());
    }

    @Test
    public void whenSetPercentNewPercentApplied() {
        creditCard.setPercent(9.75);
        Assertions.assertEquals(9.75, creditCard.getPercent());

    }

    @Test
    public void whenWithdrawAmtWithOverdraftIsMoreThanBalanceBalanceReducedToNegative() throws Exception {
        creditCard.withdrawAmountWithOverdraft(BigDecimal.valueOf(1500.33));
        Assertions.assertEquals(new BigDecimal("-500.33"), creditCard.getBalance());
    }

    @Test
    public void whenDebtRequestedOnNegativeBalanceBalanceReturned() throws Exception {
        creditCard.withdrawAmountWithOverdraft(BigDecimal.valueOf(1750));
        Assertions.assertEquals(new BigDecimal("-750.00"), creditCard.getBalance());
        Assertions.assertEquals(new BigDecimal("-750.00"), creditCard.getDebt());
    }


}
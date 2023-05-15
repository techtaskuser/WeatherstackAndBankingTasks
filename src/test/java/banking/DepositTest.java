package banking;

import banking.products.Deposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class DepositTest {
    Deposit depo;

    @BeforeEach
    void setUp() {
        depo = new Deposit("USD", BigDecimal.ZERO, "My Deposit", 0.001);
    }

    @Test
    public void whenDepoCreatedItHasPopulatedFields() {
        Assertions.assertEquals("USD", depo.getCurrency());
        Assertions.assertEquals(new BigDecimal("0.00"), depo.getBalance());
        Assertions.assertEquals("My Deposit", depo.getName());
        Assertions.assertEquals(0.001, depo.getPercent());
    }

    @Test
    public void whenSetPercentPercentIsUpdated() {
        Assertions.assertEquals(0.001, depo.getPercent());
        depo.setPercent(0.1);
        Assertions.assertEquals(0.1, depo.getPercent());
    }
}
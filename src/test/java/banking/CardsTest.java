package banking;

import banking.products.DebitCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CardsTest {
    FinancialProduct debitCard;

    @BeforeEach
    public void setUp() {
        debitCard = new DebitCard("Rub", BigDecimal.valueOf(1000), "Debit Card");
    }

    @Test
    public void whenCardCreatedItHasPopulatedFields() {
        Assertions.assertEquals("Rub", debitCard.getCurrency());
        Assertions.assertEquals("Debit Card", debitCard.getName());
        Assertions.assertEquals(new BigDecimal("1000.00"), debitCard.getBalance());
    }

    @Test
    public void whenPutIntAmtOnBalanceAmtAdded() throws Exception {
        debitCard.putAmount(BigDecimal.valueOf(1500));
        Assertions.assertEquals(new BigDecimal("2500.00"), debitCard.getBalance());
    }

    @Test
    public void whenPutDecimalAmtOnBalanceAmtAdded() throws Exception {
        debitCard.putAmount(BigDecimal.valueOf(333.33));
        Assertions.assertEquals(new BigDecimal("1333.33"), debitCard.getBalance());
    }

    @Test
    public void whenPutZeroAmtOnBalanceAmtNotChanged() throws Exception {
        debitCard.putAmount(BigDecimal.valueOf(0));
        Assertions.assertEquals(new BigDecimal("1000.00"), debitCard.getBalance());
    }

    @Test
    public void whenPutAmtIsNegativeExceptionThrown()  {
        String expectedMessage = "You are trying to put negative amount";
        Exception exception = Assertions.assertThrows(Exception.class, () -> debitCard.putAmount(BigDecimal.valueOf(-500)));
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void whenWithdrawAmtBalanceChanged() throws Exception {
        debitCard.withdrawAmountWithoutOverdraft(BigDecimal.valueOf(700));
        Assertions.assertEquals(new BigDecimal("300.00"), debitCard.getBalance());
    }

    @Test
    public void whenWithdrawZeroAmtBalanceNotChanged() throws Exception {
        debitCard.withdrawAmountWithoutOverdraft(BigDecimal.valueOf(0));
        Assertions.assertEquals(new BigDecimal("1000.00"), debitCard.getBalance());
    }

    @Test
    public void whenWithdrawNegativeAmtExceptionThrown() {
        String expectedMessage = "You are trying to withdraw negative amount";
        Exception exception = Assertions.assertThrows(Exception.class, () -> debitCard.withdrawAmountWithoutOverdraft(BigDecimal.valueOf(-700)));
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void whenWithdrawAmtIsMoreThanBalanceExceptionThrown() {
        String expectedMessage = "There is not enough money on the card";
        Exception exception = Assertions.assertThrows(Exception.class, () -> debitCard.withdrawAmountWithoutOverdraft(BigDecimal.valueOf(1500)));
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }


    @Test
    public void whenCardNameIsChangedNewNameIsApplied() {
        debitCard.setName("New Name");
        Assertions.assertEquals("New Name", debitCard.getName());
    }

    @Test
    public void whenDebtRequestedOnPositiveBalanceZeroReturned() {
        Assertions.assertEquals(BigDecimal.ZERO, debitCard.getDebt());
    }


}
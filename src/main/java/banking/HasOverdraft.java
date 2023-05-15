package banking;

import java.math.BigDecimal;

public interface HasOverdraft {
    void withdrawAmountWithOverdraft(BigDecimal amt) throws Exception;
}

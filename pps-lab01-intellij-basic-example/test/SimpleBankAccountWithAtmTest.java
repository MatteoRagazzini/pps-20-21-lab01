import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest extends  BankAccountTest<SimpleBankAccountWithAtm>{

    @BeforeEach
    void beforeEach(){
        super.beforeEach();
        setBankAccount(new SimpleBankAccountWithAtm(getAccountHolder(), 0));
    }

    @Test
    void testDepositWithATM(){
        getBankAccount().depositWithATM(getAccountHolder().getId(), 100);
        assertEquals(100 - SimpleBankAccountWithAtm.ATM_FEE, getBankAccount().getBalance());
    }

    @Test
    void testWithdrawWithATM(){
        getBankAccount().depositWithATM(getAccountHolder().getId(), 100);
        getBankAccount().withdrawWithATM(getAccountHolder().getId(), 50);
        assertEquals(50 - 2 * SimpleBankAccountWithAtm.ATM_FEE, getBankAccount().getBalance());
    }

    @Test
    void testNoMoneyForWithdrawal(){
        getBankAccount().depositWithATM(getAccountHolder().getId(), 100);
        getBankAccount().withdrawWithATM(getAccountHolder().getId(), 100);
        assertEquals(100 - SimpleBankAccountWithAtm.ATM_FEE, getBankAccount().getBalance());
    }

}
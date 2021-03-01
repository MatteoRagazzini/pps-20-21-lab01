import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest extends  SimpleBankAccountTest{

    @BeforeEach
    void beforeEach(){
        super.beforeEach();
        setBankAccount(new SimpleBankAccountWithAtm(getAccountHolder(), 0));
    }

    @Test
    void testDepositWithATM(){
        ((SimpleBankAccountWithAtm)getBankAccount()).depositWithATM(getAccountHolder().getId(), 100);
        assertEquals(100 - SimpleBankAccountWithAtm.ATM_FEE, getBankAccount().getBalance());
    }

    @Test
    void testWithdrawWithATM(){
        ((SimpleBankAccountWithAtm)getBankAccount()).depositWithATM(getAccountHolder().getId(), 100);
        ((SimpleBankAccountWithAtm)getBankAccount()).withdrawWithATM(getAccountHolder().getId(), 50);
        assertEquals(50-2*SimpleBankAccountWithAtm.ATM_FEE, getBankAccount().getBalance());
    }

    @Test
    void testNoMoneyForWithdrawal(){
        ((SimpleBankAccountWithAtm)getBankAccount()).depositWithATM(getAccountHolder().getId(), 100);
        ((SimpleBankAccountWithAtm)getBankAccount()).withdrawWithATM(getAccountHolder().getId(), 100);
        assertEquals(100-SimpleBankAccountWithAtm.ATM_FEE, getBankAccount().getBalance());
    }

}
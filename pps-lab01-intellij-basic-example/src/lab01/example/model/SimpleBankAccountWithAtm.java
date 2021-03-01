package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount{
    public static final double ATM_FEE = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    public void depositWithATM(int id, int amount) {
        super.deposit(id,amount - ATM_FEE);
    }


    public void withdrawWithATM(int id, int amount) {
        super.withdraw(id, amount + ATM_FEE);
    }
}

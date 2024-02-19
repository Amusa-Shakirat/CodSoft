package task_three;

public class ATMTest {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("0108873004");

        ATM atm = new ATM("GTBank ATM");

        System.out.println(bankAccount);

        atm.deposit(bankAccount, 5000);
        System.out.println(bankAccount);

        atm.withdraw(bankAccount, 2000);
        System.out.println(bankAccount);

        atm.withdraw(bankAccount, 1000);
        System.out.println(bankAccount);

        atm.withdraw(bankAccount, 4000);
        System.out.println(bankAccount);

        atm.checkBalance(bankAccount);
        System.out.println(bankAccount);
    }
}

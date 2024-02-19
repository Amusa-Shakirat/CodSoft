package task_three;

public class ATM {
    private String name;

    public ATM(String name){
        this.name = name;
    }


    public double withdraw(BankAccount bankAccountFrom, double amountToWithdraw) {

        if( bankAccountFrom.getBalance() < amountToWithdraw ){
            System.out.println("Insufficient Funds");
            return -1;
        }
        bankAccountFrom.setBalance(bankAccountFrom.getBalance() - amountToWithdraw);
        return bankAccountFrom.getBalance();
    }

    public double deposit(BankAccount bankAccountTo, double amountToDeposit ) {
        if( amountToDeposit <= 0 ){
            System.out.println("Cannot deposit negative or zero amount");
            return -1;
        }
        bankAccountTo.setBalance(amountToDeposit + bankAccountTo.getBalance());
        return bankAccountTo.getBalance();
    }

    public double checkBalance(BankAccount bankAccountFrom){
        return bankAccountFrom.getBalance();
    }

}

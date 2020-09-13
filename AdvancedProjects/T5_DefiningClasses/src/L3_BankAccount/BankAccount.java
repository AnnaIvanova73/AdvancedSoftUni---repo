package L3_BankAccount;

public class BankAccount {

    private static int idCounter = 1;
    private static double interestRate = 0.02;

    private int id;
    private double balance;


    public BankAccount() {
        this.id = BankAccount.idCounter;
        BankAccount.idCounter++;
        System.out.println("Account ID" + this.id + " created");
    }

    public int getId() {
        return this.id;
    }

    public void setBalance(double depositToBalance) {
        this.balance += depositToBalance;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }


    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }
}

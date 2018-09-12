// ATTENTION 
// just edit this file
// TestAccount.java contains the test cases provided in the problem set 
// Put in any import statements that you need 


import java.util.Date;

public class Account {

    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated = new Date();

    //constructor

    public Account() {
    }

    public Account(int startId, double startBalance) {
        id = startId; // should have "this" or not ?
        balance = startBalance;
    }

    // accessor
    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


    // mutator
    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    // get interest rate
    public double getMonthlyInterestRate() {
        return this.annualInterestRate/12;
    }

    // get monthly interest
    public double getMonthlyInterest() {
        return this.balance * this.getMonthlyInterestRate()/100;
    }

    // withdraw
    public void withdraw(double money) {
        this.balance -= money;
    }

    // deposit
    public void deposit(double money) {
        this.balance += money;
    }
}

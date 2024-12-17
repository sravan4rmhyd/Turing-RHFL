/*package Memory462170;
abstract class FinancialAccount {
    private double balance;

    protected FinancialAccount(double initialBalance) {
        this.balance = initialBalance;
    }


    public abstract void deposit(double amount);


    public abstract void withdraw(double amount);


    public double getBalance() {
        return balance;
    }
}


class BankAccount extends FinancialAccount implements InterestCalculable {

    private double annualInterestRate;


    public BankAccount(double initialBalance, double annualInterestRate) {
        super(initialBalance);
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        balance -= amount;
    }


    @Override
    public double calculateInterest(int months) {
        if (months <= 0) {
            throw new IllegalArgumentException("Number of months must be positive.");
        }
        double monthlyInterestRate = annualInterestRate / 1200;
        double interest = balance * monthlyInterestRate * months;
        return interest;
    }
}


interface InterestCalculable {

    double calculateInterest(int months) throws IllegalArgumentException;
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0, 5.0);

        try {
            account.deposit(500.0);
            account.withdraw(300.0);

            double interestEarned = account.calculateInterest(6);
            System.out.println("Current Balance: " + account.getBalance());
            System.out.println("Interest Earned in 6 months: " + interestEarned);

            account.withdraw(2000.0);  // Will cause an InsufficientBalanceException

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}*/
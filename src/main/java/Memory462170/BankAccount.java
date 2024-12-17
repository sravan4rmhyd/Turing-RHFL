package Memory462170;
/**
 * A BankAccount class provides basic banking operations, inherits from {@link Account}, and implements {@link Withdrawable}.
 * <p>
 * It supports depositing funds and calculating the balance.
 *
 * @author Your Name
 * @version 1.0
 */
public class BankAccount extends Account implements Withdrawable {

    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        super(accountHolder);
        this.balance = initialBalance;
    }

    /**
     * Deposits a specified amount into the bank account.
     *
     * @param depositAmount the amount to be deposited (must be non-negative).
     *                      A negative deposit will be silently ignored.
     */
    public void deposit(double depositAmount) {
        if (depositAmount >= 0) {
            balance += depositAmount;
        }
    }

    /**
     * Withdraws a specified amount from the bank account.
     *
     * @param withdrawalAmount the amount to be withdrawn.
     * @return the amount actually withdrawn, which may be less than the requested amount if
     *         the account balance is insufficient.
     * @throws InsufficientFundsException if the withdrawal amount exceeds the available balance.
     */
    @Override
    public double withdraw(double withdrawalAmount) throws InsufficientFundsException {
        if (withdrawalAmount <= 0) {
            return 0;
        }
        if (withdrawalAmount > balance) {
            throw new InsufficientFundsException("Insufficient balance");
        }
        balance -= withdrawalAmount;
        return withdrawalAmount;
    }

    /**
     * Calculates the current balance of the bank account.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Example usage of {@link BankAccount} to perform a withdrawal.
     */
    public static void main(String[] args) {
        try {
            BankAccount account = new BankAccount("Alice", 100.0);
            account.deposit(50.0);
            double withdrawnAmount = account.withdraw(75.0);
            System.out.println("Withdrew: $" + withdrawnAmount);
            System.out.println("Balance: $" + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }
}


/**
 * Represents an account with a holder's name.
 */
class Account {

    private String accountHolder;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

/**
 * Defines the operation to withdraw funds from an account.
 */
interface Withdrawable {
    double withdraw(double amount) throws InsufficientFundsException;
}

/**
 * Custom exception thrown when an account does not have enough funds for a withdrawal.
 */
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
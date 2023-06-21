import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
        // Initialize dummy accounts
        accounts.put("1234567890", new Account("1234567890", 1234, 1000));
        accounts.put("0987654321", new Account("0987654321", 4321, 2000));
    }

    public double getBalance(String accountNumber, int pin) {
        Account account = accounts.get(accountNumber);
        if (account != null && account.getPin() == pin) {
            return account.getBalance();
        }
        return -1; // Indicates invalid account or PIN
    }

    public boolean withdraw(String accountNumber, int pin, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null && account.getPin() == pin && account.getBalance() >= amount) {
            account.decreaseBalance(amount);
            return true;
        }
        return false; // Indicates invalid account, PIN, or insufficient funds
    }

    public boolean deposit(String accountNumber, int pin, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null && account.getPin() == pin) {
            account.increaseBalance(amount);
            return true;
        }
        return false; // Indicates invalid account or PIN
    }

    public boolean transfer(String sourceAccountNumber, int pin, String destinationAccountNumber, double amount) {
        Account sourceAccount = accounts.get(sourceAccountNumber);
        Account destinationAccount = accounts.get(destinationAccountNumber);
        if (sourceAccount != null && destinationAccount != null && sourceAccount.getPin() == pin && sourceAccount.getBalance() >= amount) {
            sourceAccount.decreaseBalance(amount);
            destinationAccount.increaseBalance(amount);
            return true;
        }
        return false; // Indicates invalid account, PIN, or insufficient funds
    }

    public String getAccountStatement(String accountNumber, int pin) {
        Account account = accounts.get(accountNumber);
        if (account != null && account.getPin() == pin) {
            return account.getAccountStatement();
        }
        return null; // Indicates invalid account or PIN
    }
}

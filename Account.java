import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private String accountNumber;
    private int pin;
    private double balance;
    private StringBuilder accountStatement;

    public Account(String accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.accountStatement = new StringBuilder();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double amount) {
        balance += amount;
        addStatementEntry("Deposit", amount);
    }

    public void decreaseBalance(double amount) {
        balance -= amount;
        addStatementEntry("Withdrawal", -amount);
    }

    private void addStatementEntry(String transactionType, double amount) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        accountStatement.append(formattedDateTime)
                .append(" - ")
                .append(transactionType)
                .append(": $")
                .append(amount)
                .append("\n");
    }

    public String getAccountStatement() {
        return accountStatement.toString();
    }
}

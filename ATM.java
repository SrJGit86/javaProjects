import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Scanner scanner;

    public ATM() {
        bank = new Bank();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    handleBalanceInquiry();
                    break;
                case 2:
                    handleCashWithdrawal();
                    break;
                case 3:
                    handleDepositFunds();
                    break;
                case 4:
                    handleFundTransfer();
                    break;
                case 5:
                    handleAccountStatement();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Take Care!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        } while (option != 6);
    }

    private void displayMenu() {
        System.out.println("ATM Simulator");
        System.out.println("1. Balance Inquiry");
        System.out.println("2. Cash Withdrawal");
        System.out.println("3. Deposit Funds");
        System.out.println("4. Fund Transfer");
        System.out.println("5. Account Statement");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void handleBalanceInquiry() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        double balance = bank.getBalance(accountNumber, pin);
        if (balance != -1) {
            System.out.println("Your account balance is: $" + balance);
        } else {
            System.out.println("Invalid account number or PIN.");
        }
    }

    private void handleCashWithdrawal() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        boolean success = bank.withdraw(accountNumber, pin, amount);
        if (success) {
            System.out.println("Amount $" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid account number, PIN, or insufficient funds.");
        }
    }

    private void handleDepositFunds() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        boolean success = bank.deposit(accountNumber, pin, amount);
        if (success) {
            System.out.println("Amount $" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid account number or PIN.");
        }
    }

    private void handleFundTransfer() {
        System.out.print("Enter your account number: ");
        String sourceAccountNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter the recipient's account number: ");
        String destinationAccountNumber = scanner.nextLine();

        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        boolean success = bank.transfer(sourceAccountNumber, pin, destinationAccountNumber, amount);
        if (success) {
            System.out.println("Amount $" + amount + " transferred successfully.");
        } else {
            System.out.println("Invalid account number, PIN, or insufficient funds.");
        }
    }

    private void handleAccountStatement() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String statement = bank.getAccountStatement(accountNumber, pin);
        if (statement != null) {
            System.out.println("Account Statement:\n" + statement);
        } else {
            System.out.println("Invalid account number or PIN.");
        }
    }
}

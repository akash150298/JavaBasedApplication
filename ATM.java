import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Account currentAccount = null;

    public static void main(String[] args) {
        // Create some initial accounts
        accounts.put("12345", new Account("12345", "John Doe", 1000));
        accounts.put("67890", new Account("67890", "Jane Smith", 2000));

        System.out.println("Welcome to the ATM Management System");
        
        // ATM loop for user interaction
        while (true) {
            // If the user is not logged in, show login menu
            if (currentAccount == null) {
                loginMenu();
            } else {
                // If logged in, show main menu
                mainMenu();
            }
        }
    }

    // Login menu
    private static void loginMenu() {
        System.out.println("Please enter your account number:");
        String accountNumber = scanner.nextLine();

        System.out.println("Please enter your account holder name:");
        String accountHolderName = scanner.nextLine();

        Account account = accounts.get(accountNumber);

        if (account != null && account.getAccountHolderName().equals(accountHolderName)) {
            currentAccount = account;
            System.out.println("Login successful. Welcome " + accountHolderName + "!");
        } else {
            System.out.println("Invalid account number or account holder name. Please try again.");
        }
    }

    // Main menu after login
    private static void mainMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                currentAccount.checkBalance();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrawMoney();
                break;
            case 4:
                logout();
                break;
            case 5:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    // Method for deposit
    private static void depositMoney() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
    }

    // Method for withdrawal
    private static void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        currentAccount.withdraw(amount);
    }

    // Logout method
    private static void logout() {
        currentAccount = null;
        System.out.println("You have logged out.");
    }
}

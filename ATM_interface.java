 import java.util.Scanner;
 class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }
}


class ATM {
    private BankAccount account;
    private Scanner sc;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    // ATM Menu
    public void showMenu() {
        while (true) {
            System.out.println("\n----- ATM MENU -----");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> withdrawMoney();
                case 2 -> depositMoney();
                case 3 -> checkBalance();
                case 4 -> {
                    System.out.println("Thank you for using ATM!");
                    return;
                }
                default -> System.out.println("Invalid Choice! Try again.");
            }
        }
    }

    // Withdraw
    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    // Deposit
    private void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    // Balance check
    private void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    // Main method
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}

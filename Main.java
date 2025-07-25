import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option1 = 0, option2;

        do {
            System.out.println("""
                    Please choose:
                    1> Create a new account
                    2> Existing account
                    3> Close the program
                    """);

            String input = sc.nextLine();
            try {
                option1 = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                option1 = -1;
                System.out.println("Invalid input! Please enter a number.");
            }

            if (option1 == 1) {
                if (BankAccount.index >= 10) {
                    System.out.println("Account limit reached. Cannot create more accounts.");
                    continue;
                }

                BankAccount newAccount = new BankAccount();
                System.out.print("Enter the Holder name: ");
                newAccount.holderName = sc.nextLine();

                System.out.print("Enter Email: ");
                newAccount.email = sc.nextLine();

                System.out.print("Enter Phone: ");
                newAccount.phone = sc.nextLine();

                System.out.print("Enter Branch Name: ");
                newAccount.branchName = sc.nextLine();

                System.out.print("Enter IFSC Code: ");
                newAccount.ifscCode = sc.nextLine();

                System.out.print("Enter Bank Name: ");
                newAccount.bankName = sc.nextLine();

                newAccount.accountNumber = newAccount.generateAccountNumber(newAccount.holderName);
                newAccount.balance = 0.0;

                BankAccount.bankAccounts[BankAccount.index++] = newAccount;
                System.out.println("Account created successfully.");
                System.out.println("Your Account Number is: " + newAccount.accountNumber);

            } else if (option1 == 2) {
                System.out.print("Enter your account number: ");
                String accNum = sc.nextLine();
                BankAccount acc = BankAccount.getAccountByNumber(accNum);

                if (acc == null) {
                    System.out.println("Invalid account number, please try again.");
                    continue;
                }

                do {
                    System.out.println("""
                            Please choose:
                            1> Credit balance
                            2> Debit balance
                            3> View account balance
                            4> View account details
                            5> Go to previous menu
                            6> Close the program
                            """);

                    String subInput = sc.nextLine();
                    try {
                        option2 = Integer.parseInt(subInput);
                    } catch (NumberFormatException e) {
                        option2 = -1;
                        System.out.println("Invalid input! Please enter a valid number.");
                        continue;
                    }

                    if (option2 == 1) {
                        System.out.print("Enter amount to credit: ");
                        double amount = sc.nextDouble();
                        sc.nextLine(); // Clear newline
                        acc.creditBalance(amount);
                    } else if (option2 == 2) {
                        System.out.print("Enter amount to debit: ");
                        double amount = sc.nextDouble();
                        sc.nextLine(); // Clear newline
                        acc.debitBalance(amount);
                    } else if (option2 == 3) {
                        acc.viewBalance();
                    } else if (option2 == 4) {
                        acc.viewDetails();
                    } else if (option2 == 5) {
                        break;
                    } else if (option2 == 6) {
                        System.out.println("Closing the program.");
                        System.exit(0);
                    } else {
                        System.out.println("Invalid option! Please try again.");
                    }

                } while (option2 != 6);

            } else if (option1 == 3) {
                System.out.println("Program closed. Thank you!");
                break;
            } else {
                System.out.println("Invalid option! Please choose again.");
            }

        } while (option1 != 3);

        sc.close();
    }
}

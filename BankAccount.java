import java.util.Random;

public class BankAccount {
    String holderName;
    String email;
    String phone;
    String accountNumber;
    String ifscCode;
    String branchName;
    String bankName;
    Double balance;

    static BankAccount[] bankAccounts = new BankAccount[10];
    static int index = 0;

    public String generateAccountNumber(String name) {
        Random rand = new Random();
        String accNum;
        do {
            int randomNum = 1000 + rand.nextInt(9000);
            accNum = name.substring(0, Math.min(3, name.length())).toUpperCase() + randomNum;
        } while (!validateAccountNumberByUnique(accNum));
        return accNum;
    }

    public boolean validateAccountNumberByUnique(String accountNumber) {
        for (int i = 0; i < index; i++) {
            if (bankAccounts[i].accountNumber.equals(accountNumber)) {
                return false;
            }
        }
        return true;
    }

    public static BankAccount getAccountByNumber(String accountNumber) {
        for (int i = 0; i < index; i++) {
            if (bankAccounts[i].accountNumber.equals(accountNumber)) {
                return bankAccounts[i];
            }
        }
        return null;
    }

    public void creditBalance(double amount) {
        this.balance += amount;
        System.out.println("Balance credited successfully!");
        System.out.println("Final amount is: " + this.balance);
    }

    public void debitBalance(Double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient fund, please enter a valid balance.");
        } else {
            this.balance -= amount;
            System.out.println("Balance debited successfully!");
            System.out.println("Final amount is: " + this.balance);
        }
    }

    public void viewBalance() {
        System.out.println("Final amount is: " + this.balance);
    }

    public void viewDetails() {
        System.out.println("Account details");
        System.out.println("Holder name: " + holderName);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Branch name: " + branchName);
        System.out.println("IFSC code: " + ifscCode);
        System.out.println("Bank name: " + bankName);
        System.out.println("Balance: " + balance);
    }
}

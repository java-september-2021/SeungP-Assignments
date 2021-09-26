public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int accountCount;
    private static double totalValue;

    public BankAccount(){
        accountCount++;
        checkingBalance = 0;
        savingsBalance = 0;
    }

    public double getCheckingBalance(){
        System.out.println("The checking balance is " + checkingBalance);
        return checkingBalance;
    }

    public double getSavingsBalance(){
        System.out.println("The savings balance is " + savingsBalance);
        return savingsBalance;
    }

    public void deposit(double amount, String account){
        if (account.equals("Checking")){
            checkingBalance += amount;
            addTotalValue(amount);
        }
        else if (account.equals("Savings")){
            savingsBalance += amount;
            addTotalValue(amount);
        }
        else {
            System.out.println("Invalid account type.");
        }
    }

    public void withdraw(double amount, String account){
        if (account.equals("Checking")){
            if (checkingBalance - amount >= 0){
                checkingBalance -= amount;
                subtractTotalValue(amount);
            }
            else {
                System.out.println("Insufficient checking balance.");
            }
        }
        else if (account.equals("Savings")){
            if (savingsBalance - amount >= 0){
                savingsBalance -= amount;
                subtractTotalValue(amount);
            }
            else {
                System.out.println("Insufficient savings balance.");
            }
        }
        else {
            System.out.println("Invalid account type.");
        }
    }

    private static void addTotalValue(double amount){
        totalValue += amount;
    }

    private static void subtractTotalValue(double amount){
        totalValue -= amount;
    }

    public double getTotalBalance(){
        System.out.println("The account's total balance is " + checkingBalance + savingsBalance);
        return checkingBalance + savingsBalance;
    }
}

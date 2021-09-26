public class AccountTest {
    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        BankAccount b = new BankAccount();
        a.deposit(100, "Checking");
        b.deposit(200, "Savings");
        a.getCheckingBalance();
        b.getSavingsBalance();
        a.withdraw(50, "Checking");
        a.getCheckingBalance();
        a.withdraw(100, "Checking");
    }
}

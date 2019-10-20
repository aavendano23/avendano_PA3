public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public void calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;
    }

    public static void modifyInterestRate(double amt) {
        annualInterestRate = amt;
    }

    public void setSavingsBalance (double balance) {
        savingsBalance = balance;
    }

    public void printSavingsBalance() {
        System.out.printf("%.2f\n", savingsBalance);
    }
}

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public double calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;
        return monthlyInterest;
    }

    public static void modifyInterestRate(double amt) {
        annualInterestRate = amt;
    }

    public void setSavingsBalance (double balance) {
        savingsBalance = balance;
    }

    public void printMonthlyInterest() {
        System.out.println(calculateMonthlyInterest());
    }
}

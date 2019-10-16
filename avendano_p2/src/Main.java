public class Main {

    public static void main(String[] args) {
	SavingsAccount saver1 = new SavingsAccount();
	SavingsAccount saver2 = new SavingsAccount();


	saver1.setSavingsBalance(2000.00);
	saver2.setSavingsBalance(3000.00);
	saver1.modifyInterestRate(0.04);
	saver2.modifyInterestRate(0.04);

	System.out.print("Saver 1 Monthly Interest: ");
	saver1.printMonthlyInterest();
	System.out.print("Saver 2 Monthly Interest: ");
	saver2.printMonthlyInterest();

	saver1.modifyInterestRate(0.05);
	saver2.modifyInterestRate(0.05);

	System.out.print("Saver 1 Monthly Interest: ");
	saver1.printMonthlyInterest();
	System.out.print("Saver 2 Monthly Interest: ");
	saver2.printMonthlyInterest();


    }
}

public class Application {

    public static void TestCase() {

        int i;
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();


        saver1.setSavingsBalance(2000.00);
        saver2.setSavingsBalance(3000.00);
        saver1.modifyInterestRate(0.04);
        saver2.modifyInterestRate(0.04);

        for (i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.print("Saver 1 balance after " + (i + 1) + " month(s) 4% Interest: $");
            saver1.printSavingsBalance();
            System.out.print("Saver 2 balance after " + (i + 1) + " month(s) 4% Interest: $");
            saver2.printSavingsBalance();
            System.out.println();
        }

        saver1.modifyInterestRate(0.05);
        saver2.modifyInterestRate(0.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();


        System.out.print("Saver 1 balance after 13 month(s) with 5% Interest: $");
        saver1.printSavingsBalance();
        System.out.print("Saver 2 balance after 13 month(s) with 5%  Interest: $");
        saver2.printSavingsBalance();


    }
}

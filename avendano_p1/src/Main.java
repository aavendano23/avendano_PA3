import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static int multPractice (SecureRandom random, int bound, int arithType) {
        int a, b;

        a = random.nextInt(bound);
        b = random.nextInt(bound);

        if (arithType == 1) {
            System.out.println("How much is " + a + " plus " + b);
            return a + b;
        }
        else if (arithType == 2) {
            System.out.println("How much is " + a + " times " + b);
            return a * b;
        }
        else if (arithType == 3) {
            System.out.println("How much is " + a + " minus " + b);
            return a - b;
        }
        else if (arithType == 4) {
            System.out.println("How much is " + a + " divided by " + b);
            return a / b;
        }
        else {
            return multPractice(random, bound, random.nextInt(4));
        }
    }

    // do i need to make it static does main have to be static
    public static void posResponses(Random random) {

        int op = random.nextInt(4);
        switch (op) {
            case 0:
                System.out.println("Very good!\n");
                break;
            case 1:
                System.out.println("Excellent!\n");
                break;
            case 2:
                System.out.println("Nice work!\n");
                break;
            case 3:
                System.out.println("Keep up the good work!\n");
                break;
        }
    }

    public static void negResponses(Random random) {

        int op = random.nextInt(4);
        switch (op) {
            case 0:
                System.out.println("No. Please try again.\n");
                break;
            case 1:
                System.out.println("Wrong. Try once more.\n");
                break;
            case 2:
                System.out.println("Don’t give up!\n");
                break;
            case 3:
                System.out.println("No. Keep trying.\n");
                break;
        }
    }

    public static int difficultyLevel(Scanner input) {
        int level;

        System.out.println("Choose difficulty level:\nLevel 1: Only single digits\nLevel 2: Numbers as large as two digits\n" +
                "Level 3: Numbers as large as three digits\nLevel 4: Numbers as large as four digits");
        level = input.nextInt();

        if (level == 1) {
            return  9;
        }
        else if (level == 2) {
            return 99;
        }
        else if (level == 3) {
            return 999;
        }
        else {
           return 9999;
        }
    }

    public static int arithmeticType (Scanner input) {
        int arithType;
        System.out.println("Choose arithmetic problem:\n1: Addition\n2: Multiplication\n3: Subtraction\n4: Division\n" +
                "5:Random Mixture");
        arithType = input.nextInt();
        return arithType;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        Random rand = new Random();
        int ans, correct = 0, counter = 0, ch, bound, mathType;
        double userAns;
        final double NUM_QUESTIONS = 10.0;
        double grade;


        while (true) {
            counter = 0;
            correct = 0;
            bound  = difficultyLevel(scnr);
            mathType = arithmeticType(scnr);
            while (counter != 10) {
                ans = multPractice(random, bound, mathType);
                userAns = scnr.nextDouble();
                if (Math.abs(ans - userAns) < 0.001) {
                    System.out.println("correct");
                    correct++;
                    posResponses(rand);
                }
                else {
                    System.out.println("wrong");
                    negResponses(rand);
                }
                counter++;
            }

            grade = correct / NUM_QUESTIONS;
            System.out.println("You got " + correct + " correct and " + (10 - correct) + " wrong.");
            if (grade > 0.75) {
                System.out.println("Congratulations, you are ready to go to the next level!");
            } else {
                System.out.println("Please ask your teacher for extra help.");
            }
            System.out.println("Would you like to begin a new session?\n1) Continue\n2) Exit\n");
            if (scnr.nextInt() != 1) {
                break;
            }
        }
    }
}


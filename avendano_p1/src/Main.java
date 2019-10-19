import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Random;

public class Main {

    // generates the math problems
    public static Double mathPractice (SecureRandom random, int bound, int arithType) {
        int a, b;

        // generates random numbers
        a = random.nextInt(bound);
        b = random.nextInt(bound);

        // displays math problem and return answer
        if (arithType == 1) {
            System.out.println("How much is " + a + " plus " + b);
            return (double)a + b;
        }
        else if (arithType == 2) {
            System.out.println("How much is " + a + " times " + b);
            return (double)a * b;
        }
        else if (arithType == 3) {
            System.out.println("How much is " + a + " minus " + b);
            return (double)a - b;
        }
        else if (arithType == 4) {
            if (b == 0) {
                a = random.nextInt(bound);
                b = random.nextInt(bound) + 1;
            }
            System.out.println("How much is " + a + " divided by " + b);
            return (double)a / b;
        }
        else {
            return mathPractice(random, bound, random.nextInt(4));
        }
    }

    // displays randomly selected positive responses
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

    // displays randomly selected negative responses
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

    // decide how many digits are the numbers used in math problems
    public static int difficultyLevel(Scanner input) {
        int level;

        // ask user to select difficulty option
        System.out.println("Choose difficulty level:\nLevel 1: Only single digits\nLevel 2: Numbers as large as two digits\n" +
                "Level 3: Numbers as large as three digits\nLevel 4: Numbers as large as four digits");
        level = input.nextInt();
        while (level > 4 || level < 0) {
            System.out.println("Please enter a valid option 1 - 4");
            level = input.nextInt();
        }

        // returns the upper bound integer of the high number of digits
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

    // decides the type of math problem
    public static int arithmeticType (Scanner input) {
        int arithType;

        // ask user to select what type of math problems they would like
        System.out.println("Choose arithmetic problem:\n1: Addition\n2: Multiplication\n3: Subtraction\n4: Division\n" +
                "5:Random Mixture");
        arithType = input.nextInt();

        while (arithType > 5 || arithType < 0) {
            System.out.println("Please enter a valid option 1 - 5");
            arithType = input.nextInt();
        }
        return arithType;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        Random rand = new Random();
        int correct = 0, counter = 0, ch, bound, mathType;
        double ans, userAns;
        final double NUM_QUESTIONS = 10.0;
        double grade;


        while (true) {
            counter = 0;
            correct = 0;
            bound  = difficultyLevel(scnr);
            mathType = arithmeticType(scnr);

            // displays math problem
            while (counter != 10) {
                ans = mathPractice(random, bound, mathType);
                userAns = scnr.nextDouble();
                // determines if user's answer is correct
                System.out.println("ans: " + ans);
                System.out.println("ans: " + (ans - userAns));
                if (Math.abs(ans - userAns) < 0.01) {
                    correct++;
                    posResponses(rand);
                }
                else {
                    negResponses(rand);
                }
                counter++;
            }

            // displays number of correct problems and if the user would like to restart
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


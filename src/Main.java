import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var guessedRight = false;
        double guessedNumber = 50;
        double lowestNumber = 0;
        double highestNumber = 100;
        int guessCounter = 1;

        System.out.println("Welcome, think of a number between 1 and 100.");
        System.out.println("I'll try to guess is with as few guesses i can.");
        System.out.println("So let's start!");

        do {
            guessedRight = checkGuessedNumber(guessedNumber);

            if (!guessedRight) {
                if (goHigherOrSmaller().equals("smaller")) {
                    highestNumber = guessedNumber;
                } else {
                    lowestNumber = guessedNumber;
                }
            guessedNumber = ((highestNumber + lowestNumber) / 2);
            guessCounter++;
            }

        } while (!guessedRight);

        System.out.printf("I did it with only %d tries!", guessCounter);
    }

    static boolean checkGuessedNumber(double guessedNumber) {
        String isNumberCorrect;

        do {
            System.out.printf("Is your number %.0f? Answer with 'yes' or 'no'.%n", guessedNumber);
            isNumberCorrect = new Scanner(System.in).nextLine().toLowerCase();
        } while (!isNumberCorrect.equals("no") && !isNumberCorrect.equals("yes"));
        return isNumberCorrect.equals("yes");
    }

    static String goHigherOrSmaller() {
        String isHigherOrSmaller;

        do {
            System.out.printf("Is your number 'bigger' or 'smaller'?%n");
            isHigherOrSmaller = new Scanner(System.in).nextLine().toLowerCase();
        } while (!isHigherOrSmaller.equals("smaller") && !isHigherOrSmaller.equals("bigger"));

        if (isHigherOrSmaller.equals("smaller")) {
            return "smaller";
        } else {
            return "bigger";
        }
    }

}

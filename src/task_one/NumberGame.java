package task_one;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
        public static void main(String[] args) {

            int count = 1;
            int score = 0;

            while (isCorrect((new Random().nextInt(100) + 1))) {
                System.out.println("\nBravo stage " + count + " completed\n");

                count++;
                score += 5;
            }

            System.out.println("\nGame over.....");
            System.out.println("Score = " + score);
        }

        public static boolean isCorrect(int randomNumber) {
            Scanner input = new Scanner(System.in);

            for (int i = 1; i <= 11; i++) {
                if (i <= 10){
                    System.out.print("Enter number: ");
                    int userInput = input.nextInt();

                    if (userInput > randomNumber) {
                        System.out.println("Too high");
                    } else if (userInput < randomNumber) {
                        System.out.println("Too low");
                    } else {
                        System.out.println("Correct");
                        return true;
                    }
                }
            }
            return false;
        }

}

import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalGames = 0;
        int totalAttempts = 0;

        System.out.println("======================================");
        System.out.println("       DECODE LABS - NUMBER GAME      ");
        System.out.println("======================================");
        System.out.println("Guess the number between 1 and 100!");
        System.out.println();

        while (playAgain) {

            // Generate a random number between 1 and 100
            int targetNumber = random.nextInt(100) + 1;

            int attempts = 0;
            boolean won = false;

            totalGames++;

            System.out.println("--------------------------------------");
            System.out.println("Game " + totalGames);
            System.out.println("--------------------------------------");

            while (!won) {

                System.out.print("Enter your guess (1-100): ");

                int guess;

                // Handle invalid input
                try {
                    guess = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a whole number.");
                    scanner.nextLine();
                    continue;
                }

                // Validate range
                if (guess < 1 || guess > 100) {
                    System.out.println("Invalid range!");
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;
                totalAttempts++;

                // Compare guess with target
                if (guess < targetNumber) {

                    System.out.println("Too Low! Try again.");

                } else if (guess > targetNumber) {

                    System.out.println("Too High! Try again.");

                } else {

                    won = true;

                    System.out.println();
                    System.out.println("🎉 CORRECT! 🎉");
                    System.out.println("You guessed the number: " + targetNumber);
                    System.out.println("Attempts: " + attempts);

                    int score = calculateScore(attempts);
                    System.out.println("Score: " + score);
                }
            }

            // Ask whether the player wants another game
            System.out.print("\nPlay Again? (Y/N): ");

            String answer = scanner.next();

            while (!answer.equalsIgnoreCase("Y")
                    && !answer.equalsIgnoreCase("N")) {

                System.out.print("Please enter Y or N: ");
                answer = scanner.next();
            }

            if (answer.equalsIgnoreCase("N")) {
                playAgain = false;
            }

            System.out.println();
        }

        // Final game summary
        System.out.println("======================================");
        System.out.println("           GAME SUMMARY               ");
        System.out.println("======================================");
        System.out.println("Games Played  : " + totalGames);
        System.out.println("Total Attempts: " + totalAttempts);
        System.out.println("Thank you for playing!");
        System.out.println("======================================");

        scanner.close();
    }

    // Calculate score based on attempts
    public static int calculateScore(int attempts) {

        if (attempts <= 5) {
            return 100;
        } else if (attempts <= 10) {
            return 75;
        } else if (attempts <= 15) {
            return 50;
        } else {
            return 25;
        }
    }
}
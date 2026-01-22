import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int maxAttempts = 5;
        int score = 0;
        char playAgain;

        do {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            boolean isGuessed = false;

            System.out.println("\n🎯 Guess the number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempts.");
                    score++;
                    isGuessed = true;
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("📉 Too High!");
                } else {
                    System.out.println("📈 Too Low!");
                }
            }

            if (!isGuessed) {
                System.out.println("❌ You've used all attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\n🏆 Game Over!");
        System.out.println("Your total score (rounds won): " + score);
        sc.close();
    }
}
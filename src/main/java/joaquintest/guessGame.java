import java.util.Scanner;
import java.util.random.RandomGenerator;

public class guessGame {
    public static void guess() {
        Scanner input = new Scanner(System.in);
        RandomGenerator rng = RandomGenerator.getDefault();
        int number = rng.nextInt(0, 11);
        {
            int askNumber;
            do {
                System.out.println("Enter a number between 0-10");
                askNumber = input.nextInt();
                if (askNumber > 10 || askNumber < 0) {
                    System.out.println("Number must be between 0-10");
                }
                if (askNumber < number) {
                    System.out.println("Too low");
                }
                if (askNumber > number) {
                    System.out.println("Too high");
                }
                if (askNumber == number) {
                    System.out.println("Right number");
                }
            } while (askNumber != number);
        }
        input.close();
    }

    public static void main(String[] args) {
        guess();
    }
}

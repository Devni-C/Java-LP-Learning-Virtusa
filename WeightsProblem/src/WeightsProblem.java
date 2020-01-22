import java.util.Scanner;

public class WeightsProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 1-40" + Weight.TWO);
        int input = scanner.nextInt();
        String number;

        if (input <= 40 && input >= 1) {
            while (input != 0) {
                if (input <= 5 ) {
                    input = input - 5;
//                    input = input - Integer.parseInt(String.valueOf(Weight.FOUR + Weight.ONE));
                }
            }
        }

    }
}

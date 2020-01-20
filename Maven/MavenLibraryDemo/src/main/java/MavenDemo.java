import java.util.Scanner;

public class MavenDemo {
    public static void main(String[] args) {
        Multiplication obj = new Multiplication();
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        System.out.println("Enter two numbers: ");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();

        System.out.println("Sum is: " + getSum(num1, num2));
        System.out.println("Multiplication is: " + obj.getMultiplication(num1, num2));
    }

    static int getSum(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }
}

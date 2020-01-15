import java.util.Scanner;

     class ReverseNumber {

     public static void main(String args[]) {
           Scanner sc = new Scanner(System.in);
           System.out.println("Enter a number: ");
           int input = sc.nextInt();

           double output = 0;
           int length = (int) (Math.log10(input) + 1);

           do {
                int rem = input % 10;
                //System.out.println("\nrem = " + rem);
                //System.out.println("length = " + length);

                output = output + (rem * Math.pow(10, length-1));
                
                //System.out.println("input = " + input);
                
                input = input / 10;
                length = length-1;
  
          } while (length > 0);

          System.out.println("Reversed number is : " + output);
     }
}

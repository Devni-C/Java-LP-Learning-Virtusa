import java.util.Scanner;

public class FrogMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press 1 to enter jumped Distance\nPress 2 to enter Time taken");
		int input = scanner.nextInt();
		int time, distance;
		
		FrogActions actions = new FrogActions();
	
		switch (input) {
			case 1:
				System.out.println("Enter the distance John jumped: ");
				distance = scanner.nextInt();
				actions.calculateTime(distance);
				break;
			case 2:
				System.out.println("Enter the time John took to jump: ");
				time = scanner.nextInt();
				actions.calculateDistance(time);
			
				break;
			default:
				System.out.println("Invalid Input!");
				break;
		}
	}	
}

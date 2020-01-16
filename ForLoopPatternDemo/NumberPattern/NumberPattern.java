public class NumberPattern {
	public static void main(String[] args) {
		int number = 9;
		System.out.print("   ");
		for (int row = 1; row <= number; row++) {
			System.out.format("%3d", row);
		}
		System.out.println("\n--------------------------------");

		for (int i = 1; i <= number; i++) {
			System.out.print(i + " |");
			for (int j = 1; j <= number; j++) {
				System.out.format("%3d", (i * j));
			}
			System.out.println();
		}

	}
}

public class DiamondStarPattern {
	public static void main(String[] args) {
		int rows = 19;

		for (int x = 1; x <= rows; x++) {
		//for (int a = 1; a <= 4; a++) {
			for (int i = rows; i > x; i--) {
        			System.out.print(" ");
			}
        		for (int j = 1; j <= (x * 2)-1; j++) {
             			System.out.print("*");
            		}
            		System.out.println();
        	}

		for (int y = rows - 1; y >= 1; y--) {
			for (int i = rows - 1; i >= y; i--) {
        			System.out.print(" ");
			}
        		for (int j = 1; j <= (y * 2)-1; j++) {
             			System.out.print("*");
            		}
            		System.out.println();
        	}

     	}
}

public class DiamondStarPattern {
	public static void main(String[] args) {
		for (int a = 1; a <= 4; a++) {
			for (int i = 4; i > a; i--) {
        			System.out.print(" ");
			}
        		for (int j = 1; j <= a; j++) {
             			System.out.print("*");
            		}
            		System.out.println();
        	}

		for (int a = 1; a <= 4; a++) {
			for (int i = 1; i < a; i++) {
        			System.out.print(" ");
			}
        		for (int j = 4; j >= a; j--) {
             			System.out.print("*");
            		}
            		System.out.println();
        	}

     	}
}

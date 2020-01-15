public class FrogActions {
	int jumpedDistance = 0;
	int timeTaken = 0;

	void calculateDistance(int time) {	
		if (time % 8 == 0) {
			jumpedDistance = ((time / 8) * 9);
		} else if (time % 8 == 1) {
			jumpedDistance = ((time / 8) * 9 + 5);
		} else if (time % 8 == 2 || time % 8 == 3) {
			jumpedDistance = ((time / 8) * 9 + 5 + 3);
		} else if (time % 8 >= 4 && time % 8 <= 5) {
			jumpedDistance = ((time / 8) * 9 + 5 + 3 + 1 + 5);
		} 
		System.out.println("John jumped " + jumpedDistance + "m within " + time + "s");	
	}

	void calculateTime(int distance) {
		if (distance % 9 == 0) {
			timeTaken = ((distance / 9) * 8 - 5);
		} else if ((distance % 9 >= 0) && (distance % 9 <= 5)) {
			timeTaken = ((distance / 9) * 8);
		} else if ((distance % 9 >= 6) && (distance % 9 <= 8)) {
			timeTaken = ((distance / 9) * 8 + 1);
		} 
		System.out.println("John took " + timeTaken + "s to jump " + distance + "m");
	}
}

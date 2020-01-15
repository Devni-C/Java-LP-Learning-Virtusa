import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class DateTimeZone {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int year, month, day, hour, minute, second;

		System.out.println("Enter the Year : ");
		year = scanner.nextInt();
        
		System.out.println("Enter the Month : ");
		month = scanner.nextInt();
        
		System.out.println("Enter the Day : ");
		day = scanner.nextInt();
        
		System.out.println("Enter the Hour : ");
		hour = scanner.nextInt();
        
		System.out.println("Enter the Minute : ");
		minute = scanner.nextInt();
       
		System.out.println("Enter the Second : ");
		second = scanner.nextInt();

		LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);

		ZoneId current = ZonedDateTime.now().getZone();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(String.valueOf(current)));

		ZonedDateTime zonedPst = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
		System.out.println(current);
		System.out.println(zonedDateTime);
		System.out.println(zonedPst);
	}
}

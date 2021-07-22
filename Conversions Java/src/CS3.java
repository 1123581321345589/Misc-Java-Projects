//Aaron Occhipinti
import java.util.*;
public class CS3 {

	public static void main(String[] args) {
		// Getting users number of mins with scanner
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Number of Mins: ");
		int mins = input.nextInt();
		input.close();
		//Math and output
		int years = (mins/525600);
		int days = ((mins/1440) - (365 * years));
		int hours = ((mins/60) % 24);
	//printing
		System.out.println("Years: " + years);
		System.out.println("Days: " + days);
		System.out.println("Hours: " + hours);
	}
}

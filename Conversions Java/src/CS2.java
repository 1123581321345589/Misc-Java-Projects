//Aaron Occhipinti
import java.util.*;
public class CS2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Get users number of inches with scanner
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Number of Inches: ");
		int inches = input.nextInt();
		input.close();
//Math 
	    int totalinch = (inches % 12);
	    int totalyards = ((inches / 12) / 3);
	    int totalfeet = ((inches / 12) - totalyards * 3);
	    
	    
	    
	    System.out.println("Yards: " + totalyards);
	    System.out.println("feet: " + totalfeet);
	    System.out.println("inch: " + totalinch);
		
		
		

	}

}

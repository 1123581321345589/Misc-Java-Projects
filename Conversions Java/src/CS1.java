//Aaron Occhipinti
import java.util.*;
public class CS1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Open Scanner and get the number of yards from the user
Scanner input = new Scanner(System.in);
System.out.println("Enter Number of Yards: ");
int yards = (int) input.nextLong();
//Gets the number of feet from the user
System.out.println("Enter Number of Feet: ");
int feet = (int) input.nextLong();
//Gets the number of inches for the user and closes the scanner
System.out.println("Enter Number of Inches: ");
int inches = (int) input.nextLong();
input.close();
//Math
int total1 = (yards*3 + feet);
int total2= (total1*12 + inches);
System.out.println("Total Number of Inches: " + total2);


	}
}

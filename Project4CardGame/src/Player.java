import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends GenericPlayer {

public Player(String name) {
super(name);
}

@Override
public boolean isHitting(Scanner input) {
do {
System.out.printf("%s: Do you want to hit? (y/n)", name);
String response = "";
try {
response = input.next();
} catch(InputMismatchException ex) {
System.out.println("Enter y or n only");
return true;
}
char c = response.toLowerCase().charAt(0);
if (c == 'y') {
return true;
} else if (c == 'n') {
return false;
} else {
System.out.printf("Please enter y or n%n"); 
}
} while (true);
}


public static void main(String[] args) {
	// display column headers
	System.out.printf( "%-5s %-8s %-8s %-15s %-15s %-6s   %-10s   %-10s %-15s%n",
	"#",
	"Rank",
	"Graphic",
	"Name",
	"Display Name",
	"Points",
	"Alt Points",
	"Priority",
	"Alt Priority");

	for (Rank aRank : Rank.values()) {
	System.out.printf( "%-5d %-8s %-8s %-15s %-15s %-6d   %-10d   %-10d %-15d%n",
	aRank.ordinal(),
	aRank,
	aRank.graphic,
	aRank.name(),
	aRank.displayName,
	aRank.points,
	aRank.altPoints,
	aRank.priority,
	aRank.altPriority );
	}
}


}




import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameDriver {
	

		public static void main(String[] args) {


		Scanner input = new Scanner(System.in);
		Deck d = new Deck();

		System.out.printf("%nWelcome to BlackJack!%n%n");

		System.out.printf("Enter number of players: ");  
		int numPlayers = 0;
		try {
		numPlayers = input.nextInt(); 
		} catch(InputMismatchException ex) {
		System.out.println("Number of players should be an integer number"); 
		}

		ArrayList<GenericPlayer> players = new ArrayList<>(numPlayers + 1); 

		for (int i = 0; i < numPlayers; i++) { 
		System.out.printf("Enter player #%d name: ", i + 1);
		String name = input.next();
		Player p = new Player(name);
		players.add(p);
		}
		House house = new House("House"); 
		players.add(house);


		System.out.println("");
		
		for (int i = 0; i < players.size(); i++) { 
		GenericPlayer p = players.get(i);
		d.deal(p);
		d.deal(p);
		if (p instanceof House) {
		House h = (House) p;
		h.flipFirstCard(); 
		}
		System.out.printf("%s%n", p);
		}

		
		for (int i = 0; i < players.size(); i++) {
		GenericPlayer p = players.get(i);
		if (p instanceof House) {
		House h = (House) p;
		h.flipFirstCard();
		}

		while (p.isBusted == false) {
		if (p.isHitting(input)) {
		d.deal(p);
		System.out.printf("%s%n", p);
		} else {
		break;
		}
		if(p.getValue() > 21) {
		p.busted();
		System.out.println();
		}
		} 
		} 

		System.out.printf("%n%nFinal Hands:%n");
		for(int i = 0; i < players.size(); i++) {
		System.out.printf("%s%n", players.get(i));
		}
		System.out.printf("%n%n");

		
		int houseValue = house.getValue();
		for(int i = 0; i < players.size(); i++) {
		GenericPlayer p = players.get(i);
		int playerValue = p.getValue();

		if(p instanceof House) {
		continue;
		}

		if(p.isBusted() == false) {
		if(houseValue > 21) {
		
		p.win();
		System.out.println();
		} else if(houseValue == playerValue) {
		
		p.push();
		System.out.println();
		} else if (playerValue > houseValue) {
		
		p.win();
		System.out.println();
		} else {
	
		p.lost();
		System.out.println();
		}
		} else {
		p.lost();
		System.out.println();
		}
		}

		input.close();
		}
		}



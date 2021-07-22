import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TrainSimulation {

	public static void main(String[] args) {
		
		int timeStamp = 0;
		//intitalizes route && train
		Route one = new Route();
		Train train = new Train();
		int capacity = 20;
		//intializes station
		Station a = new Station("Station A");
		Station b = new Station("Station B");
		Station c = new Station("Station C");
		Station d = new Station("Station D");
		Station e = new Station("Station E");
		Station f = new Station("Station F");
		Station g = new Station("Station G");
		Station h = new Station("Station H");
		Station i = new Station("Station I");
		Station j = new Station("Station J");
		
		try {
		File file = new File("src/TrainSimulationOutputFile");	
		PrintWriter pr = new PrintWriter(file);
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter an amout of time to simulate: ");
		int time = in.nextInt();
		
		for(int z = 0; z < (time / 10); z++) {
			
			System.out.println("Time: " + timeStamp);
			pr.println("Time: " + timeStamp);
			System.out.println("Station: " + one.currentStop);
			pr.println("Station: " + one.currentStop);
			for(int l = 0; l < Math.random() * 100; l++) {
				
				a.addPassenger();
				
			}
			for(int l = 0; l < Math.random() * 100; l++) {
				
				b.addPassenger();
				
			}
			for(int l = 0; l < Math.random() * 100; l++) {
				
				c.addPassenger();
				
			}
			for(int l = 0; l < Math.random() * 100; l++) {
				
				d.addPassenger();
				
			}
			for(int l = 0; l < Math.random() * 100; l++) {
				
				e.addPassenger();
				
			}
			for(int l = 0; l < Math.random() * 100; l++) {
				
				f.addPassenger();
				
			}
			for(int l = 0; l < Math.random() * 100; l++) {
				
				g.addPassenger();
				
			}
			for(int l = 0; l < Math.random() * 100; l++) {
				
				h.addPassenger();
				
			}
			for(int l = 0; l < Math.random() * 100; l++) {
				
				i.addPassenger();
				
			}
			for(int l = 0; l < Math.random() * 100; l++) {
				
				j.addPassenger();
				
			}
			
			if(one.currentStop == "Station A") {
				Passenger pass = new Passenger();
				for(int p = 0; p < a.passengers.size; p++) {
					pass = a.passengers.dequeue();
					train.passengers.add(pass);
					System.out.println(pass.toString() + " On ----> " + pass.destination);
					pr.println(pass.toString() + " On ----> " + pass.destination);
				}
			}
			else if(one.currentStop == "Station B") {
				Passenger pass = new Passenger();
				for(int p = 0; p < b.passengers.size; p++) {
					pass = b.passengers.dequeue();
					train.passengers.add(pass);
					System.out.println(pass.toString() + " On ----> " + pass.destination);
					pr.println(pass.toString() + " On ----> " + pass.destination);
					}
			}
			else if(one.currentStop == "Station C") {
				Passenger pass = new Passenger();
				for(int p = 0; p < c.passengers.size; p++) {
					pass = c.passengers.dequeue();
					train.passengers.add(pass);
					System.out.println(pass.toString() + " On ----> " + pass.destination);
					pr.println(pass.toString() + " On ----> " + pass.destination);
					}
			}
			else if(one.currentStop == "Station D") {
				Passenger pass = new Passenger();
				for(int p = 0; p < d.passengers.size; p++) {
					pass = d.passengers.dequeue();
					train.passengers.add(pass);
					System.out.println(pass.toString() + " On ----> " + pass.destination);
					pr.println(pass.toString() + " On ----> " + pass.destination);
					}
			}
			else if(one.currentStop == "Station E") {
				Passenger pass = new Passenger();
				for(int p = 0; p < e.passengers.size; p++) {
					pass = e.passengers.dequeue();
					train.passengers.add(pass);
					System.out.println(pass.toString() + " On ----> " + pass.destination);
					pr.println(pass.toString() + " On ----> " + pass.destination);
					}
			}
			else if(one.currentStop == "Station F") {
				Passenger pass = new Passenger();
				for(int p = 0; p < f.passengers.size; p++) {
					pass = f.passengers.dequeue();
					train.passengers.add(pass);
					System.out.println(pass.toString() + " On ----> " + pass.destination );
					pr.println(pass.toString() + " On ----> " + pass.destination);
					}
			}
			else if(one.currentStop == "Station G") {
				Passenger pass = new Passenger();
				for(int p = 0; p < g.passengers.size; p++) {
					pass = g.passengers.dequeue();
					train.passengers.add(pass);
					System.out.println(pass.toString() + " On ----> " + pass.destination);
					pr.println(pass.toString() + " On ----> " + pass.destination);
					}
			}
			else if(one.currentStop == "Station H") {
				Passenger pass = new Passenger();
				for(int p = 0; p < h.passengers.size; p++) {
					pass = h.passengers.dequeue();
					train.passengers.add(pass);
					System.out.println(pass.toString() + " On ----> " + pass.destination);
					pr.println(pass.toString() + " On ----> " + pass.destination);
					}
			}
			else if(one.currentStop == "Station I") {
				Passenger pass = new Passenger();
				for(int p = 0; p < i.passengers.size; p++) {
					pass = i.passengers.dequeue();
					train.passengers.add(pass);
					System.out.println(pass.toString() + " On ----> " + pass.destination);
					pr.println(pass.toString() + " On ----> " + pass.destination);
					}
			}
			else if(one.currentStop == "Station J") {
				Passenger pass = new Passenger();
				for(int p = 0; p < j.passengers.size; p++) {
					pass = j.passengers.dequeue();
					train.passengers.add(pass);
					System.out.println(pass.toString() + " On ----> " + pass.destination);
					pr.println(pass.toString() + " On ----> " + pass.destination);
					}
			}
			
			for(int k = 0; k < train.passengers.getCurrentSize(); k++) {
				if(train.passengers.atIndex(k).destination == one.currentStop) {
					System.out.println(train.passengers.atIndex(k).toString() + " Off");
					pr.println(train.passengers.atIndex(k).toString() + " Off");
					train.passengers.removeEntry(k);
				}
				
			}
			
			one.nextStop();
			
			
			timeStamp = timeStamp + 10;
			
		}
		
		pr.close();
		System.out.println();
		System.out.println("Data printed to text document: TrainSimulationOutputFile");
		
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		}
		

	}


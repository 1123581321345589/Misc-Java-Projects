
public class Passenger {

	public String destination;
	
	public String[] stations = {"Station A", "Station B", "Station C", "Station D", "Station E", "Station F", "Station G", "Station H", "Station I", "Station J"};
	
	public Passenger() {
		//sets random destination for a new passenger
		int index = (int) (Math.random() * 10);
 		destination = stations[index];
	}
	
	
}

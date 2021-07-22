
public class Station {

	String StationName;
	
	CircularQueue<Passenger> passengers;
	
	public Station(String name) {
		passengers = new CircularQueue<Passenger>();
	}
	
	public void addPassenger() {
		passengers.enqueue(new Passenger());
	}
}

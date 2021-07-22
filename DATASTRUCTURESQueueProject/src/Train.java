
public class Train {

	int capacity;
	
	int[] times = {0, 1};
	//replace queue with bag ADT
	ResisableArrayBag<Passenger> passengers;
	
	public Train() {
		capacity = 20;
		passengers = new ResisableArrayBag<Passenger>(100);
	}
	
	public void addpassenger(Station s) {
		passengers.add(s.passengers.dequeue());
		capacity++;
	}
	
}

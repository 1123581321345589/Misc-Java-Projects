
public class Route {

	public String[] stations = {"Station A", "Station B", "Station C", "Station D", "Station E", "Station F", "Station G", "Station H", "Station I", "Station J"};
	
	String currentStop;
	
	int num;
	
	public Route() {
		num = 0;
		currentStop = stations[0];
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
		
	}
	
	public String nextStop() {
		Train train = new Train();
		
		boolean var = true;
		
		
		
		if(num == stations.length) {
			var = false;
		}
		if(num == 0) {
			var = true;
		}
		
		if(var) {
			currentStop = stations[(num + 1)];
			num++;
		}
		else {
			currentStop = stations[(num - 1)];
			num--;
		}
		
		return currentStop;
	}
	
}

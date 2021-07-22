public class Interval implements Comparable <Interval>{

	double s;
	double f;
		
	// Constructor(s)
	
	public Interval(double s, double f) {
		
		this.s = s;
		this.f = f;
		
	}
	
	//Acessors
	public double getStart() {
		return s;
	}
	public double getFinish() {
		return f;
	}
		
	@Override
	public int compareTo(Interval other) {
		if(this.f < other.f) {
			return -1;
		}
		else if(this.f == other.f) {
			return 0;
		}
		return 1;
	}
	@Override
	public String toString() {
		
		String s = "";
		
		s += this.s;
		s += ", ";
		s+= this.f;
		
		return s;
	}
}
class Edge {
	private Vertex v1;
	private Vertex v2;
	private double weight;
	
	public Edge (Vertex v1, Vertex v2, double weight) {
		this.v1 = v1; this.v2 = v2; this.weight = weight;
	}
	
	public Vertex getFirst() {
		return v1;
	}
	
	public Vertex getSecond() {
		return v2;
	}
	
	public double getWeight () {
		return weight;
	}
	
	public String toString() {
		String a = "{";
		
		a += v1.toString();
		
		a += " --> ";
		
		a += v2.toString();
		
		a += ", ";
		
		a += weight;
		
		a += "}";
		
		return a;
	}
}
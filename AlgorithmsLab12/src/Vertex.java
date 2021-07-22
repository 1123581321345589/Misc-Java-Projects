import java.util.ArrayList;

class Vertex implements Comparable <Vertex> {
	private int id;
	private Double key;
	private Vertex predecessor;
	private boolean used;
	private ArrayList <Vertex> adj;
	private ArrayList <Double> weights;
	
	public Vertex (int id) {
		this.id = id;
		key = 0.0;
		predecessor = null;
		adj = new ArrayList <> (2);
		weights = new ArrayList <> (2);
		used = false;
	}
	
	public void setPredecessor (Vertex pre) {
		predecessor = pre;
	}
	
	public Vertex getPredecessor() {
		return predecessor;
	}
	
	public int getPredecessorId () {
		if (predecessor == null)
			return -1;
		return predecessor.getId();
	}
	
	public Double getKey () {
		return key;
	}
	
	public void setKey (double value) {
		key = (Double)value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setUsed() {
		used = true;
	}
	
	public boolean getUsed() {
		return used;
	}
	
	public Vertex[] getAdj() {
		return adj.toArray(new Vertex[1]);
	}
	
	public double [] getWeights() {
		
		double[] result = new double[weights.size()];
		for(int i = 0; i < weights.size(); i++) {
			result[i] = weights.get(i);
		}
		
		return result;
	}
	
	public void attach (Vertex v, double w) {
		adj.add(v);
		weights.add(w);
	}
	
	public String toString() {
		String a = "";
		a += id;
		return a;
	}
	
	public int compareTo (Vertex other) {
		if(id < other.id) {
			return -1;
		}
		return 1;
	}
}
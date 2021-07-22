
public class Name {

	private String[] name;
	
	public Name(String[] n) {
		name = n;
	}
	
	public int hashCode() {
		return 0;
	}
	
	public String getName() {
		String a = "";
		
		for(int i = 0; i < name.length; i++) {
			a += name[i];
			a += " ";
		}
		return a;
	}
}

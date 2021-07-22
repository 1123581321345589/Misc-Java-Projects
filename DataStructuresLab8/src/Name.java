public class Name implements Comparable <Name>{
	private String firstName;
	private String lastName;
	
	public Name (String first, String last) {
	  firstName = first; 
             	   lastName = last;
	}

	public Name (String fullName) {
              firstName = fullName;
        }
	
	
	public String getFirst() {
		return firstName;
	}
	
	public String getLast() {
		return lastName;
	}
	
	public String toString () {
		return (firstName + " " + lastName);
	}
	public boolean equals (Object o) {
		return false;
	}
	
	public int compareTo (Name other) {
		return 0;
	}
}
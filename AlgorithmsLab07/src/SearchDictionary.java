import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchDictionary {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("src/movies");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter name to search: ");
		String name = in.nextLine();
		
		TelephoneDirectory<String,String> td = new TelephoneDirectory<String,String>(file);
		
		String result = td.hashSearch(name);
		
		if(result != null) {
			System.out.println("Number is: " + result);
		}
		else {
			System.out.println("No result found, try again");
		}
		
		
	}

}

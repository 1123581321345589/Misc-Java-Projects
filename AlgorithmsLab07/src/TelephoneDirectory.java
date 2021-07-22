import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TelephoneDirectory<Name, K> {

	//size 35
	private K key;
	
	private HDictonary<Name, String> dictonary;
	
	public TelephoneDirectory(File file) throws FileNotFoundException {
		
		Scanner in = new Scanner(file);
		
		int num = 0;
		
		while(in.hasNext()) {
			in.nextLine();
			num++;
		}
		
		dictonary = new HDictonary<Name, String>(num * 2);
		
		in = new Scanner(file);
		
		while(in.hasNext()) {
			
			String line = in.nextLine();
			
			int n = 0;
			
			
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) >= 'A' && line.charAt(i) <= 'z') {
					n++;
				}
				else {
					
					//add first strings to Name class String[]
					//add number after names to value of names
					String name = line.substring(n);
					String number = line.substring(n, line.length());
					
					Entry<Name, String> e = new Entry<Name, String>(name, number);
					
					dictonary.hashInsert(e);
					
					break;
					
					//Entry<Name, String> e = new Entry(Name, num);
					//dict.hashInsert(e);
					
				}
			}
			
		}
		
	}
	
	public String hashSearch(Name key) {
		
		int index = dictonary.hash(key, 0);
		
		if(dictonary.table[index] != null) {
			return (String) dictonary.table[index].getValue();
		}
		
		return null;
	}
	
	public int hashCode(String a) {
		//computes hashcode as sum of acii vals
		int result = 0;;
		for(int i = 0; i < a.length(); i++) {
			result += a.charAt(i);
		}
		return result;
	}
	
	
}

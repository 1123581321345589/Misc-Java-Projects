import java.util.ArrayList;

public class GreedyChangeMakingAlgorithm {

	private static int deno[] = {1, 2, 5, 10, 20 };
	
	private static int deno2[] = {1, 10, 25,  50};
	
	public static void main(String[] args) {
		
		int val = 26;
		
		findMinimum(val);
		
		int val2 = 32;
		
		findMinimum(val2);
		
		int val3 = 48;
		
		findMinimum(val3);
		
		int val4 = 70;
		
		findMinimum(val4);

	}
	
	static void findMinimum(int val) {
		
		int tempval = val;
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		for (int i = deno.length - 1; i >= 0; i--) { 
             
            while (val >= deno[i])  
            { 
                val -= deno[i]; 
                ar.add(deno[i]); 
            } 
        }
		System.out.println("First set of denomonations: ");
		for(int i = 0; i < ar.size(); i++) {
			System.out.print(ar.get(i) + ", ");
		}
		System.out.println(" ");
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (int i = deno2.length - 1; i >= 0; i--) { 
            
            while (tempval >= deno2[i])  
            { 
                tempval -= deno2[i]; 
                al.add(deno2[i]); 
            } 
        }
		System.out.println("Second set of denomonations: ");
		for(int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i) + ", ");
		}
		System.out.println(" ");
		
	}

}

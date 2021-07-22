import java.util.Scanner;

public class ChangeMaking {

  /*
   * Denominations D[0 .. m-1]
   * The initial algorithm 
    * F[0]=0  
     * for i = 1 to n  
     *     temp = n+1; j = 0
     *     while j < m and i >= D[j]
     *          temp = min⁡  (F[i-D[j]], temp)
     *          j = j + 1
     *     F[i] = temp + 1
     * return F[n] 
 */
	private static int[] denomupdate = new int[5];
	
	public static int[] getChange (int value, int[] denominations, int[] amounts) {
	// returns an array in which the position 0 holds the number of coins, and remaining positions (from 1 to length) hold the denominations
                   // composing the value	
		int [] f = new int[value + 1];
		int m = denominations.length;
		int result, temp = 1, j;
		int d = 0;
		for (int i = 1; i <= value; i ++) {
			temp = value + 1; j = 0;
			
			while (j < m && i >= denominations[j] ){
				d = f[i-denominations[j]];
				if (temp > d)
				     temp = d;
				j ++;
			}  
			f[i] = temp + 1;
		}
		result = f[value];  // will be put in the position 0
         // tracing the array f backwards, finding the denomination contributing to the minimum number of coins
		int k = result;
		int [] change = new int[k + 1]; // position 0 for the number of coins, positions 1 to k for the denominations
		j = 0;
		int pos = 0;
		while (k > 0) {
			temp = k;
			for (j = 0; j < m && denominations[j] <= value; j ++) {
				d = f[value-denominations[j]];
				if ( temp > d) {
					temp = d;
					pos = j;
				}
				//pos is the index in the array of denominations indicating the 
                //pos = smallest num of needed coins                                                           // smallest number of needed coins		
			}
			change[k] = denominations[pos]; 
			value -= change[k --]; // use the remaining value and decrement number of coins
		}
		change[0] = result;
		
		for(int i = 1; i < change.length; i++) {
			
			int a = amounts[i -1] - change[i];
			if(a <= 0) {
				denomupdate[i - 1] = a;
			}
			else {
				return null;
			}
		}
		
		
		
		return change;	
	}
	
	public static void main(String[] args) {
		int[] uscoins = {1, 5, 10, 25, 50};
        
		int[] amounts = {200, 40, 20, 8, 4};
		
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter an amount to make change: " );
		int value = sc.nextInt();
		
		int [] change = getChange (value, uscoins, amounts);
		if(change == null) {
			System.out.println("Error: insufficent change");
		}
		System.out.print(change[0] + " coins: ");
		for (int i = 1; i < change.length; i ++)
			System.out.print(change[i] + " ");
		System.out.println();		
	}

}
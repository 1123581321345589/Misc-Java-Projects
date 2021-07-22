
public class RodCuttingAlgorithm {

	public static void main(String[] args) {
		
		int[] value = { 1, 5, 7, 8, 10, 16, 18, 19, 25, 26, 30, 38, 46, 41, 50, 61, 70, 75, 80, 86 };
		
        int len = 5;
        
        System.out.println("Max profit for length " + len + ":" + profit(value, len));
        
        int len2 = 6;
        
        System.out.println("Max profit for length " + len + ":" + profit(value, len2));
        
        int len3 = 10;
        
        System.out.println("Max profit for length " + len + ":" + profit(value, len3));
        
        int len4 = 17;
        
        System.out.println("Max profit for length " + len + ":" + profit(value, len4));
        
        int len5 = 20;
        
        System.out.println("Max profit for length " + len + ":" + profit(value, len5));
        
        //repeat for all lengths 10 and 20
	
	}
	
	 public static int profit(int[] value, int length) {
		 int[] solution = new int[length + 1];
			solution[0] = 0;

			for (int i = 1; i <= length; i++) {
				int max = -1;
				for (int j = 0; j < i; j++) {
					max = Math.max(max, value[j] + solution[i - (j + 1)]);
					solution[i] = max;
				}
			}
			return solution[length];
	      }

	//R(n) = max(p(i) + r(n-1)) while 1<=i<=n
	
	
	
}

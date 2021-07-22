
public class MinimumDecentEXTRACREDIT {

	public static void main(String[] args) {
		
		int[][] Triangle = {{4},  
                			{9, 2},  
                			{3, 6, 7},
							{9,5,7,3}};
		
		System.out.println(minSumPath(Triangle));
		
	}
	
	static int minSumPath(int[][] A) { 
        
        int []memo = new int[A.length]; 
        int n = A.length - 1; 
      
        
        for (int i = 0;  
                 i < A[n].length; i++)  
            memo[i] = A[n][i]; 
 
        for (int i = A.length - 2;  
                 i >= 0; i--)  
            for (int j = 0;  
                     j < A[i].length; j++)  
                memo[j] = A[i][j] + (int)Math.min(memo[j],  memo[j + 1]); 
     
        return memo[0]; 
    } 

}

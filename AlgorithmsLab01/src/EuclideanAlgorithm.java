import java.util.Scanner;

public class EuclideanAlgorithm {
	
	public static double outx;
	public static double outy;

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter 2 numbers (n and m)");
		int n = in.nextInt();
		int m = in.nextInt();
		in.close();
		
		int x = 1;
		int y = 1;
		
		System.out.println("d = " + d(m, n, x, y));
		System.out.println("x = " + outx + " y = " + outy);
		
		
		
	}
	
	public static int d(int m, int n, double x, double y) {
		
		if(m == 0) {
			
			x = 0;
			y = 1;
			
			return n;
			
		}
		else {
			
			int x2 =  1; 
			int y2 = 1;
			
			int d =  d(n%m, m, x2, y2);

			x = (y2 - (n/m)) * x2; 
	        y = x2;
			
	        outy = y;
	        outx = x;
	        
			return d;
		}

	}

}

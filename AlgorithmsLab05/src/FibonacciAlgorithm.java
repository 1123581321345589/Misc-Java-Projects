import java.util.Scanner;

public class FibonacciAlgorithm {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = in.nextInt();
		
		int[] display = fibonacciNumbers(n);
		
		System.out.println("Result: ");
		
		for(int i = 0; i < display.length - 1; i++) {
			System.out.print(display[i] + ", ");
		}
		
		System.out.println(display[4]);
		
		recursiveFibonacci(1, 1, display, n);
		
		System.out.println("Recursive Result: ");
		
		for(int i = 0; i < display.length - 1; i++) {
			System.out.print(display[i] + ", ");
		}
		
		System.out.println(display[4]);

	}
	
	public static int[] fibonacciNumbers(int n) {
		
		int[] result = new int[5];
		
		int num = 1;
		int prev = 1;
		int temp;
		
		if(n <= 1) {
			result[0] = 1;
			return result;
		}
		
		int x = 5;
		
		for(int i = 2; i < n; i++) {
			
			temp = num;
			num += prev;
			prev = temp;
			
			
			if(n - i <= x) {
				
				result[n - i - 1] = num;
				
			}
			
			
		}
		
		return result;
	}
	
	public static void recursiveFibonacci(int prev, int n, int[] result, int i) {
		
		if(i >= 0) {
			
			int temp = n;
			n += prev;
			prev = temp;
			
			if(i < 5) {
				result[i] = n;
			}
			
			i--;
			
			recursiveFibonacci(prev, n, result, i);
			
		}
		
	}

}

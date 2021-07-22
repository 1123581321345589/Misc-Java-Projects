
public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double temp = 12.2;
		double out = 0;
		for(int i = 0; i < 10; i++) {
			out = 10.8 - (0.5 * (temp - 10.8));
			temp = out;
			System.out.println(out);
		}

	}

}

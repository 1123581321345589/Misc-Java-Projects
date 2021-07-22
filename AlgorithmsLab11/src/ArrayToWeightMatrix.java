
public class ArrayToWeightMatrix {

	public static void main(String[] args) {
		
		String[] AdjacencyList = {  "(2, 3), (3, 8), (5, -4)", 
				 					"(4, 1), (5, 7)",
				 					"(2, 4)",
				 					"(1, 2), (3, -5)",
				 					"(4, 6)" 				};
		
		char[][] Matrix = convert(AdjacencyList);
		
		char[][] shortPath = findShortestPath(Matrix);
		
		System.out.println("Weight Matrix: ");
		System.out.println();
		
		for(int i = 0; i < Matrix.length; i++) {
			System.out.print(i + ": ");
			for(int j = 0; j < Matrix.length; j++) {
				System.out.print(Matrix[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Short path Matrix: ");
		System.out.println();
		
		for(int i = 0; i < shortPath.length; i++) {
			System.out.print(i + ": ");
			for(int j = 0; j < shortPath.length; j++) {
				System.out.print(shortPath[i][j] + ", ");
			}
			System.out.println();
		}
		
		
		
	}
	
	public static char[][] convert(String[] AList){
		
		char[][] weight = new char[5][5];
		
		for(int i = 0; i < weight.length; i++) {
			for(int j = 0; j < weight.length; j++) {
				if (i == j) {
					weight[i][j] = '0';
				}
				else if(isContained(i, j, AList)) {
					weight[i][j] = getWeight(i, j, AList);
				}
				else {
				weight[i][j] = '}'; // } == inf weight
				}
			}
		}
		return weight;
	}

	public static char getWeight(int i, int j, String[] AList) {
		
		String target = AList[i];
		
		for(int e = 0; e < target.length(); e++) {
			if(target.charAt(e) == (j + 48)) {
				if(target.charAt(e - 1) == '(') {
					if(target.charAt(e + 2) == '-') {
						return target.charAt(e + 3);
					}
					return target.charAt(e + 2);
				}
			}
		}
		return '*'; //error
	}
	
	public static boolean isContained(int i, int j, String[] AList) {
		
		String target = AList[i];

		for(int e = 0; e < target.length(); e++) {
			if(target.charAt(e) == (j + 48)) {
				if(target.charAt(e - 1) == '(') {
					return true;
				}
			}
		}
		
		
		
		return false;
	}
	
	public static char[][] findShortestPath(char[][] weight) {
		for(int k = 0; k < weight.length; k++) {
			for(int i = 0; i < weight.length; i++) {
				for(int j = 0; j < weight.length; j++) {
					weight[i][j] = (char) (min(weight[i][j], (char) (weight[i][k] + weight[k][j])));
				}
			}
		}
		return weight;
	}
	
	public static char min(char a, char b) {
		if (a == '}') {
			return b;
		}
		else if(a < b) {
			return a;
		}
		return b;
	}
	

}

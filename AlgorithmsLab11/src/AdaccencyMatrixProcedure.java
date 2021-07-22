
public class AdaccencyMatrixProcedure {
	
	
	public static void main(String[] args) {
		//Starting adjacency Matrix
		char[][] adjacency =  { { 0, 1, 0, 1, 0, 0 }, 
                				{ 1, 0, 1, 0, 1, 0 }, 
                				{ 0, 1, 0, 0, 0, 1 }, 
                				{ 1, 0, 0, 0, 1, 0}, 
                				{ 0, 1, 0, 1, 0, 1}, 
                				{ 0, 0, 1, 0, 1, 0}};
		
		LinkedList<Character>[] array = new LinkedList[adjacency[0].length];
		
		array = convertMatrix(adjacency);
	}
	
	public static LinkedList<Character>[] convertMatrix(char[][] a){
		

        int l = a[0].length; 
        @SuppressWarnings("unchecked")
		LinkedList<Character>[] adjListArray  = new LinkedList[l]; 

        for (int i = 0; i < l; i++) { 
            adjListArray[i] = new LinkedList<Character>(); 
        } 
          
        int i, j; 
        char var;
        for (i = 0; i < a[0].length; i++) { 
        	System.out.print((char) (i + 65) + ": ");
            for (j = 0; j < a.length; j++) { 
                if (a[i][j] == 1) {	
                	 var = ((char) (j + 65));
                	adjListArray[i].add(var);
                	System.out.print(var + " --> ");
                } 
               
            } 
            System.out.println();
        } 
          
        return adjListArray; 
    } 
	
	static void printArrayList(LinkedList[] ListArray) { 
		
		for(int i = 0; i < ListArray.length; i++) {
			while(ListArray[i].iterator().hasNext()) {
				
				System.out.print(ListArray[i].iterator().next());
				System.out.print(" -> ");
				
			}
			
			System.out.println();
			
		}
		
		
		
	}
	
}

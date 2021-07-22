import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class CapitalsTree {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/Capitals");
		Scanner in = new Scanner(file);
		AVLTree<String> tree = new AVLTree<String>();
		
		while(in.hasNextLine()) {
			tree.insert(in.nextLine());
		}
		System.out.println("Number of Nodes: ");
		System.out.println(tree.getNumNodes());
		System.out.println("Height: ");
		System.out.println(tree.getHeight());
		
		ArrayList<String> ar = new ArrayList<String>();
		
		ar = tree.InOrderIterator();
		
		for(int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
		
	}

}

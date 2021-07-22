import java.util.Iterator;

public class TreeTraversals {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		/*
		BinaryTree<BinaryNode> bt = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> Lt = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> Rt = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> l22 = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> L11 = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> H = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> I = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> L = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> F = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> G = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> J = new BinaryTree<BinaryNode>();
		BinaryTree<BinaryNode> K = new BinaryTree<BinaryNode>();
		
		
		
		K.setTree(new BinaryNode("K"));
		J.setTree(new BinaryNode("J"));
		G.setTree(new BinaryNode("G"), J, K);
		F.setTree(new BinaryNode("F"));
		Rt.setTree(new BinaryNode("C"), F, G);
		L.setTree(new BinaryNode("L"));
		I.setTree(new BinaryNode("I"), null, L);
		H.setTree(new BinaryNode("H"));
		l22.setTree(new BinaryNode("D"), H, I);
		L11.setTree(new BinaryNode("E"));
		Lt.setTree(new BinaryNode("B"), l22, L11);
		bt.setTree(new BinaryNode("A"), Lt, Rt);
		*/
		
		BinaryTreeInterface<String> jTree = new BinaryTree <>();
		jTree.setTree("J");
		
		BinaryTreeInterface<String> KTree = new BinaryTree <>();
		KTree.setTree("K");
		
		BinaryTreeInterface<String> GTree = new BinaryTree <>();
		GTree.setTree("G", jTree, KTree); //left, right
		
		BinaryTreeInterface<String> fTree = new BinaryTree <>();
		fTree.setTree("F");
		
		BinaryTreeInterface<String> cTree = new BinaryTree <>();
		cTree.setTree("C", fTree, GTree);
		
		BinaryTreeInterface<String> lTree = new BinaryTree <>();
		lTree.setTree("L");
		
		BinaryTreeInterface<String> emptyTree = new BinaryTree <>();
		
		BinaryTreeInterface<String> iTree = new BinaryTree <>();
		iTree.setTree("I", emptyTree, lTree);
		
		BinaryTreeInterface<String> hTree = new BinaryTree <>();
		hTree.setTree("H");
		
		BinaryTreeInterface<String> dTree = new BinaryTree <>();
		dTree.setTree("D", hTree, iTree);
		
		BinaryTreeInterface<String> eTree = new BinaryTree <>();
		eTree.setTree("E");
		
		BinaryTreeInterface<String> bTree = new BinaryTree <>();
		bTree.setTree("B", dTree, eTree);
		
		BinaryTreeInterface<String> aTree  = new BinaryTree <>();
		aTree.setTree("A", bTree, cTree);
		
		Iterator i = aTree.getPreorderIterator();
		
		Iterator post = aTree.getPostorderIterator();
		
		Iterator order = aTree.getInorderIterator();
		
		Iterator level = aTree.getLevelorderIterator();

		System.out.println("Height of Tree: " + aTree.getHeight());
		
		System.out.println("Number of Nodes: " + aTree.getNumberOfNodes());
		
		
		
		//System.out.println(bt.toString());
		System.out.println("PreorderIteration of Tree: ");
		int num = 0;
		while(i.hasNext() != false) {
			System.out.println(i.next());
			num++;
		}
		System.out.println("PostorderIteration of Tree: ");
		for(int v = 0; v < 4; v++) {
			System.out.println(post.next());
		}
		System.out.println("InorderIteration of Tree: ");
		while(order.hasNext() != false) {
			System.out.println(order.next());
		}
		System.out.println("LevelorderIteration of Tree: ");
		while(level.hasNext() != false) {
			System.out.println(level.next());
		}
		
		
		
	}
	
}

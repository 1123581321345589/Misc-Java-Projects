import java.util.ArrayList;

public class AVLTree <T extends Comparable<? super T>> {
	
	class AVLNode {
	
		T data;
		AVLNode rChild = null;
		AVLNode lChild = null;
		int LHeight;
		int RHeight;
		int height;
		
		public int getHeight() {
			
			if(LHeight > RHeight) {
				return LHeight;
			}
			
			
			return RHeight;
		}
		
		public void getRealHeightL(int height, AVLNode curr) {
			
			if(curr != null) {
				height = height + 1;
				getRealHeightL(height, curr.lChild);
			}
			
			LHeight = height;
	}
		public void getRealHeightR(int height, AVLNode curr) {
			
			if(curr != null) {
				height = height + 1;
				getRealHeightR(height, curr.rChild);
			}
			
			RHeight = height;
	}
		
	}
	
	
	
	private AVLNode root;
	
	public boolean isEmpty() {
		return root == null;
	}

	public int getNumNodes() {
		
		AVLNode curr = root;
		
		int num = 0;
		
		while(curr != null) {
			
			num++;
			
			
			
			
		}
		
		return num;
	}
	
	public boolean contains(T entry) {
		
		
		return true;
	}
	
	public void insert(T entry) {
		
		if(isEmpty()) {
			root.data = entry;
		}
		else {
			
			rInsert(entry, root);
			
			if(root.RHeight - root.LHeight >= 2) {
				
				llRotate(root);
				
			}
			else if(root.RHeight - root.LHeight <= -2) {
				
				rrRotate(root);
				
			}
			else if(root.RHeight - root.LHeight == 1) {
				rlRotate(root);
			}
			else if(root.RHeight - root.LHeight == -1) {
				lrRotate(root);
			}
			
		}
	}
	private void rInsert(T entry, AVLNode curr) {
		
		if(entry.compareTo(curr.data) > 0) {
			
			if(curr.lChild == null) {
				curr.lChild.data = entry;
			}
			else {
				rInsert(entry, curr.lChild);
			}
			
		}
		else {
			
			if(curr.rChild == null) {
				curr.rChild.data = entry;
			}
			else {
				rInsert(entry, curr.rChild);
			}
			
		}
		
	}

	public int getHeight() {
		root.getRealHeightL(0, root);
		return root.height;
	}

	public void clear() {
		root = null;
	}
	
	public void llRotate(AVLNode point) {
		
		lRotate(point);
		lRotate(point);
		
	}
	public void lrRotate(AVLNode point) {
		
		lRotate(point);
		rRotate(point);
		
	}
	private void rrRotate(AVLNode point) {
	
		rRotate(point);
		rRotate(point);
		
	}
	private void rlRotate(AVLNode point) {
	
		rRotate(point);
		lRotate(point);
		
	}
	
	private void rRotate(AVLNode point) {
		
		AVLNode left = point.lChild;
		AVLNode right = left.rChild;
		
		left.rChild = point;
		point.lChild = right;
		
		root.getRealHeightR(0, root);
		root.getRealHeightL(0, root);
		
	}
	private void lRotate(AVLNode point) {
		
		AVLNode right = point.rChild;
		point.lChild = right.rChild;
		
		right.rChild = point;
		
		root.getRealHeightR(0, root);
		root.getRealHeightL(0, root);
	}
	public ArrayList<T> InOrderIterator() {
		
		InOrderIterator it = new InOrderIterator(root);
		
		
		
		return it.nodesSorted;
	}
	
	///////////////////////////////////////////////////////////////////////
	
	class InOrderIterator {

	    ArrayList<T> nodesSorted;
	    int index;

	    public InOrderIterator(AVLNode root) {

	        this.nodesSorted = new ArrayList<T>();
	        
	        this.index = -1;

	        this.inorder(root);
	        
	    }

	    private void inorder(AVLNode root) {

	        if (root == null) {
	            return;
	        }

	        this.inorder(root.lChild);
	        this.nodesSorted.add(root.data);
	        this.inorder(root.rChild);
	    }

	    
	    public T next() {
	        return this.nodesSorted.get(++this.index);
	    }

	    public boolean hasNext() {
	        return this.index + 1 < this.nodesSorted.size();
	    }
	}
	
	//////////////////////////////////////////////////////////////

	
	
	
}
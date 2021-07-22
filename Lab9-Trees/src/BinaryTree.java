import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree <T> implements BinaryTreeInterface<T> {
     private BinaryNode<T> root;
	public BinaryTree () {
	   root = null;
	 }

	public BinaryTree (T rootData) {
	   root = new BinaryNode <> (rootData);
	 }

	public BinaryTree (T rootData, BinaryTree <T> leftTree,
                            	 BinaryTree <T> rightTree) {
		initializeTree (getRootData(), leftTree, rightTree);					 
	 }
	 
	public void setTree (T rootData) {
	    root = new BinaryNode <> (rootData);
	 }
	 
	public void setTree (T rootData, 
                           BinaryTreeInterface <T> leftTree,
                           BinaryTreeInterface <T> rightTree) {
	    initializeTree (rootData, (BinaryTree <T>) leftTree, 
		                         (BinaryTree <T>) rightTree);
	 }
	
	private void initializeTree (T rootData, 
            BinaryTree <T> leftTree, BinaryTree <T> rightTree) {
	   root = new BinaryNode <> (rootData);
        if (leftTree != null)	
           root.setLeftChild(leftTree.root);
        if (root.getRightChild() != null)	
           root.setRightChild(rightTree.root);	   
	 }

	@Override
	public T getRootData() {
		return root.getData();
	}

	@Override
	public int getHeight(){
	    return root.getHeight();
	}


	@Override
	public int getNumberOfNodes(){
	    return root.getNumberOfNodes();
	}


	@Override
	public boolean isEmpty() {
		if(root.getNumberOfNodes() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		return new PreorderIterator<T>();
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		return new PostOrderIterator();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	@Override
	public Iterator<T> getLevelorderIterator() {
		return new LevelOrderIterator();
	}
	
	private class PreorderIterator<T> implements Iterator <T> {
		
		   private Stack<BinaryNode<T>> nodeStack;
		   BinaryNode <T> currNode;
		        
		   @SuppressWarnings("unchecked")
		public PreorderIterator (){
		      if (root == null) {
				throw new IllegalArgumentException ("No iteration on empty tree");
		      }
		       nodeStack = new Stack<>();
		       nodeStack.push((BinaryNode<T>) root);
		   }
		        
		    @Override
		    public boolean hasNext() {
		       return (!nodeStack.isEmpty());
		    }
		        
		    @Override
		    public T next() {
		     currNode = nodeStack.pop();
			 T item = currNode.getData();
			 if (currNode.hasRightChild())
				nodeStack.push(currNode.getRightChild());
			 if (currNode.hasLeftChild())
				nodeStack.push(currNode.getLeftChild());
			 return item;
		    }
		    @Override
		    public void remove (){
		        throw new UnsupportedOperationException();
		    }
		}

	private class InorderIterator<T> implements Iterator <T> {
		
		private Stack <BinaryNode<T>> nodeStack;
		
		@SuppressWarnings("unchecked")
		public InorderIterator() {
			nodeStack = new Stack <> ();
			addToStack((BinaryNode<T>) root);
		}
			
		private void addToStack (BinaryNode<T> root) {
			if (root == null)
				return;
		     BinaryNode <T> right = 
	                         (BinaryNode <T>)root.getRightChild();
			BinaryNode <T> left = 
	                         (BinaryNode <T>)root.getLeftChild();	
			addToStack(right);
			nodeStack.push(root);
			addToStack(left);
		}
		
	public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}
			
		public T next() {
			return nodeStack.pop().getData();
		}

	      public void remove() {
			throw new UnsupportedOperationException();
		}
			
	}
					

		   
	private class PostOrderIterator implements Iterator <T> {

		   private Stack <BinaryNode <T>> nodeStack;
		        
		   public PostOrderIterator() {
		       BinaryNode <T> currNode = root;              
		       nodeStack = new Stack <>();
		       while (currNode != null) {
				nodeStack.push(currNode);
				currNode = (BinaryNode<T>) currNode.getRightChild();	
			}
		   }
		        
		   @Override
		   public boolean hasNext() {
		       return (!nodeStack.isEmpty ());
		   }
		   @Override
		   public T next () {
		       BinaryNode <T> currNode = nodeStack.pop();
		       T data = currNode.getData(); 
		        if (currNode.hasLeftChild() ){
		            currNode = currNode.getLeftChild();     
		           while (currNode != null){
		              nodeStack.push(currNode);
		              currNode = (BinaryNode<T>) currNode.getRightChild();
		           }
		       }
		       return data;
		   }
		        
		   @Override
		   public void remove () {
		       throw new UnsupportedOperationException();
		   }
		}
	
	private class LevelOrderIterator implements Iterator<T> {
		
		private Stack <BinaryNode <T>> nodeStack;
		
		public LevelOrderIterator() {
			 if (root == null)
					throw new IllegalArgumentException (
			                                  "No iteration on empty tree");
			          
			       nodeStack = new Stack <>();
			       nodeStack.push((BinaryNode<T>) root);	
		   }

		@Override
		public boolean hasNext() {
			 return (!nodeStack.isEmpty ());
		}

		@Override
		public T next() {
			BinaryNode <T> currNode = nodeStack.pop();
		       T data = currNode.getData(); 
		        if (currNode.hasLeftChild() ){
		            currNode = currNode.getLeftChild();     
		           while (currNode != null){
		              nodeStack.push(currNode);
		              currNode = (BinaryNode<T>) currNode.getRightChild();
		           }
		       }
		       return data;
		}
		@Override
		   public void remove () {
		       throw new UnsupportedOperationException();
		   }
	}
	
   }

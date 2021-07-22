import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> {
	
	private static class Node<T>{
	   private T data;
	   private Node<T> next;

	   public Node(T data, Node<T> next)
	   {
	      this.data = data;
	      this.next = next;
	   }
	}
	
	public Node<T> head;
	
	public void addFirst(T data) {
		
		head = new Node<T>(data, null);
		
	}
	
	public int size() {
		int count;
		if(head == null) {
			 count = 0;
		}
		else {
			 count = 1;
			while(iterator().hasNext() && count < 5) {
				iterator().next();
				count++;
			}
		}
		
		return count;
	}
	
	public void add(T data) {
		
	   if(head == null) {
		   addFirst(data);
	   }
	   else {
	      Node<T> temp = head;
	      while(temp.next != null) {
	    	  temp = temp.next;
	    	}
	      temp.next = new Node<T>(data, null);
	   }
	}
	
	public Iterator<T> iterator() {
	   return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T> {
	   private Node<T> nextNode;

	   public LinkedListIterator() {
	      nextNode = head;
	   }
	   
	   public T next() {
	      if(!hasNext()) {
	    	  throw new NoSuchElementException();
	      }
	      T temp = nextNode.data;
	      nextNode = nextNode.next;
	      return temp;
	   }
	   
	   public void reset() {
		   nextNode = head;
	   }

	@Override
	public boolean hasNext() {
		
		if(nextNode.equals(null)) {
			reset();
			return false;
		}
		else {
			nextNode = nextNode.next;
			return true;
		}

	}
	}
	
}

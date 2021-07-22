
public class CircularQueue<T> implements queueInterface<T> {

	T[] circularArray;
	int front;
	int back;
	int size;
	
	
	@SuppressWarnings("unchecked") CircularQueue() {
		circularArray = (T[]) new Object[10];
		front = 0;
		back = 0;
		size = 0;
	}
	 @SuppressWarnings("unchecked")
	public CircularQueue(int Capacity) {
	      front = back = size = 0;
	      circularArray = ( (T[])(new Object[Capacity]) );
	   }
	
	@Override
	public void enqueue(T value) {
		//checks size
		if(size == circularArray.length) {
			@SuppressWarnings("unchecked")
			T[] copyArray = (T[]) new Object[circularArray.length * 2];
		for(int i = 0; i < circularArray.length; i++) {
			copyArray[i] = circularArray[front];
			front = (front + 1) % circularArray.length;
		}
		front = 0;
		back = size;
		circularArray = copyArray;
		}
		//adds to queue
		circularArray[back] = value;
		
		back = (back + 1) % circularArray.length;
		
		size++;
		
	}

	@Override
	public T dequeue() {
		
		 T result = circularArray[front];
	      circularArray[front] = null;

	      front = (front+1) % circularArray.length;

	      size--;

	      return result;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		
		String string = "";
		
	    int i = 0;
	 
	    while(i < size) {
	     if(circularArray[i] != null) {
	       string += circularArray[i].toString() + "\n";
	     }
	    i++;
	    }

	    return string;
	}

	
	
	
	
}

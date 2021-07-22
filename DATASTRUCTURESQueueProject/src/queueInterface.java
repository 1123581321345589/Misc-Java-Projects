
public interface queueInterface<T> {

	void enqueue(T value);
	
	T dequeue();
	
}

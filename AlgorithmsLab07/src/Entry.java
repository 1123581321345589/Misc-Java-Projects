
public class Entry<K,V> {

	private K key;
	
	private V value;
	
	@SuppressWarnings("unchecked")
	public Entry(String key, String value){
		
		this.key = (K) key;
		this.value = (V) value;
		
	}
	
	public K getKey() {
		return this.key;
	}
	public V getValue() {
		return this.value;
	}
	
	
	
}

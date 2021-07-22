
public class HDictonary<K,V> {
	
	Entry<K,V>[] table;
	
	@SuppressWarnings({ "unchecked" })
	public HDictonary(int m) {
		
		//make sure size is prime number (m)
		if(m % 2 == 0) {
			m = m + 1;
		}
		table = new Entry[m];
		
	}
	
	int hash(K key, int i) {
		
		int m = table.length;
		
		int c = key.hashCode();
		
		int h1 = (c + m/2) % m;
		int h2 = c % (m - 1);
		//double hashes value
		//return h1(c) + ih2(c) % m
		return (h1 + (i*h2)) % m;
	}
	
	public void hashInsert(Entry<K,V> x) {
		
		int i = 0;
		
		do {
			
			i = hash(x.getKey(), i);
			
			if(i < 0 ) {
				i = (i * i) % table.length;
			}
			
			table[i] = x;
			
			
		} while(table[i] != null);
		
	}
	public String hashSearch(K key) {
		
		int index = hash(key, 0);
		
		if(table[index] != null) {
			return (String) table[index].getValue();
		}
		
		return null;
	}
	
	public int hashCode(String a) {
		//computes hashcode as sum of acii vals
				int result = 0;;
				for(int i = 0; i < a.length(); i++) {
					result += a.charAt(i);
				}
				return result;
			}
			
	}

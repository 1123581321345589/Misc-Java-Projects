
import java.util.Arrays;

public final class ResisableArrayBag<T> implements BagInterface<T> {

     private T[] bag;
     private int numberOfEntries;
     private boolean initialized = false;
     private static final int DEFAULT_CAPACITY = 100;
     
     public ResisableArrayBag() {
          this(DEFAULT_CAPACITY);
          numberOfEntries = 0;
     } 
     
     public ResisableArrayBag(int desiredCapacity) {
          
          @SuppressWarnings("unchecked")
          T[] tempBag = (T[]) new Object[desiredCapacity]; 
                                                          
          bag = tempBag;
          numberOfEntries = 0;
          initialized = true;
     } 
     public ResisableArrayBag<T> union(ResisableArrayBag<T> bag2) {
    	 
    	 ResisableArrayBag<T> returnBag = new ResisableArrayBag<T>();
    	 
    	 for(int i = 0; i < bag.length; i++) {
    		 returnBag.add(bag[i]);
    		 returnBag.add(bag2.bag[i]);
    	 }
  
    	 
 		return returnBag;
 	}
     
     public T atIndex(int i) {
    	 return bag[i];
     }
     
 	public ResisableArrayBag<T> intersection(ResisableArrayBag<T> bag2) {
 		
 		ResisableArrayBag<T> returnBag = new ResisableArrayBag<T>();
 		
 		ResisableArrayBag<T> Bag3 = bag2;
 		
 		ResisableArrayBag<T> Bag4 = this;
 		
 		for(int i = 0; i < bag.length; i++) {
 			for(int j = 0; j < bag2.getArrayBagSize(); j++) {
   		 if(Bag4.bag[i] == Bag3.bag[j]) {
   			 returnBag.add(bag[i]);
   			 Bag4.remove(Bag4.bag[i]);
   			 Bag3.remove(Bag3.bag[j]);
   		 }
 			}
   	 }
 	
 		
 		return returnBag;
 	}
 	
     public boolean add(T newEntry) {
          checkInitialization();
          boolean result = true;
          if (isArrayFull()) {
              resize();
          }
          
          bag[numberOfEntries] = newEntry;
          numberOfEntries++;
         
          return result;
     }
     
     private void resize()
     {
          bag = Arrays.copyOf(bag, bag.length + 1);
     }
     
     public int getArrayBagSize()
     {
          return bag.length;
     }
     
     public T[] toArray()
     {
          checkInitialization();
          
          @SuppressWarnings("unchecked")
          T[] result = (T[]) new String[numberOfEntries];
          for (int index = 0; index < numberOfEntries; index++)
          {
              result[index] = bag[index];
          } 
          return result;
          
     } 
     public boolean isEmpty()
     {
          return numberOfEntries == 0;
     } 
     public int getCurrentSize()
     {
          return numberOfEntries;
     } 
     public int getFrequencyOf(T anEntry)
     {
          checkInitialization();
          int counter = 0;
          for (int index = 0; index < numberOfEntries; index++)
          {
              if (anEntry.equals(bag[index]))
              {
                   counter++;
              } 
          } 
          return counter;
     } 
     public boolean contains(T anEntry)
     {
          checkInitialization();
          return getIndexOf(anEntry) > -1; 
     } 
     
     public void clear()
     {
          while (!isEmpty())
              remove();
     } 
     public T remove()
     {
          checkInitialization();
          T result = removeEntry(numberOfEntries - 1);
          return result;
     } 
     public boolean remove(T anEntry)
     {
          checkInitialization();
          int index = getIndexOf(anEntry);
          T result = removeEntry(index);
          return anEntry.equals(result);
     } 
     
     private boolean isArrayFull()
     {
          return numberOfEntries >= bag.length;
     } 
     private int getIndexOf(T anEntry)
     {
          int where = -1;
          boolean found = false;
          int i = 0;
          while (!found && (i < numberOfEntries))
          {
              if (anEntry.equals(bag[i]))
              {
                   found = true;
                   where = i;
              } 
              i++;
          } 
          return where;
     } 
     public T removeEntry(int givenIndex)
     {
          T result = null;
          if (!isEmpty() && (givenIndex >= 0))
          {
              result = bag[givenIndex]; 
              int lastIndex = numberOfEntries - 1;
              bag[givenIndex] = bag[lastIndex]; 
                                                
              bag[lastIndex] = null; 
              numberOfEntries--;
          } 
          return result;
     } 
     
     private void checkInitialization()
     {
         if (!initialized)
             throw new SecurityException(
                       "ArrayBag object is not initialized properly.");

     }
	
}

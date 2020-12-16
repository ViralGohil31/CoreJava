/**
 * below is Hash MAp example
 *Here at time we place element in HashMAp it will take hash Code of Key and
 *find the Bucket of that Index.and than it will place it in that bucket.
 *if more than one element having same hashcode for key.
 *than it will store it in same bucket.by maintaning linked list.
 *if 10,20 value we are storing and both key having same hashcode than it will store it in same bucket.
 *
 *it will use hashCode() method to find right bucket.
 *it will use equal() method to compare the right element in the same bucket.
 *
 */


package CollectionExample;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;




public class Map<K,V> {
	public static void main(String[] args) {
	/*	Ds<String,String> b = new Ds<String,String>();
		b.put("1","Viral");
		b.put("1", "Rajendra");
		b.put("2", "Raj");
		System.out.print(b.get("1"));*/
		
		Ds<SimpleObj,String> b = new Ds<SimpleObj,String>();
		b.put(new SimpleObj(20, 10), "Viral");
		b.put(new SimpleObj(20, 10), "Raj");
		b.put(new SimpleObj(20,10),"Nitin");
		b.put(new SimpleObj(20,10),"Akshay");
		
		
		Iterator<Ds.Entry<SimpleObj,String>> iteratorEntry = b.entrySet().iterator();
		while(iteratorEntry.hasNext()){
			Ds.Entry<SimpleObj,String> entry = iteratorEntry.next();
			System.out.println(" value"+entry.getValue());
		}
		System.out.print(b.get(new SimpleObj(20, 10)));
	}
}

class Ds<K,V>{
	 transient Entry[] table;
	 
	  transient int size;

	  int threshold;
	    
	  static final int DEFAULT_INITIAL_CAPACITY = 16;

	  static final int MAXIMUM_CAPACITY = 1 << 30;

	    
	  static final float DEFAULT_LOAD_FACTOR = 0.75f;

	  final float loadFactor;
	  
	  transient volatile int modCount;
	  
	  public Ds() {
	        this.loadFactor = DEFAULT_LOAD_FACTOR;
	        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
	        table = new Entry[DEFAULT_INITIAL_CAPACITY];
	    }
	  
	static class Entry<K,V>{
		 final K key;
	        V value;
	        Entry<K,V> next;
	        final int hash;

	        Entry(int h, K k, V v, Entry<K,V> n) {
	            value = v;
	            next = n;
	            key = k;
	            hash = h;
	        }

	        public final K getKey() {
	            return key;
	        }

	        public final V getValue() {
	            return value;
	        }
	        
	        void recordAccess(Ds<K,V> m) {
	        }

	}
	
	
	  public V put(K key, V value) {
	      
	        int hash = hash(key.hashCode());
	        int i = indexFor(hash, table.length);
	        
	        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
	            Object k;
	            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
	                V oldValue = e.value;
	                e.value = value;
	                e.recordAccess(this);
	                return oldValue;
	            }
	        }
	        
	        modCount++;
	        addEntry(hash, key, value, i);
	        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
		           System.out.println("Buket :"+i+" KEY :"+e.key+" VALUE : "+e.value);
		        }
	        return null;
	    }
	  
	  
	  static int indexFor(int h, int length) {
	        return h & (length-1);
	    }
	  
	  
	  static int hash(int h) {
	        // This function ensures that hashCodes that differ only by
	        // constant multiples at each bit position have a bounded
	        // number of collisions (approximately 8 at default load factor).
	        h ^= (h >>> 20) ^ (h >>> 12);
	        return h ^ (h >>> 7) ^ (h >>> 4);
	    }
	  
	 void addEntry(int hash, K key, V value, int bucketIndex) {
			Entry<K,V> e = table[bucketIndex];
		        table[bucketIndex] = new Entry<K,V>(hash, key, value, e);
		        size++;
	}
	 
	  public V get(Object key) {
	      
	        int hash = hash(key.hashCode());
	        for (Entry<K,V> e = table[indexFor(hash, table.length)];
	             e != null;
	             e = e.next) {
	            Object k;
	            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
	                return e.value;
	        }
	        return null;
	    }
	 
	  
	  private transient Set<Ds.Entry<K,V>> entrySet = null;
	  
	  public Set<Ds.Entry<K,V>> entrySet() {
			return entrySet0();
		    }
	  
	  private Set<Ds.Entry<K,V>> entrySet0() {
	        Set<Ds.Entry<K,V>> es = entrySet;
	        return es != null ? es : (entrySet = new EntrySet());
	    }
	  
	  private final class EntrySet implements Set<Entry<K, V>> {
	        public Iterator<Ds.Entry<K,V>> iterator() {
	            return newEntryIterator();
	        }

		
			public int size() {return 0;}
			public boolean isEmpty() {return false;}
			public boolean contains(Object o) {return false;}
			public Object[] toArray() {return null;}
			public <T> T[] toArray(T[] a) {return null;}
			public boolean add(Entry<K, V> e) {return false;}
			public boolean remove(Object o) {return false;}
			public boolean containsAll(Collection<?> c) {return false;}
			public boolean addAll(Collection<? extends Entry<K, V>> c) {return false;}
			public boolean retainAll(Collection<?> c) {return false;}
			public boolean removeAll(Collection<?> c) {return false;}
			public void clear() {}
	      
	    }

	  Iterator<Ds.Entry<K,V>> newEntryIterator()   {
	        return new EntryIterator();
	    }
	  
	  private final class EntryIterator extends HashIterator<Ds.Entry<K,V>> {
	        public Ds.Entry<K,V> next() {
	            return nextEntry();
	        }
	    }
	  
	  
	  private abstract class HashIterator<E> implements Iterator<E> {
	        Entry<K,V> next;	// next entry to return
	        int expectedModCount;	// For fast-fail
	        int index;		// current slot
	        Entry<K,V> current;	// current entry

	        HashIterator() {
	            expectedModCount = modCount;
	            if (size > 0) { // advance to first entry
	                Entry[] t = table;
	                while (index < t.length && (next = t[index++]) == null)
	                    ;
	            }
	        }

	        public final boolean hasNext() {
	            return next != null;
	        }

	        final Entry<K,V> nextEntry() {
	            if (modCount != expectedModCount)
	                throw new ConcurrentModificationException();
	            Entry<K,V> e = next;
	            if (e == null)
	                throw new NoSuchElementException();

	            if ((next = e.next) == null) {
	                Entry[] t = table;
	                while (index < t.length && (next = t[index++]) == null)
	                    ;
	            }
		    current = e;
	            return e;
	        }

	        public void remove() {
	            if (current == null)
	                throw new IllegalStateException();
	            if (modCount != expectedModCount)
	                throw new ConcurrentModificationException();
	            Object k = current.key;
	            current = null;
	            expectedModCount = modCount;
	        }

	    }

	  
}




class SimpleObj{
	int a;
	int b;
	SimpleObj(int a,int b){
		this.a = a;
		this.b = b;
	}
	
	@Override
	 public boolean equals(Object obj) {
		/*if(obj instanceof SimpleObj && (((SimpleObj)obj).a==this.a)){
			return true;
		}*/
		return false;
	}
	
	
	@Override
	 public  int hashCode(){
		return a-b;
		
	}
}
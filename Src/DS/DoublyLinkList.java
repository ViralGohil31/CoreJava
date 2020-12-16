package DS;




public class DoublyLinkList {
	public static void main(String[] args) {
		LL<String> ll = new LL<String>();
		ll.addFirst("Hello");
		ll.add("Viral");
		ll.add("Rajendra");
		ll.add("Ajay");
	
		System.out.println("Index at 0 :"+ ll.get(0));
		
		for(LL.Entry e = ll.header.next;e!=ll.header;e=e.next){
			System.out.println(e.info);
		}
	}
	
}





class LL<K>{
	
	Entry<K> header  = new Entry(null,null, null);
	int size=0;
	public LL() {
		header.next = header.previous = header;
	}
	
	public void add(K info){
		addBefore(info,header);
	}
	
	public void addBefore(K info,Entry<K> header){
		Entry<K> newEntry = new Entry(info, header.previous,header);
		newEntry.previous.next = newEntry;
		newEntry.next.previous = newEntry;
		size++;
	}
	
	
	  public K get(int index) {
	        return entry(index).info;
	  }
	  
	  public void addFirst(K e) {
			addBefore(e, header.next);
	  }

      public void addLast(K e) {
			addBefore(e, header);
      }
		    
	  private Entry<K> entry(int index) {
	        if (index < 0 || index >= size)
	            throw new IndexOutOfBoundsException("Index: "+index+
	                                                ", Size: "+size);
	        Entry<K> e = header;
	        if (index < (size >> 1)) {
	            for (int i = 0; i <= index; i++)
	                e = e.next;
	        } else {
	            for (int i = size; i > index; i--)
	                e = e.previous;
	        }
	        return e;
	    }
	  
	static class Entry<K>{
		K info;
		Entry<K> previous;
		Entry<K> next;
		
		Entry(K info,Entry previous,Entry next){
			this.info = info;
			this.previous = previous;
			this.next = next;
		}

	}
}
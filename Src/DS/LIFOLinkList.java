package DS;

public class LIFOLinkList {
	public static void main(String[] args) {
		LinkList<String> link = new LinkList<String>();
		link.addList("Hi");
		link.addList("Hello");
		link.addList("How are you");
		link.addList("I am Fine");
		
		link.display();
		
		LinkList<Integer> ll = new LinkList<Integer>();
		ll.addList(10);
		ll.addList(120);
		ll.addList(150);
		ll.display();
	}
}




class LinkList<K>{
	Entry<String> root;
	
	public void addList(K info){
		Entry<String> temp = root;
		root = new Entry(info, temp);
	}
	
	public void display(){
		while(root!=null){
			System.out.println("Value" + String.valueOf(root.info));
			root = root.next;
		}
	}
	 static class Entry<K>{
			K info;
			Entry next; 
			
			Entry(K info,Entry next){
				this.info = info;
				this.next = next;
			}
	 }
	 
	 
}
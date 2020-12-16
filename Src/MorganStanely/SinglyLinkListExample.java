package MorganStanely;

//Problem1
//Input 10 ->20->30->40->50
//Output 50->10->20->30->40


//Problem2
//Output 50->40->30->20->10

public class SinglyLinkListExample {
	public static void main(String[] args) {
		SinglyLinkList ll = new SinglyLinkList();
		ll.addElement(10);
		ll.addElement(20);
		ll.addElement(30);
		ll.addElement(40);
		ll.addElement(50);
		
		System.out.println("Actual LL");
		ll.traverseSequencely();
		ll.expectedOutput();
		System.out.println("\nOutput");
		ll.traverseSequencely();
	}
}


class SinglyLinkList{
	private Node root;
	private Node last;
	
	class Node{
		int info;
		Node next;
		
		Node(int info){
			this.info = info;
			this.next = null;
		}
	}
	
	
	public void addElement(int a) {
		Node n = new Node(a);
		if(root==null) {
			root = n;
			last = n;
		}else {
			last.next = n;
			last = n;
		}
	}
	
	public void traverseSequencely() {
		Node temp = root;
		while(temp!=null) {
			System.out.print(temp.info+" -> ");
			temp = temp.next;
		}
	}
	
	public void expectedOutput() {
		Node temp = root;
		Node prev = root;
		while(temp.next!=null) {
			prev = temp;
			temp = temp.next;
		}
		temp.next = root;
		root = temp;
		prev.next = null;
	}
	
	public void reverseOutput() {
		Node temp = root;
		Node prev=null;
		while(temp.next!=null) {
			prev = temp;
			temp = temp.next;
		}
	}
	
	public void swap(Node prev,Node current) {
		Node temp = current.next;
		current.next = prev;
		prev.next = temp;		
	}
}


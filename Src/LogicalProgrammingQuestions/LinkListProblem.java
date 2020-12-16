package LogicalProgrammingQuestions;

public class LinkListProblem {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.createRequiredList();
		ll.traverseRec();
	}
}




class LinkedList<String>{
	
	Node<String> header = new Node("header");
	
	public void createRequiredList() {
		Node<String> A = new Node("A");
		Node<String> B = new Node("B");
		Node<String> C = new Node("C");
		Node<String> D = new Node("D");
		Node<String> E = new Node("E");
		Node<String> F = new Node("F");
		Node<String> G = new Node("G");
		Node<String> H = new Node("H");
		Node<String> I = new Node("I");
		Node<String> J = new Node("J");
		
		header.next = A;
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		
		A.child = F;
		F.next = G;
		D.child = H;
		H.next = I;
		G.child = J;
	}
	
	
	public void traverse() {
		Node<String> temp = header;
		if(temp.next==null) {
			System.out.println("No Item in the List");
		}else {
			while(temp.next!=null) {
				temp = temp.next;
				System.out.println(temp.value);
				
			}
		}
	}
	
	
	public void traverseRec() {
		traverseLL(header);
	}
	
	/*public void traverseLL(Node n,Node header,Node root) {
		
		if(n==null) {
			header = header.next;
			traverseLL(header.child,header,root);
		}else {
			System.out.println(n.value);
			traverseLL(n.next,header,root);
		}
		
	}*/
	
	
	public void traverseLL(Node n) {
		if(n==null) return;
		System.out.println(n.value);
		traverseLL(n.next);
		traverseLL(n.child);
	}
	
	
	static class Node<String>{
		Node next;
		Node child;
		String value;
		
		Node(Node next,Node child,String value){
			this.next = next;
			this.child = child;
			this.value = value;
		}
		
		Node(String value){
			this.value = value;
		}
		
	}
	
	
	
}
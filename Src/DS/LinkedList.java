package DS;

public class LinkedList {
	public static void main(String[] args) {
		
		Node n = new Node("A",null);
		Node n1 = new Node("B",n);
		Node n2 = new Node("C", n1);
		while(n2!=null){
			System.out.print(n2.info+"-->");
			n2 =n2.next;
		}
		System.out.print("null");
	}
}


class Node{
	String info;
	Node next;
	Node(String info,Node next){
		this.info = info;
		this.next = next;
	}
}

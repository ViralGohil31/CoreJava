package DS;

public class BSTExample {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.add(25);
		bst.add(15);
		bst.add(50);
		bst.add(10);
		bst.add(22);
		bst.add(35);
		bst.add(70);
		bst.add(4);
		bst.add(12);
		bst.add(18);
		bst.add(24);
		bst.add(31);
		bst.add(44);
		bst.add(66);
		bst.add(90);
		
		bst.printInOrder();
		bst.printPreOrder();
		bst.printpostOrder();
		
	}
}



class BST<Integer>{
	
	private Entry<Integer> root = null;
	private int size = 0;
	
	public void add(int e){
		Entry<Integer> t = root;
		if(t==null){
			root = new Entry<Integer>(e, null);
			size++;
			return ;
		}
		else{
			Entry<Integer> parent = null;
			do{
				parent = t;
				if(t.info>e){
					t= t.left;
				}else{
					t = t.right;
				}
			}while(t!=null);
			System.out.println("Adding "+e+" Parent is "+parent.info);
			if(parent.info>e){
				Entry<Integer> newEntry = new Entry<Integer>(e,parent);
				parent.left = newEntry;
				size++;
			}else{
				Entry<Integer> newEntry = new Entry<Integer>(e,parent);
				parent.right = newEntry;
				size++;
			}
		}
	}
	
	public void printInOrder(){
		System.out.println("\n Inorder Traversal ");
		this.InorderTraversal(root);
	}
	
	public void printPreOrder(){
			System.out.println("\n Pre Order Traversal ");
			this.preOrderTraversal(root);
	}
	
	public void printpostOrder(){
		System.out.println(" \n Post Order Traversal ");
		this.postOrderTraversal(root);
	}
	
	private void InorderTraversal(Entry entry){
		if(entry==null) return;
		
		InorderTraversal(entry.left);
		System.out.print(entry.info+ ", ");
		InorderTraversal(entry.right);
	}
	
	
	private void preOrderTraversal(Entry entry){
		if(entry==null) return;
		
		System.out.print(entry.info+ ", ");
		InorderTraversal(entry.left);
		InorderTraversal(entry.right);
	}
	
	private void postOrderTraversal(Entry entry){
		if(entry==null) return;
		
		InorderTraversal(entry.left);
		InorderTraversal(entry.right);
		System.out.print(entry.info+ ", ");
	}
	
	static class Entry<Integer>{
		int info;
		Entry<Integer> left = null;
		Entry<Integer> right = null;
		Entry <Integer> parent;
		
		Entry(int info,Entry<Integer> parent){
			this.info = info;
			this.parent = parent;
		}
		
	}
}
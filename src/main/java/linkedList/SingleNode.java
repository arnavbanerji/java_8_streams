package linkedList;

//custom class of node with single pointer which is pointing to next node.
public class SingleNode {
	private int val;
	private SingleNode next;
	
	public SingleNode(int data) {
		this.val = data;
		this.next = null;
	}
	
	public SingleNode getNext() {
		return this.next;
	}
	
	public void setNext(SingleNode next) {
		this.next = next;
	}
	
	public int getVal() {
		return this.val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
}
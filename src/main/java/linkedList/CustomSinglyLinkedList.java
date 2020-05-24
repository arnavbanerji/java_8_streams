package linkedList;

//custom class of singly linked list (single pointer linked list pointing to next node)
public class CustomSinglyLinkedList {
	SingleNode head;
	//no constructor needed as it is implicit (without class argument)
	

	public void insert(int addedData) {
		SingleNode newNode = new SingleNode(addedData);
		newNode.setNext(null);
		if(this.head == null) {
			this.head = newNode;
		} else {
			SingleNode currentNode = this.head;
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
		}	
	}
	
	public void printList() {
		SingleNode currentNode = this.head;
		while(currentNode != null) {
			System.out.print(currentNode.getVal()+" ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
}
package linkedList;

public class MainLinkedList {
	public static void main(String[] args) {
		CustomSinglyLinkedList ll = new CustomSinglyLinkedList();
		ll.insert(10);
		ll.insert(12);
		ll.printList();
		ll.insert(13);
		ll.insert(14);
		ll.printList();
	}
}
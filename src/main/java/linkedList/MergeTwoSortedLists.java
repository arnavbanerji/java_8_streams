package linkedList;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		CustomSinglyLinkedList listNode1 = new CustomSinglyLinkedList();
		listNode1.insert(1);
		listNode1.insert(3);
		listNode1.insert(5);
		
		CustomSinglyLinkedList listNode2 = new CustomSinglyLinkedList();
		listNode2.insert(2);
		listNode2.insert(4);
		listNode2.insert(7);
		listNode2.insert(9);
		listNode2.insert(10);
		listNode2.insert(14);
		
		listNode1.printList();
		listNode2.printList();
		
		CustomSinglyLinkedList mergedListNode = mergeTwoSortedList(listNode1, listNode2);
		System.out.println("merging of two sorted lists will be:");
		mergedListNode.printList();
	}
	
	public static CustomSinglyLinkedList mergeTwoSortedList(CustomSinglyLinkedList listNode1, CustomSinglyLinkedList listNode2) {
		CustomSinglyLinkedList mergedNode = new CustomSinglyLinkedList();
		mergedNode.insert(-1);
		while(listNode1.head != null && listNode2.head != null) {
			System.out.println("there: "+listNode1.head.getVal());
			System.out.println("mergedNode head: "+mergedNode.head);
			if(listNode1.head.getVal() >= listNode2.head.getVal()) {
				mergedNode.head.setNext(listNode2.head.getNext());
				listNode2.head = listNode2.head.getNext();
				mergedNode.head = mergedNode.head.getNext();
				mergedNode.head.setNext(listNode1.head.getNext());
				listNode1.head = listNode1.head.getNext();
				mergedNode.head = mergedNode.head.getNext();
			} else {
				mergedNode.head.setNext(listNode1.head.getNext());
				listNode1.head = listNode1.head.getNext();
				mergedNode.head = mergedNode.head.getNext();
				mergedNode.head.setNext(listNode2.head.getNext());
				listNode2.head = listNode2.head.getNext();
				mergedNode.head = mergedNode.head.getNext();
			}
			
			
			//mergedNode.head = mergedNode.head.getNext();
		}
		System.out.println("merged Node after while loop");
		mergedNode.printList();
		if(listNode1.head != null) {
			mergedNode.head.setNext(listNode1.head);
		} else if(listNode2.head != null) {
			System.out.println("here: "+listNode2.head.getVal());
			mergedNode.head.setNext(listNode2.head);
		}
		//mergedNode.head.setNext(null);
		return mergedNode;
	}
}
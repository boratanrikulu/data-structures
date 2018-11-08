/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class DoubleLinkedListTest {

	public static void main(String[] args) {
		LabDoubleLinkedList<Integer> doubleLinkedList = new LabDoubleLinkedList<>();

		/*
		doubleLinkedList.insertAt(0, 1);
		doubleLinkedList.insertAt(0, 5);
		doubleLinkedList.insertAt(1, 4);
		doubleLinkedList.print();
		doubleLinkedList.insertAt(3, 7);
		doubleLinkedList.insertAt(3, 8);
		doubleLinkedList.print();
		*/
		
		doubleLinkedList.addFirst(6);
		doubleLinkedList.addFirst(5);
		doubleLinkedList.addFirst(4);
		doubleLinkedList.addFirst(3);
		doubleLinkedList.addFirst(2);
		doubleLinkedList.addFirst(1);
		
		doubleLinkedList.removeAt(0);
		doubleLinkedList.removeAt(4);
		doubleLinkedList.removeAt(2);
		doubleLinkedList.print();
		doubleLinkedList.removeAt(0);
		doubleLinkedList.removeAt(0);
		doubleLinkedList.removeAt(0);
		doubleLinkedList.print();
	}
}
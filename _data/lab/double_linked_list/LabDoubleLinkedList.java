/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class LabDoubleLinkedList<T> extends DoubleLinkedList<T> {

	/**
	 * Çift bağlı listenin istenilen konumuna eleman ekler
	 *
	 * @param index konum
	 * @param value eklenecek eleman
	 */
	@Override
	public void insertAt(int index, T value) {
		if (index == 0) {
			addFirst(value);
			return;
		}
		else if (index == size()) {
			addLast(value);
			return;
		}
		else if (index >= size ()  || index < 0) {
			throw new IndexOutOfBoundsException("Listede olmayan bir index için işlem yapılamaz!");
		}

		Node<T> current = getHead();

		int counter = 0;
		while (counter < index) {
			current = current.next;
			counter++;
		}

		Node<T> newNode = new Node(value, current, current.previous);

		current.previous.next = newNode;
		current.previous = newNode;
		setSize(size() + 1);
	}

	/**
	 * Verilen konumdaki elemanı siler
	 *
	 * @param index silinecek elemanın konumu
	 * @return silinen değer
	 */
	@Override
	public T removeAt(int index) {
		if (index == 0) {
			return removeFirst();
		}
		else if (index == size()) {
			return removeLast();
		}
		else if (index >= size ()  || index < 0) {
			throw new IndexOutOfBoundsException("Listede olmayan bir index için işlem yapılamaz!");
		}

		Node<T> current = getHead();

		int counter = 0;
		while (counter < index) {
			current = current.next;
			counter++;
		}

		if (! current.previous.equals(null)) {
			current.previous.next = current.next;
		}
		
		current.next = null;
		
		setSize(size() - 1);
		return current.value;
	}
}

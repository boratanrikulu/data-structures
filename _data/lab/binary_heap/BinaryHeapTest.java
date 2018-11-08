/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class BinaryHeapTest {

	public static void main(String[] args) {
		
		// [35, 7, 2, 80, 26, 8, 76, 21, 98, 91, 52, 49]
		
		BinaryHeap<Integer> heap = new BinaryHeap<>(15);
		
		heap.ekle(35);
		heap.ekle(7);
		heap.ekle(2);
		heap.ekle(26);
		heap.ekle(8);
		heap.ekle(76);
		heap.ekle(21);
		heap.ekle(98);
		heap.ekle(91);
		heap.ekle(52);
		heap.ekle(49);

		System.out.println((int) heap.dizi[1]);
	}
}
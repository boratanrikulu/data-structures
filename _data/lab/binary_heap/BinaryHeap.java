/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

/**
 * Minimum heap sınıfı
 *
 * @param <T> Generic sınıf
 */
public class BinaryHeap<T extends Comparable<T>> {

	public T[] dizi; // Yığını tutacak dizi(değiştirmeyin)
	public int es; // Eleman sayısı(değiştirmeyin)

	public BinaryHeap() { dizi = (T[]) new Comparable[100]; } // değiştirmeyin, kullanın
	
	public BinaryHeap(int boyut) { dizi = (T[]) new Comparable[boyut]; } // değiştirmeyin, kullanın
	public int ebeveyn(int konum) { return konum / 2; } // değiştirmeyin, kullanın
	public int solCocuk(int konum) { return 2 * konum; } // değiştirmeyin, kullanın
	public int sagCocuk(int konum) { return 2 * konum + 1; } // değiştirmeyin, kullanın
	public int elemanSayisi() { return es; } // değiştirmeyin, kullanın

	public void ekle(T eleman) {
		es++;
		dizi[es] = eleman;
			
		heapifyUp();
	}

	public void heapifyUp() {
		int counter = es;
		
		while (ebeveyn(counter) > 0 && dizi[counter].compareTo(dizi[ebeveyn(counter)]) <= 0) {
			T temp = dizi[ebeveyn(counter)];
			dizi[ebeveyn(counter)] = dizi[counter];
			dizi[counter] = temp;
		
			counter = ebeveyn(counter);
		}
	}
	
	public T sil() {
		T deleted = dizi[1];
		dizi[1] = dizi[es];
		dizi[es--] = null;
		
		heapifyDown();
		
		return deleted;
	}
	
	public void heapifyDown() {
		int counter = 1;
		
		while (solCocuk(counter) <= es) {
			int dahaKucukOlan = solCocuk(counter);
		
			if (sagCocuk(counter) <= es && dizi[sagCocuk(counter)].compareTo(dizi[solCocuk(counter)]) <= 0 ) {
				dahaKucukOlan = sagCocuk(counter);
			}
			
			if (dizi[counter].compareTo(dizi[dahaKucukOlan]) >= 0) {
				T temp = dizi[dahaKucukOlan];
				dizi[dahaKucukOlan] = dizi[counter];
				dizi[counter] = temp;
			} else {
				break;
			}
			
			counter = dahaKucukOlan;
		}
	}
}

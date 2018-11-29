/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class QuadraticProbeHashing<T> {

	public HashEntry<T>[] dizi;
	public int elemanSayisi;

	public QuadraticProbeHashing() {
		dizi = new HashEntry[23];
	}

	public QuadraticProbeHashing(int boyut) {
		dizi = new HashEntry[boyut];
	}

	public int hash(T deger) {
		return deger.hashCode() % dizi.length;
	}

	public void ekle(T eleman) {
		int counter = 0;
		int hashValue = hash(eleman);
		
		for(;;) {
			if (dizi[(hashValue + counter*counter) % dizi.length] == null || ! dizi[(hashValue + counter*counter) % dizi.length].isActive) {
				dizi[(hashValue + counter*counter) % dizi.length] = new HashEntry(eleman);
				break;
			} 
			
			counter++;
		}
	}

	public boolean sil(T eleman) {
		int counter = 0;
		int hashValue = hash(eleman);
		
		for(;;) {
			if(dizi[(hashValue + counter*counter) % dizi.length].value.equals(eleman) && dizi[(hashValue + counter*counter) % dizi.length].isActive) {
				dizi[(hashValue + counter*counter) % dizi.length].isActive = false;
				return true;
			}
			counter++;
		}
	}
}

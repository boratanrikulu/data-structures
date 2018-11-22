/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

import java.util.LinkedList;

public class SeperatedChainHash {

	public LinkedList<Integer>[] dizi;

	public SeperatedChainHash() {
		//içerği değiştirmeyin
		dizi = new LinkedList[23];
	}

	public SeperatedChainHash(int boyut) {
		//içerği değiştirmeyin
		dizi = new LinkedList[boyut];
	}

	public int hash(int deger) {
		//içerği değiştirmeyin
		return deger % dizi.length;
	}

	public void ekle(int deger) {
		int konum = hash(deger);
		
		if (dizi[konum] == null) {
			LinkedList<Integer> toAdd = new LinkedList<>();
			toAdd.add(deger);
			dizi[konum] = toAdd;
		} else {
			dizi[konum].add(deger);
		}
	}

	public boolean sil(int deger) {
		int konum = hash(deger);
		
		if (dizi[konum] == null) {
			return false;
		} else {
			int konumLinkedList = dizi[konum].indexOf(deger);
			dizi[konum].remove(konumLinkedList);
			return true;
		}
	}
	
	public int hashYeniden(int deger, int length) {
		//içerği değiştirmeyin
		return deger % 47;
	}
	
	public int asalBul(int length) {
		int ikiKati = length * 2;
				
		while(true) {
			ikiKati++;
			boolean flag = true;
			for (int counter = 2; counter < ikiKati / 2; counter++) {
				if (ikiKati % counter == 0) {
					flag = false;
				} else {
					flag = true;
				}
			}
			
			if (flag == true)
				return ikiKati;
		}
	}

	public void yenidenOzetle() {
		SeperatedChainHash yenidenOzetle = new SeperatedChainHash(asalBul(dizi.length));
		
		for (LinkedList<Integer> linkedList : dizi) {
			for (int deger : linkedList) {
				yenidenOzetle.ekle(deger);
			}
		}
		
		dizi = yenidenOzetle.dizi;
	}
}

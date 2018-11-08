/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class ArabaTest {

	public static void main(String[] args) {
		Araba arabaVolvo = new Araba("volvo", 2011, 1500, "35 BT 35");
		Araba arabaMercedes = new Araba("mercedes", 2016, 2000, "35 TT 35");

		System.out.println("En yeni araba:\n"+EnBuyuk.enBuyuk(arabaVolvo, arabaMercedes).toString());
	}
}

/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class Araba implements Comparable<Araba>  {

	private int modelYili;
	private String plaka;
	private String marka;
	private double motorHacmi;

	public Araba(String marka, int modelYili, double motorHacmi, String plaka) {
		this.marka = marka;
		this.modelYili = modelYili;
		this.motorHacmi = motorHacmi;
		this.plaka = plaka;
	}

	@Override
	public int compareTo(Araba object) {
		return modelYili - object.modelYili;
	}

	@Override
	public String toString() {
		return String.format("%s [%d - %.2f] - [%s]", marka, modelYili, motorHacmi, plaka);
	}
}

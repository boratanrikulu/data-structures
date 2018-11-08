/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class EnBuyuk {

	public static <T extends Comparable<T>> T enBuyuk(T o1, T o2) {
		T max = o1;
		if (o2.compareTo(max) > 0) {
			max = o2;
		}
		return max;
	}
}

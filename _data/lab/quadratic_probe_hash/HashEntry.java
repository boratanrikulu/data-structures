/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class HashEntry<T> {

	T value;
	boolean isActive;

	public HashEntry(T value, boolean isActive) {
		this.value = value;
		this.isActive = isActive;
	}

	public HashEntry(T value) {
		this(value, true);
	}
}

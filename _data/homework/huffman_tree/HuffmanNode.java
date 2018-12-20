/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

/**
 * Huffman düğüm sınıfı. Bu sınıfın içeriğini değiştirmemeniz gerekmektedir. Değişiklik yaparsanız test ortamında kodunuz beklendiği gibi çalışmayacaktır.
 */
public class HuffmanNode implements Comparable {

	public Character value;
	public int frequency;
	public HuffmanNode left;
	public HuffmanNode right;

	public HuffmanNode(Character value, int frequency, HuffmanNode left, HuffmanNode right) {
		this.value = value;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Object o) {
		HuffmanNode oo = (HuffmanNode) o;
		return this.frequency - oo.frequency;
	}
}

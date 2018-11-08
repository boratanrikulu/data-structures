/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class Rotator {

	public static <T> BTNode<T> solaDondur(BTNode<T> k1) {
		if (k1 == null || k1.right == null) 
			return null;

		if (k1.right.left == null)
			k1.right.left = new BTNode(k1.value, k1.left, null);
		else
			k1.right.left = new BTNode(k1.value, k1.left, k1.right.left);

		k1 = k1.right;
		return k1;
	}

	public static <T> BTNode<T> sagaDondur(BTNode<T> k2) {
		if (k2 == null || k2.left == null)
			return null;

		if (k2.left.right == null)
			k2.left.right = new BTNode(k2.value, null, k2.right);
		else
			k2.left.right = new BTNode(k2.value, k2.left.right, k2.right);

		k2 = k2.left;
		return k2;
	}

	public static <T> BTNode<T> solaSagaDondur(BTNode<T> k3) {
		k3.left = solaDondur(k3.left);
		k3 = sagaDondur(k3);

		return k3;
	}

	public static <T> BTNode<T> sagaSolaDondur(BTNode<T> k4) {
		k4.right = sagaDondur(k4.right);
		k4 = solaDondur(k4);

		return k4;
	}
}

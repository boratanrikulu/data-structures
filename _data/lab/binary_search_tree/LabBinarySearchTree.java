/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	public LabBinarySearchTree() {
		//Bu metodu değiştirmeyin
	}

	public LabBinarySearchTree(BTNode<T> root) {
		//Bu metodu değiştirmeyin
		super(root);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		if (getRoot() == null)
			return new LabBinarySearchTree<T>();
		
		return new LabBinarySearchTree<>(postOrder(getRoot()));
	}

	public static <T> BTNode postOrder(BTNode<T> node) {		
		if (node.left != null)
			postOrder(node.left);
		if (node.right != null)
			postOrder(node.right);
		
		return new BTNode<T>(node.value, node.left, node.right);
	}

	@Override
	public BTNode<T> successor(T value) {		
		BTNode<T> current = find(getRoot(), value);
		
		if (current == null)
			return null;
		else if (current.right != null)
			current = current.right;
		else
			return null;
		
		while( current.left != null ) {
			current = current.left;
		}

		return current;
	}

	@Override
	public BTNode<T> predecessor(T value) {
		BTNode<T> current = find(getRoot(), value);
		
		if (current == null)
			return null;
		else if (current.left != null)
			current = current.left;
		else
			return null;
		
		while( current.right != null ) {
			current = current.right;
		}

		return current;
	}

	@Override
	public BTNode<T> findParent(BTNode<T> node) {
		BTNode<T> current = getRoot();
		BTNode<T> currentTemp= current;
		
		if (node == getRoot()) {
			return null;
		}
		
		while(current != null) {
			
			if (node.value.compareTo(current.value) == 0)
				return currentTemp;
			
			else if (node.value.compareTo(current.value) > 0) {
				currentTemp = current;
				current = current.right;
			}
				
			else if (node.value.compareTo(current.value) < 0){
				currentTemp = current;
				current = current.left;
			}
		}
		
		return null;
	}
}

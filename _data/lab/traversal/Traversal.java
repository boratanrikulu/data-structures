/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class Traversal {
	
	public static String result = "";

	public static <T> String inOrder(BTNode<T> node) {
		result = "";
		
		orderRecursive(node, "in");
		
		return result;
	}

	public static <T> String preOrder(BTNode<T> node) {
		result = "";
		
		orderRecursive(node, "pre");
		
		return result;
	}

	public static <T> String postOrder(BTNode<T> node) {
		result = "";
		
		orderRecursive(node, "post");
		
		return result;
	}
	
	public static <T> String orderRecursive(BTNode<T> node, String type) {
		if(type.equals("pre"))
			result += node.value + " ";	
		
		if (node.left != null)
			orderRecursive(node.left, type);
		
		if(type.equals("in"))
			result += node.value + " ";	
		
		if (node.right != null)
			orderRecursive(node.right, type);

		if(type.equals("post"))
			result += node.value + " ";	
		
		return result;
	}
}

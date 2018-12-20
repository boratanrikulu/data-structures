/* 17253509 - Bedrettin Bora Tanrikulu */

/** 
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

import java.util.Stack;

public class Homework {
	
	public static String result;

	/**
	 * Postfix biçiminde verilen metni ExpressionTree sınıfına dönüştürür.
	 */
	public static ExpressionTree postfixToExpressionTree(String girdi) throws Exception {
		
		String[] elements = girdi.split(" ");
		Stack<BTNode> stack = new Stack<>();
		
		for (String element : elements) {
			if (Character.isDigit(element.charAt(0))) {
				stack.push(new BTNode(element, null, null));
			} else if (isOperator(element)) {
				BTNode right = stack.pop();
				BTNode left = stack.pop();
				
				stack.push(new BTNode(element, left, right));
			} else {
				throw new Exception ("The element is not a number or an operator.");
			}
		}

		return new ExpressionTree(stack.pop());
	}
	
	/*
	* Yollanan ifadenin operator olup olmadigini kontrol eder.
	*/
	public static boolean isOperator(String element) {

		switch (element) {
			case "+":
			case "-":
			case "*":
			case "/":
			case "^":
				return true;
			default:
				return false;
		}
	}

	/**
	 * Parametre olarak verilen ifade ağacını değerlendirir(sonucunu hesaplar).
	 */
	public static int evaluateExpressionTree(ExpressionTree agac) {
		
		BTNode root = agac.getRoot();

		result = "";
		postOrder(root);

		return postfixDegerlendir(result);
	}
	
	/**
	 * Root'u yollanan agacı post order olarak dolasir ve bir string'e kayit eder.
	 */
	public static void postOrder(BTNode root) {
		
		if (root.left != null)
			postOrder(root.left);
		
		if (root.right != null)
			postOrder(root.right);
		
		result += root.value + " ";	
	}
	
	/**
	 * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
	 */
	public static int postfixDegerlendir(String girdi) {
		
		String[] elements = girdi.split(" ");
		Stack<Integer> operands = new Stack<>();
		int result = 0;

		for (String element : elements) {
			if (Character.isDigit(element.charAt(0))) {
				operands.push(Integer.parseInt(element));
			}
			else {
				int operand_1 = operands.pop();
				int operand_2 = operands.pop();

				switch (element) {
					case "+":
						result = operand_2 + operand_1;
						break;
					case "-":
						result = operand_2 - operand_1;
						break;
					case "*":
						result = operand_2 * operand_1;
						break;
					case "/":
					    result = operand_2 / operand_1;
						break;
					case "^":
					    result = operand_2 ^ operand_1;
					    break;
					default :
						break;
				}
				operands.push(result);
			}
		}
	
		return operands.pop();
	}
}

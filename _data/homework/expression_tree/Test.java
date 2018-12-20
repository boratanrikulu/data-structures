/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

	public static void main (String[] args) {
		
		try {
			System.out.println(Homework.evaluateExpressionTree(Homework.postfixToExpressionTree("12 15 23 2 14 / / ")));
		} catch (Exception ex) {
			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
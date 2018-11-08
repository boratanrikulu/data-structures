/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

public class IslemlerTest {

	public static void main(String[] args) {
		
		Islemler islemler = new Islemler();
		
		String postfix = islemler.infixToPostfix("3 * 2 + 4 - 7 / 5");
		// 3 2 * 4 + 7 5 / - olmalı
		
		System.out.println(postfix);
		
		int result = islemler.postfixDegerlendir(postfix);
		
		System.out.println(result);
	}
}
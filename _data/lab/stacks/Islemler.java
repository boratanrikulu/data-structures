/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

import java.util.*;

/**
 * Islemler sınıfı içindeki 4 metodun yazılması istenmektedir
 */
public class Islemler {
	/**
	 * Yığıtın elemnlarının sırasını tersine çevirir
	 * @param s Tersine çevrilecek yığıt
	 * @return Tersine çevirlmiş yığıtı döndürür
	 */
	public static <T> Stack<T> tersCevir(Stack<T> s){
		Stack<T> copy = (Stack<T>) s.clone();
		Stack<T> reverse = new Stack<>();
		
		while(!copy.isEmpty()) {
			reverse.push(copy.pop());
		}

		return reverse;
	}

	/**
	 * İki yığıtın eşit olup olmadığını kontrol eder
	 * @param s1 Birinci yığıt
	 * @param s2 İkinci yığıt
	 * @return İki yığıtın eşit olma durumunu döndürür
	 */
	public static <T> boolean esit(Stack<T> s1, Stack<T> s2)
	{		
		Stack<T> s1_copy = (Stack<T>) s1.clone();
		Stack<T> s2_copy = (Stack<T>) s2.clone();
		
		if (s1_copy.size() != s2_copy.size())
			return false;
		
		while(!s1_copy.isEmpty()) {
			if (s1_copy.pop() != s2_copy.pop()) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
	 * @param girdi Girdi ifadesi
	 * @return İfadenin sonucu
	 */
	public static int postfixDegerlendir(String girdi) {
		String[] tokens = splitToTokens(girdi);
		Stack<Integer> operands = new Stack<>();
		int result = 0;
		
		for (String token : tokens) {
			if (Character.isDigit(token.charAt(0))) {
				operands.push(Integer.parseInt(token));
			}
			else {
				int operand_1 = operands.pop();
				int operand_2 = operands.pop();
				
				if (token.equals("+")) 
					result = operand_2 + operand_1;

				else if (token.equals("-")) 
					result = operand_2 - operand_1;

				else if (token.equals("*")) 
					result = operand_2 * operand_1;

				else if (token.equals("/")) 
					result = operand_2 / operand_1;
				
				operands.push(result);
			}
		}
		
		return operands.pop();
	}

	/**
	 * Infix ifadeyi postfix'e dönüştürür.
	 * @param girdi Infix girdi metni
	 * @return Dönüştürülmüş postfix ifade
	 */
	public static String infixToPostfix(String girdi){
		Stack<String> opstack = new Stack<>();
		List<String> output = new ArrayList();
		
		
		String[] symbols = splitToTokens(girdi);
		for (String symbol : symbols) {
			if (Character.isDigit(symbol.charAt(0))) {
				output.add(symbol);
			}
			
			else if (symbol.equals("(")) {
				opstack.push(symbol);
			}
			
			else if (symbol.equals(")")) {
				while(true) {
					if (! opstack.peek().equals("("))
						output.add(opstack.pop());
					else
						break;
				}
			}
	
			else {
				int symbolPriority = getPriority(symbol);
				
				if (! opstack.isEmpty()) {
					int opstackPriority = getPriority(opstack.peek());
					
					while (opstackPriority > symbolPriority) {
						if (! opstack.isEmpty()) {						
							opstackPriority = getPriority(opstack.peek());
							output.add(opstack.pop());
						}
						else
							break;
					}
					
				}
				opstack.push(symbol);
			}
		}
		
		while (!opstack.isEmpty()) {
			output.add(opstack.pop());
		}
		
		String postfix = "" ;
		for (String token : output) {
			postfix += token + " ";
		}
		
		return postfix;
	}
	
	private static int getPriority(String symbol) {
		int priority = 0;
		
		if (symbol.equals("+") || symbol.equals("-"))
			priority = 0;
		else if (symbol.equals("*") || symbol.equals("/"))
			priority = 1;
		else
			priority = -1;
		
		return priority;
	}

	/**
	 * Infix ifadeyi sembollerine ayıran metod
	 * @param girdi Infix ifade
	 * @return Sembol dizisi
	 */
	private static String[] splitToTokens(String girdi)
	{
		StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
		List<String> tokenList=new ArrayList<>();
		while (t.hasMoreTokens()){
			String s=t.nextToken().trim();
			if(!s.equals(""))
				tokenList.add(s);
		}
		String [] tl=new String[tokenList.size()];
		tokenList.toArray(tl);
		return tl;
	}
}

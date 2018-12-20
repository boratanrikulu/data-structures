/* 17253509 - Bedrettin Bora Tanrikulu */

/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

import java.util.HashMap;

public class Homework {
	
	private static HashMap<Character, String> huffmanCode;
	
	/**
	 * verilen girdi metnini bir Huffman ağacı oluşturarak kodlar.
	 */
	public static String huffmanKodla(String girdi, HuffmanTree agac) {
		
		agac.addAll(setArray(getFrequencies(girdi))); // agacı oluşturur
		
		huffmanCode = new HashMap<Character, String>();
		getCode(agac.root, "");
		
		String result = "";
		for(String element : girdi.split("")) {
			result += huffmanCode.get(element.charAt(0));
		}
		
		return result;
	}
	
	/**
	 * yollanılan ağaç üzerindeki ifadelerin huffman code karşılığını tespit edip bir hashmap değişkeni olan huffmancode'a yazar.
	 */
	public static void getCode(HuffmanNode root, String code) {
		if(root == null)
			return;
		
		if(root.left != null)
			getCode(root.left, code + "0");
		
		if(root.right != null)
			getCode(root.right, code + "1");
		
		if(root.left == null && root.right == null)
			huffmanCode.put(root.value, code);
	}
	
	/**
	 * yollanılan String ifadesindeki ifadelerin kaç defa tekrar ettiğini tespit edip bir hashmap ifadesi olarak geri döner.
	 */
	public static HashMap<Character, Integer>  getFrequencies(String girdi) {
		HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();
		
		for(String element : girdi.split("")) {
			Integer frequency = frequencies.get(element.charAt(0));
			
			if(frequency == null) {
				frequencies.put(element.charAt(0), 1);
			} else {
				frequencies.put(element.charAt(0), frequency + 1);
			}
		}
		
		return frequencies;
	}
	
	/**
	 * hashmap ifadesini kullanarak huffmantree oluşturmada kullanılacak diziyi oluşturur.
	 */
	public static HuffmanNode[]  setArray(HashMap<Character, Integer> frequencies){
		HuffmanNode[] array = new HuffmanNode[frequencies.size()];
		
		int counter = 0;
		for (HashMap.Entry<Character, Integer> entry : frequencies.entrySet()) {
			Character value = entry.getKey();
			Integer frequency = entry.getValue();
			
			array[counter] = new HuffmanNode(value, frequency, null, null);
			counter++;
		}
		
		return array;
	}
}
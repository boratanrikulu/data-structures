## Binary Heap

<p align="center"> 
	<img src="https://upload.wikimedia.org/wikipedia/commons/6/69/Min-heap.png" width="500px">
</p>

Complete Binary  Tree yapısındadır.

Parent çocuklardan daha küçük olmalıdır.

En küçük değer daima en baştadır.

Ekleme ve silme soldan sağa ağacı dolduracak şekilde yapılır.

Ekleme ve silmeden sonra bozulan yapı **`heapify`** yapılarak düzeltilir.

**`heapifyUp`** -> eklemenden sonra (en sona eklenir)

**`heapifyDown`** -> çıkarmadan sonra (silme kökten yapılır)

Diziler ile temsil edilir. Parent **`n`**. eleman ise, sol çocuğu **`2n`**, sağ çocuğu **`2n+1`** olur.

Bir elemanın parent'i bulmak için **`index/2`** yapılır.

#### Binary Heap'te ekleme algoritması

```java
public void add(T value) {
	counter++;
	array[counter] = eleman;

	heapifyUp();
}
```

```java
public void heapifyUp() {
	int counter = this.counter;

	while(parent(counter) > 0 && dizi[counter] < dizi[parent(counter)]) {
		T temp = dizi[parent(counter)];
		dizi[parent(counter)] = dizi[counter];
		dizi[counter] = temp;

		counter = parent(counter);
	}
}
```

#### Binary Heap'te çıkarma algoritması

```java
public T remove() {
	T removed = array[counter];
	array[1] = array[counter];
	array[counter] = null;
	counter--;

	heapifyDown();

	return removed;
}
```

```java
public void heapifyDown() {
	int counter = 1;

	while(leftChild(counter) <= this.counter) {
		int less = array(leftChild(counter));

		if(rightChild(counter) <= this.counter && dizi[rightChild(counter)] < array[leftChild(counter)]) {
			less = rightChild(counter);
		}

		if(array[counter] > array[less]) {
			T temp = array[less];
			array[less] = array[counter];
			array[counter] = array[less];
		} else {
			break;
		}

		counter = theLess
	}
}
```

## Huffman Trees

<p align="center"> 
	<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Huffman_tree_2.svg/1280px-Huffman_tree_2.svg.png" width="500px">
</p>

Verileri sıkıştırmak amacıyla kullanılır. Kayıpsız bir veri sıkıştırma yöntemidir.

**`a`** : 010  
**`e`** : 000  
**`x`** : 1010  
..  
..  
..

şeklinde kodlanır.

#### Huffman Tree oluşturma algoritması

```java
public HuffmanNode create(HuffmanNode[] nodes) {
	PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

	for(HuffmanNode node : nodes) {
		priorityQueue.add(node);
	}

	while(priorityQueue.size() > 1) {
		HuffmanNode node_1 = priorityQueue.poll();
		HuffmanNode node_2 = priorityQueue.poll();

		/* Character value, int frequency, HuffmanNode left, HuffmanNode right */
		priorityQueue.add(new HuffmanNode(null, node_1.frequency + node_2.frequency, node_1, node_2));
	}

	/* returns root node */
	return priorityQueue.poll();
}
```

#### Verilen ifadeyi HuffmanTree'ye eklemek

```java
public String huffmanCoder(String input) {
	HuffmanTree huffmanTree = new HuffmanTree();

	/* finds frequencies */
	HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();

	for(String element : input.split("")) {
		Integer frequency = frequencies.get(element.charAt(0));

		if(frequency == null) {
			frequencies.put(element.charAt(0), 1);
		} else {
			frequencies.put(element.charAt(0), frequency + 1);
		}
	}

	/* creates HuffmanNode array by using frequencies */
	HuffmanNode[] huffmanNodeArray = new HuffmanNode[frequencies.size()];

	int counter = 0;
	for(HashMap.Entry<Character, Integer> entry : frequencies.entrySet()) {
		Character value = entry.getKey();
		Integer frequency = entry.getValue();

		huffmanNodeArray[counter] = new HuffmanNode(value, frequency, null, null);

		counter++;
	}

	/* creates HuffmanTree by using HuffmanNode array */
	huffmanTree.create(huffmanNodeArray);
}
```

#### HuffmanTree'yi kullanarak harflerin kod karşılığı görmek

```java
public void createCodes(HuffmanNode root, String code, HashMap<Chatacter, String> hashMap) {
	if(root != null) {
		if(root.left != null) {
			createCodes(root.left, code + "0");
		}

		if(root.right != null) {
			createCodes(root.right, code + "1");
		}

		if(root.left == null && if root.right == null) {
			hashMap.put(root.value, code);
		} 
	} else {
		return null;
	}
}
```

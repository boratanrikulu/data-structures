## Linked List (bağlı liste)

<p align="center"> 
	<img src="_img/week_3_0.jpg" width="300px">
</p>

Ardışık olarak Node içeren veri tipidir. Bir başlangıç (head) Node'u vardır.

```java
public class Node<T> {
	T value;
	Node<T> next;

	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}
}
```

**`getHead()`** -> listenin başını verir  
**`addfirst()`** -> listenin başına ekler  
**`addLast()`** -> listenin sonuna ekler  
**`add()`** -> verilen konumdan sonra ekler (index)  
**`insertAfter()`** -> verilen node'dan sonra ekler (node)
**`print()`** -> listeyi yazdırır

gibi method'ları vardır.  

## Doubly Linked List (çift bağlı liste)

<p align="center"> 
	<img src="_img/week_3_1.jpg" width="500px">
</p>

İleri ve geri yönde gezilebilir. Node'un öncesi ve sonrası bilinir. Head, tail, size verileri bulunur.

```java
public class Node<T> {
	T value;
	Node<T> next;
	Node<T> previous;

	public Node(T value, Node<T> next, Node<T> previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
	}
}
```

**`getHead()`** -> listenin başını verir  
**`getTail()`** -> listenin sonunu verir  
**`addfirst()`** -> listenin başına ekler  
**`addLast()`** -> listenin sonuna ekler  
**`insertAt()`** -> listede belirtilen konuma node'u ekler (index)
**`print()`** -> listeyi yazdırır  
**`reversePrint()`** -> listeyi tersten yazdırır  

gibi method'ları vardır.

#### Doubly Linked List için InsertAt method'unun yazılması

```java
public void insertAt(int index, T value) {
	if(index == 0) {
		addfirst(value);
	} else if (index == size()) {
		addLast(value);
	} else {
		Node<T> current = getHead();

		int counter = 0;
		while(counter < index) {
			current = current.next;
			counter++;
		}

		Node<T> newNode = new Node<T>(value, current.previous, current);

		current.previous.next = newNode;
		current.previous = newNode;
		setSize(size() - 1);
	}
}
```

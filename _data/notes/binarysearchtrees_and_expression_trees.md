## Binary Search Trees (ikili arama ağaçları)

En fazla iki çocuk içeren Node'ların oluşturduğu kümeye, binary search tree denir.

**`leftChild < parent < rightChiled`** şeklindedir. 

<p align="center"> 
	<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Binary_search_tree.svg/1200px-Binary_search_tree.svg.png" width="500px">
</p>

**`Inorder dolaşma`** : 1 3 4 6 7 8 10 13 14  
**`Preorder dolaşma`** : 8 3 1 6 4 7 10 14 13  
**`Postoder dolaşma`** 1 4 7 6 3 13 14 10 8

#### Binary Search Tree'de arama işlemi

Arama işlemi için en iyi ihtimal ağacın dengeli olduğu durumdur. Dengeli bir ağaç için en kötü durum (worst case) log2(n+1)'dir.

Yani 7 elemanlı dengeli bir ağaç için en kötü durum 3 adımda gerçekleşir.

Tamamen bir tarafa yatık bir ağaç için en kötü durum n'dir.

```java
public <T> Node find(Node<T> root, T value) {
	if(root == null) {
		return;
	} else {
		if(value.equals(node.value)) {
			return root;
		} else if(value.compareTo(root.value)) {
			return find(root.right);
		} else {
			return find(root.left);
		}
	}
}
```

#### Binary Search Tree'de ekleme işlemi

```java
public Node<T> add(Node<T> root, T value) {
	if(root.value == value) {
		return;
	} else if(value.compareTo(node.value)) {
		if(node.right == nul) {
			node.right = new Node<T>(value, null, null);
		} else {
			add(node.right, value);
		}
	} else {
		if(node.left == nul) {
			node.left = new Node<T>(value, null, null);
		} else {
			add(node.left, value);
		}
	}
}
```

#### Binary Search Tree'de silme işlemi

- **`Silinecek Node yaprak ise`**  
Direkt silinir
- **`Silinecek Node'un tek çocuğu var ise`**  
Çocuğu ile yer değiştirilir.
- **`Silinecek Node'un çift çocuğu var ise`**  
Successor ya da Predecessor'ı ile yer değiştirilir.

#### Successor bulma algoritması

```java
public Node<T> successor(T value) {
	Node<T> current = find(getRoot(), value);

	/* one time goes to right */
	if(current == null) {
		return null;
	} else if(current.right != null) {
		current = current.right
	} else {
		return null;
	}

	/* then always goes to left */
	while(current.left != null){
		current = current.left;
	}

	return current;
}
```

#### Parent bulma algoritması

```java
public Node<T> findParent(Node<T> node) {
	Node<T> parent = getRoot();

	while(parent != null && parent.left != null && parent.right != null) {
		if(node.value.compareTo(parent.value) > 0) {
			parent = parent.right;
		} else {
			parent = parent.left;
		}
	}

	return parent;
}
```

## Expression Trees (ifade ağaçları)

İşlemleri ifade etmek için kullanılır.

Örneğin **`( a + b ) * c + 7`** ifadesi şu şekilde bir ağaç ile gösterilir :

<p align="center"> 
	<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Exp-tree-ex-11.svg/1200px-Exp-tree-ex-11.svg.png" width="500px">
</p>

```java
public static ExpressionTree postfixToExpressionTree(String input) {
	Stack<Node> stack = new Stack<>();

	for (String element : input.split(" ")) {
		if (Character.isDigit(element.charAt(0))) {
			stack.push(new Node(element, null, null));
		} else { // then it must be a operator
			Node right = stack.pop();
			Node left = stack.pop();

			stack.push(new Node(element, left, right));
		}
	}

	return new ExpressionTree(stack.pop()) // that is the head
}
```


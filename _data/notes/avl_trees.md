## AVL Trees

<p align="center"> 
	<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/AVL-tree-wBalance_K.svg/1200px-AVL-tree-wBalance_K.svg.png" width="500px">
</p>

Dengeli bir ağaçtır.

Dengeleme ekleme ve silme sırasında yapılır. Node'lar için denge faktörü -1, 0, +1 olabilir. Farklı ise denge kaynmış demektir, dengelenmesi gerekir.

Denge faktörü hangi yöne yatık olduğunu gösterir.

**Not:** aşağıda root anlamı, dengesi bozulan node için söylenmiştir. Yani neyi çeviriyorsak onu root kabul ediyoruz, ayrı bir ağaçmış gibi düşenebiliriz.

##### Sol çocuğun soluna ekleme ile denge bozulmasının çözülmesi

8 ifadesinin denge faktörü -2 olacaktır. Bu sola yatık ifadeyi  çözmek için root'u sağa çevirmemiz yeterlidir.

`[..][..][8.]` .sağ. `[..][4.][..]`   
`[..][4.][..]` ........ `[2.][..][8.]`  
`[2.][..][..]` ........ `[..][..][..]`

##### Sağ çocuğun sağına ekleme ile denge bozulmasının çözülmesi

8 ifadesinin denge faktörü +2 olacaktır. Bu sağa yatık ifadeyi  çözmek için root'u sola çevirmemiz yeterlidir.

`[8.][..][..]` .sol. `[..][16][..]`   
`[..][16][..]` ....... `[8.][..][32]`  
`[..][..][32]` ....... `[..][..][..]`

##### Sol çocuğun sağına ekleme ile denge bozulmasının çözülmesi

8 ifadesinin denge faktörü -2 olacaktır. Bu sola yatık ifadeyi  çözmek için sol çocuğu sola, root'u sağa çevirmemiz yeterlidir.

`[..][8.][..]` ....... `[..][..][8.]` .sağ. `[..][6.][..]`   
`[4.][..][..]` .sol. `[..][6.][..]` ........ `[4.][..][8.]`  
`[..][6.][..]` ....... `[4.][..][..]` ........ `[..][..][..]` 

##### Sağ çocuğun soluna ekleme ile denge bozulmasının çözülmesi

8 ifadesinin denge faktörü +2 olacaktır. Bu sağa yatık ifadeyi  çözmek için sağ çocuğu sağa, root'u sola çevirmemiz yeterlidir.

`[8.][..][..]` ........ `[8.][..][..]` .sol. `[..][12][..]`   
`[..][16][..]` .sağ. `[..][12][..]` ....... `[8.][..][16]`  
`[12][..][..]` ........ `[..][..][16]` ....... `[..][..][..]` 


## Döndürme algoritmaları

##### Sağa döndürme

Aşağıdaki ağaçları sağa döndürmek için algoritma;

`[..][..][8.]` .sağ. `[..][4.][..]`   
`[..][4.][..]` ........ `[2.][..][8.]`  
`[2.][..][..]` ........ `[..][..][..]`

```java
public static <T> Node<T> rotateRight(Node<T> root) {
	Node<T> rootLeft = root.left;
	root.left = rootLeft.right;
	rootLeft.right = root;

	return rootLeft;
}
```

##### Sola döndürme

Aşağıdaki ağaçları sağa döndürmek için algoritma;

`[8.][..][..]` .sol. `[..][16][..]`   
`[..][16][..]` ....... `[8.][..][32]`  
`[..][..][32]` ....... `[..][..][..]`

```java
public static <T> Node<T> rotateRight(Node<T> root) {
	Node<T> rootRight = root.right;
	root.right = rootRight.left;
	rootRight.left = root;

	return rootRight;	
}
```

#### Sol-Sağ döndürme

Aşağıdaki ağaçları sağa döndürmek için algoritma;

`[..][8.][..]` ....... `[..][..][8.]` .sağ. `[..][6.][..]`   
`[4.][..][..]` .sol. `[..][6.][..]` ........ `[4.][..][8.]`  
`[..][6.][..]` ....... `[4.][..][..]` ........ `[..][..][..]` 

```java
public static <T> Node<T> rotateLeftRight(Node<T> root) {
	root.left = rotateLeft(root.left);
	
	return rootRight(root);
}
```

#### Sağ-Sol döndürme

Aşağıdaki ağaçları sağa döndürmek için algoritma;

`[8.][..][..]` ........ `[8.][..][..]` .sol. `[..][12][..]`   
`[..][16][..]` .sağ. `[..][12][..]` ....... `[8.][..][16]`  
`[12][..][..]` ........ `[..][..][16]` ....... `[..][..][..]` 

```java
public static <T> Node<T> rotateLeftRight(Node<T> root) {
	root.right = rotateRight(root.right);
	
	return rootLeft(root);
}
```

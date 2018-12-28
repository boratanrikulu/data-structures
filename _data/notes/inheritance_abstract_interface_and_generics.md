## Inheritance (kalıtım)

Bir class'ın tüm özelliklerini başka bir class'ta kullanmak istediğimizde inheritance'ı kullanırız.

```java
public class Dog extends Animal {
	public void woof() {
		System.out.println("woof woof!");
	}
}
```

## Abstract (soyutlama)

Eğer bir direkt olarak kulanılamasın, yalnızca türetilerek kullanılsın istiyorsak **`abstract`** olarak tanımlarız.

Eğer bir method kesinlikle override edilsin istiyorsak, method'u **`abstract`** olarak tanımlarız.

```java
public abstract class FlyingAnimal {
	public abstract void uc();
}
```

```java
public class Bird extends FlyingAnimal {
	@Override
	public void uc() {
		System.out.println("I flew!");
	}
}
```

## Interface (arayüz)

Sınıflarda kesinlikle tanımlanacak belli başlı method'lar varsa bunlar interface içersinde yazılır. Sınıflar bu interface'den implement edildiğinde, interface'de belirtilen tüm method'ların override edilmesi gerekir.

```java
public interface IFlying {
	public void fly();
}
```

```java
public interface ISwimming {
	public void swim();
}
```

```java
public class duck implements IFlying, ISwimming {
	@Override
	public void fly() {
		System.out.println("I flew!");
	}

	@Override
	public void swim() {
		System.out.println("I swam!");
	}
}
```

## Abstract ve Interface farkı

- Bir class en fazla bir class'ın çocuğu olabilir. Fakat bir çok interface'den implement edilebilir.

- Interface'de tanımlanan tüm field'lar public-static-final'dır. Tüm method'lar ise public'tir. Abstract'ta istediğimiz gibi tanımlamayapabiliriz.

- Abstract class'lar abstract olmayan method'lar içerebilir.

## Generics

Class'ların belirli bir tip için değil, şablon yapısına uyan her tip için çalılmasını sağlayan yapıdır.

```java
import java.util.Generics;
import java.util.List;

public class Example {
	public static void main(String[] args) {
		List<Integer> lengths = new List<Integer>();

		lengths.add(100);
		lengths.add(200);
		lengths.add(300);

		for(int length : lengths ) {
			System.out.println(length);
		}
	}
}
```

Yani burada, Generic bir class olan List class'ında integer veriler tuttuk. İstediğimiz(belirttiğimiz) veriyi tutabilirdik.

#### Generic Class oluşturmak

```java
public class Box<T> {
	T element;

	public Box(T element) {
		this.element = element;
	}

	public T get() {
		return element;
	}
}
```

```java
public class BoxTest {
	public static void main(String[] args) {
		Box<String> box = new Box<String>("heyyyo");

		System.out.println(box.get());
	}
}
```

#### Comparable Class oluşturmak

```java
public class Info implements Comparable<Info> {
	public String name;

	public Info(String name) {
		this.name = name;
	}

	/**
	 * makes "Info" class comparable by "name" variable.
	 */
	@Override
	public int compareTo(Name name) {
		return this.name.compareTo(name);
	}
}
```

```java
public class InfoTest {
	public static void main(String[] args) {
		Info info1 = new Info("Bora");
		Info info2 = new Info("Asya");

		print(maxValue(info1, info2));
	}

	/**
	 * to use compareTo method for "T" type.
	 */
	public static <T extends Comparable<T>> T maxValue (T o1, T o2) {
		return o1.compareTo(o2)? o1 : o2;
	}
}
```

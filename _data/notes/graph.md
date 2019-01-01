## Graph (çizge)

<p align="center">
	<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Directed.svg/1200px-Directed.svg.png" width="300px">
</p>

**`VERTEX`** : node  
**`EDGE`** : node'lar arasındaki bağlantı, yollar

```java
public class Vertex<T> {

	public T value;
	public List<Edge<T>> edges;

	public Vertex(T value) {
		this.value = value;
		edges = new ArrayList<>();
	}
}
```

```java
public class Edge<T> {

	Vertex<T> from;
	Vertex<T> to;
	int weight;

	public Edge(Vertex<T> from, Vertex<T> to) {
		this.from = from;
		this.to = to;
		weight = 1;
	}

	public Edge(Vertex<T> from, Vertex<T> to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}
```

<p align="center">
	<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Directed_graph%2C_cyclic.svg/220px-Directed_graph%2C_cyclic.svg.png" width="300px">
</p>

Graph'lar directed ya da undirected olabilir. Undirected olan graph'larda **`indegree`** ve **`outdegree`** kavramları vardır.

| Value | Indegree | Outdegree |
|:-----:|:--------:|:---------:|
| **A** | 0 | 1 |
| **B** | 1 | 1 |
| **C** | 1 | 1 |
| **D** | 1 | 1 |
| **E** | 1 | 2 |
| **F** | 1 | 0 |

```java
public int outDegree(T value, Map<T, Vertex<T>> verticesMap) {
	Vertex<T> vertex = verticesMap.get(value);

	if(! vertex == null) {
		return vertex.edges.size();
	}

	return -1;
}
```

```java
public int indegree(T value, Map<T, List<Edge<T>>> edgesMap) {
	int counter = 0;

	for(Map.Entry<T, List<Edge<T>>> entry : edgesMap.entrySet()) {
		List<Edge<T>> edges = entry;

		for(Edge<T> edge : edges) {
			if(edge.to.value.equals(value)) {
				counter++;
			}
		}
	}

	return counter;
}
```

## Depth First Searching (derine arama)

Derine gidilir. Dolaşma işlemi bir düğümden başlar. Gidilebilecek mümkün komşulardan bir tanesini seçer ve ilerler. Gidilebilecek diğer düğümlere bakmadan önce yeni gidilen düğümün komşuları incelenir ve bir tanesine gidilir. Gidilebilecek komşu kalmayınca geri sarılarak mümkün komşular aranır. Ufak olana öncelik verilir.

Dolaşma aşağıdaki gibi olur.

<p align="center">
	<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Depth-first-tree.svg/1200px-Depth-first-tree.svg.png" width="600px">
</p>

```java
public void depthFirstSearch(Vertex<T> root) {
	Stack<Vertex<T>> vertices = new Stack<Vertex<T>>();
	vertices.add(root);
	ArrayList<Vertex<T>> visited = ArrayList<Vertex<T>>();

	while(! vertices.isEmpty()) {
		Vertex<T> current = vertices.pop();
		if(visited.contains(current)) {
			continue;
		} else {
			visited.push(vertex);

			System.out.println(vertex.value + " is visited!");

			for(Edge<T> edge : vertex.edges) {
				vertices.push(edge.to);
			}
		}
	}
}
```

## Breadth First Search (enine arama)

Enine gidilir. Dolaşma işlemi bir düğümden başlar. Gidilebilecek mümkün komşular hepsini sırayla seçer ve ilerler. Gidilebilecek bütün komşular gezildikten sonra ilk komşunun komşuları seçilir. Ufak olana öncelik verilir.

Dolaşma aşağıdaki gibi olur.

<p align="center">
	<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Breadth-first-tree.svg/1200px-Breadth-first-tree.svg.png" width="600px">
</p>

```java
public void breadthFirstSearch(Vertex<T> root) {
	Queue<Vertex<T>> vertices = new LinkedList<Vertex<T>>();
	vertices.enqueue(root);
	ArrayList<Vertex<T>> visited = ArrayList<Vertex<T>>();

	while(! vertices.isEmpty) {
		Vertex<T> current = vertices.denqueue();

		if(visited.contains(current)) {
			continue;
		} else {
			visited.push(current);

			for(Edge<T> edge : current.edges) {
				vertices.add(edge.to);
			}
		}
	}
}
```

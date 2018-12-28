
/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleGraph<T> {

	/**
	 * Düğümleri tutan liste
	 */
	protected List<Vertex<T>> vertices;
	/**
	 * Düğümlere kolay erişmek için kullanılan map <değer, düğüm>
	 */
	protected Map<T, Vertex<T>> verticesMap;
	/**
	 * Çizge yönlü mü
	 */
	boolean directed = true;

	public SimpleGraph() {
		vertices = new ArrayList<>();
		verticesMap = new HashMap<>();
	}

	public SimpleGraph(boolean directed) {
		this();
		this.directed = directed;
	}

	/**
	 * Çizgeye düğüm ekler
	 *
	 * @param deger eklenecek düğümün değeri
	 */
	public void addVertex(T deger) {
		if (!vertices.contains(deger)) {
			Vertex<T> v = new Vertex<>(deger);
			vertices.add(v);
			verticesMap.put(deger, v);
		}
	}

	/**
	 * Çizgeye kenar ekler
	 *
	 * @param from kenarın çıktığı düğüm
	 * @param to kenarın girdiği düğüm
	 */
	public void addEdge(T from, T to) {
		addEdge(from, to, 1);
	}

	/**
	 * Çizgeye kenar ekler
	 *
	 * @param from kenarın çıktığı düğüm
	 * @param to kenarın girdiği düğüm
	 * @param weight kenarın ağırlığı
	 */
	public void addEdge(T from, T to, int weight) {
		Vertex<T> f = verticesMap.get(from);
		Vertex<T> t = verticesMap.get(to);
		if (f != null && t != null) {
			for (Edge<T> e : f.edges) {
				if (e.to.value.equals(to)) {
					return;
				}
			}
			Edge e1 = new Edge(f, t, weight);
			//edges.get(from).add(e1);//alttaki şekilde değişti
			verticesMap.get(from).edges.add(e1);
			if (!directed) {
				Edge e2 = new Edge(t, f, weight);
				//edges.get(to).add(e2);//alttaki şekilde değişti
				verticesMap.get(to).edges.add(e2);
			}
		}

	}

	/**
	 * Çizgenin içeriğini ekrana yazdırır
	 */
	public void print() {
		System.out.println(toString());
	}

	/**
	 * Düğüm ve kenarları içeren metinsel temsil
	 *
	 * @return Çizgenin metin temsilini verir
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vertices:\n");
		for (Vertex<T> vertex : vertices) {
			sb.append(vertex.value + "\n");
		}
		sb.append("Edges:\n");
		for (Vertex<T> vertex : vertices) {
			for (Edge<T> edge : vertex.edges) {
				sb.append(edge.from.value + (edge.weight != 1 ? " - " + edge.weight : "") + " -> " + edge.to.value + "\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Düğüme gelen kenar sayısını verir
	 *
	 * @param deger hesaplanmak istenen düğümün değeri
	 * @return gelen kenar sayısı
	 */
	public int inDegree(T deger) {
		Vertex<T> vv = verticesMap.get(deger);
		if (vv == null) {
			return -1;
		}
		int id = 0;
		for (Vertex<T> v : vertices) {
			for (Edge<T> e : v.edges) {
				if (e.to.value.equals(deger)) {
					id++;
				}
			}
		}
		return id;
	}

	/**
	 * Düğümden çıkan kenar sayısını verir
	 *
	 * @param deger hesaplanmak istenen düğümün değeri
	 * @return çıkan kenar sayısı
	 */
	public int outDegree(T deger) {
		Vertex<T> v = verticesMap.get(deger);
		if (v == null) {
			return -1;
		}
		return v.edges.size();
	}
}

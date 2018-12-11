/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

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

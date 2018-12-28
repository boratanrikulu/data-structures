
/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

	public T value;
	public List<Edge<T>> edges;

	public Vertex(T value) {
		this.value = value;
		edges = new ArrayList<>();
	}
}

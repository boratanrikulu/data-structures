/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

import java.util.List;
import java.util.Map;

public class LabGraph<T> extends AbstractGraph<T> {

	@Override
	public int outDegree(T deger) {
		Vertex<T> vertex = verticesMap.get(deger);
		
		if (vertex != null)
			return vertex.edges.size();
		
		return -1;
	}

	@Override
	public int inDegree(T deger) {
		int counter = 0;
		for (Map.Entry<T, List<Edge<T>>> entry : edges.entrySet()) {
			List<Edge<T>> value = entry.getValue();
			
			for (Edge<T> edge : value) {
				if (edge.to.equals(deger)) {
					counter++;
				}
			}
		}

		return counter;
	}
}

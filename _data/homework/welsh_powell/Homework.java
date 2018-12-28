/* 17253509 - Bedrettin Bora Tanrikulu */

/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at https://boratanrikulu.me/contact
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Homework {

	public SimpleGraph<String> graph;
	public ArrayList<Vertex<String>> sortedVertices;
	public Map<String, String> coloredGraph;

	/**
	 * Constructor creates a SimpleGraph by parsing "girdi" variable which comes as a String.
	 */
	public Homework(String girdi) {
		if (girdi == null)
			return;
		
		graph = new SimpleGraph<String>();
		for (String element : girdi.split("\n")) {
			String[] neighbours = element.split(" ");
			
			graph.addVertex(neighbours[0]);
		}
		
		for (String element : girdi.split("\n")) {
			String[] neighbours = element.split(" ");
			
			for (int counter = 1; counter < neighbours.length; counter++) {
				graph.addEdge(neighbours[0], neighbours[counter]);
			}
		}
	}

	/**
	 * "Boya" method creates a HashMap that includes colors of vertices by using a reversed list of vertices.
	 */
	public Map<String, String> boya(String[] renkler) {
		sortVertices();
		coloredGraph = new HashMap<String, String>();

		int colorCounter = 0;
		for (int counter = 0; counter < sortedVertices.size(); counter++) {
			if (coloredGraph.containsKey(sortedVertices.get(counter).value)) {
				continue;
			} else if (sortedVertices.get(counter).edges.size() == 0) {
				coloredGraph.put(sortedVertices.get(counter).value, renkler[0]);
				colorCounter++;
			} else {
				coloredGraph.put(sortedVertices.get(counter).value, renkler[colorCounter]);
				
				for (int counter2 = counter + 1; counter2 < sortedVertices.size(); counter2++) {
					if (! checkNeighbours(sortedVertices.get(counter2), renkler[colorCounter]) && ! coloredGraph.containsKey(sortedVertices.get(counter2).value)) {
						coloredGraph.put(sortedVertices.get(counter2).value, renkler[colorCounter]);
					}
				}
				
				colorCounter++;
			}
		}
		
		return coloredGraph;
	}
	
	/**
	 * "checkNeighbours" method checks if vertex's neighbours have same color.
	 */
	public boolean checkNeighbours(Vertex<String> vertex, String color) {
		for (Edge<String> edge : vertex.edges) {
			if (coloredGraph.containsKey(edge.to.value) && coloredGraph.get(edge.to.value).equals(color)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * "sortVertices" method sorts vertices by comparing their neighbours value.
	 */
	public void sortVertices() {
		sortedVertices = new ArrayList<>();

		for (Vertex<String> vertex : graph.vertices) {
			sortedVertices.add(vertex);
		}
		
		/* reverse sorting */
		Collections.sort(sortedVertices, new Comparator<Vertex<String>>() {
			@Override
			public int compare(Vertex<String> o1, Vertex<String> o2) {
				int difference = o2.edges.size() - o1.edges.size();
				
				if (difference == 0) {
					return o1.value.compareTo(o2.value);
				} else {
					return difference;
				}
			}
		});
	}
}

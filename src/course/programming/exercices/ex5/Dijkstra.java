package course.programming.exercices.ex5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import course.programming.Constants;

public class Dijkstra {

	public static Graph g;
	public static Node s;
	public static Node t;
	public static final Integer SOURCE_VERTEX = 1;
	public static final Integer[] TARGET_VERTICES = { 7, 37, 59, 82, 99, 115, 133, 165, 188, 197 };
	//	public static final Integer[] TARGET_VERTICES = { 1, 2, 3, 4, 5, 6};
	private static final int GRAPH_SIZE = 200;
	private static final String FILE_PATH = Constants.RESOURCES_DIR	+ "\\ex5\\dijkstraData.txt";
	//	private static final String FILE_PATH = Constants.RESOURCES_DIR + "\\ex5\\simpleTest.txt";
	public static int iteration;

	public static void main(final String[] args) {
		String result = "";

		loadGraph();
		s = g.get(SOURCE_VERTEX);
		s.setPathWeight(0);

		for (int i = 0; i < TARGET_VERTICES.length; i++){
			t = g.get(TARGET_VERTICES[i]);
			iteration = i;

			System.out.println("Iteracion: "+(i+1));
			dijkstra(g, s);
			System.out.println("Nodo objetivo: "+t.getId()+" Distancia: "+t.getPathWeight()+" Camino: "+t.getPathString()+t.getId());
			System.out.println("\n");

			result +=t.getPathWeight()+",";

			g.reset();
			s.setPathWeight(0);
		}

		System.out.println("Result: "+result);

	}

	public static void dijkstra(final Graph g, final Node node) {
		if (node.getId() != t.getId()) {
			//			node.setExplored(iteration);
			for (int i = 0; i < node.getAdjacencies().size(); i++) {
				WeightEdge adj = node.getAdjacencies().get(i);
				//				if (!adj.getNode().isExplored(iteration)) {
				if (node.getPathWeight()+adj.getWeight() < adj.getNode().getPathWeight()){
					//Actualizamos la distancia
					adj.getNode().setPathWeight(node.getPathWeight()+adj.getWeight());
					//Actualizamos el camino
					adj.getNode().getPath().clear();
					adj.getNode().getPath().addAll(node.getPath());
					adj.getNode().getPath().add(node);

					dijkstra(g, adj.getNode());
				}
				//				}
			}
		}
	}

	private static void loadGraph() {
		g = new Graph(GRAPH_SIZE);
		try {
			File f = new File(FILE_PATH);
			if (!f.exists()) {
				throw new FileNotFoundException();
			}
			FileInputStream fstream = new FileInputStream(f);

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				createNewNode(strLine);
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void createNewNode(final String line) {
		String[] detail = line.split("\t");
		Integer index = Integer.parseInt(detail[0]);
		Node n = null;
		if ((n = g.get(index)) == null) {
			n = new Node(index);
		}
		for (int i = 1; i < detail.length; i++) {
			Integer adjIndex = Integer.parseInt(detail[i].split(",")[0]);
			Integer adjWeight = Integer.parseInt(detail[i].split(",")[1]);
			Node adj = g.get(adjIndex);
			if (adj == null) {
				adj = new Node(adjIndex);
				g.put(adj);
			}
			n.getAdjacencies().add(new WeightEdge(adj, adjWeight));
		}
		g.put(n);
	}
}

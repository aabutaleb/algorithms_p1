package course.programming.exercices.ex3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Random;

import course.programming.Constants;

public class MinCut {

	public static Graph g = null;
	public static Random random = null;

	public static Integer getRandomInt(final Integer size) {
		Integer r = random.nextInt(size);
		if (r == 0) {
			r = getRandomInt(size);
		}

		return r;
	}

	public static Integer proceed() {
		random = new Random(System.currentTimeMillis());
		loadGraph();

		for (int i = g.getSize(); i > 2; i--) {
			Node node1 = null, node2 = null;
			Integer randomInt = null;
			try {
				randomInt = getRandomInt(g.getSize());
				node1 = g.get(randomInt);
				randomInt = getRandomInt(node1.getAdjacencies().size());
				node2 = node1.getAdjacencies().get(randomInt);

				g.collapse(node1, node2);
			} catch (Exception e) {
				System.err.println(node1);
				System.err.println(node2);
				System.err.println(randomInt);
				g.printGraph();
				throw new RuntimeException();
			}
		}

		return getMinCut();
	}

	private static Integer getMinCut() {
		Node a = null, b = null;
		for (int i = 1; i <= g.getSize() && (a == null || b == null); i++) {
			Node n = g.get(i);
			if (a == null) {
				a = n;
			} else if (b == null && !a.getLabel().equals(n.getLabel())) {
				b = n;
			}
		}
		System.out.println("Node A: " + a);
		System.out.println("Node B: " + b);
		System.out.println("MinCut  Count = " + a.getAdjacencies().size());

		return a.getAdjacencies().size();
	}

	private static void loadGraph() {
		g = new Graph(200);
		try {
			File f = new File(Constants.RESOURCES_DIR
					+ "\\ex3\\kargerMinCut.txt");
			// File f = new File(Constants.RESOURCES_DIR +
			// "\\ex3\\simpleTest.txt");
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
			Integer adjIndex = Integer.parseInt(detail[i]);
			Node adj = g.get(adjIndex);
			if (adj == null) {
				adj = new Node(adjIndex);
				g.put(adj);
			}
			n.getAdjacencies().add(adj);
		}
		g.put(n);
	}

}

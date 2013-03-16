package course.programming.exercices.ex4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import course.programming.Constants;

public class StrongConnectedComponentsCount {
	private static final int SIZE = 875714;
	//	private static final int SIZE = 50;

	private static final Graph g = new Graph(SIZE);
	private static final Graph grev = new Graph(SIZE);
	private static final DepthFirstSearch dps = new DepthFirstSearch();
	private static int TAIL_INDEX = 0;
	private static int HEAD_INDEX = 1;

	public static void main(final String[] args) throws IOException {
		Log.initLog();
		try{
			System.out.println("Loading graphs...");
			loadGraphs();
			System.out.println("Graphs loaded...");
			System.out.println("Starting DPS I...");
			dps.dpsLoop(grev);
			System.out.println("Completed DPS I.");
			System.out.println("Computing Time graph...");
			g.computeFinishingTimeGraph(grev.getFinishingTime());
			System.out.println("Completed Time graph.");
			System.out.println("Starting DPS II...");
			dps.resetCount();
			dps.dpsLoop(g);
			System.out.println("Completed DPS II.");
			System.out.println("Getting SCC...");
			SCCMap scc = g.getSCC();
			scc.printSCC();
			System.out.println("Finished execution.");
		}
		catch (Exception e) {
		}
		finally{
			Log.closeLog();
		}
	}

	private static void loadGraphs() {
		try {
			File f = new File(Constants.RESOURCES_DIR + "\\ex4\\SCC.txt");
			//			File f = new File(Constants.RESOURCES_DIR + "\\ex4\\simpleTest.txt");
			if (!f.exists()) {
				throw new FileNotFoundException();
			}
			FileInputStream fstream = new FileInputStream(f);

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				loadNodeArc(g, strLine, TAIL_INDEX, HEAD_INDEX);
				loadNodeArc(grev, strLine, HEAD_INDEX, TAIL_INDEX);
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void loadNodeArc(final Graph g, final String line, final int fromIndex,
			final int toIndex) {
		String[] detail = line.split(" ");
		Integer index = Integer.parseInt(detail[fromIndex]);
		Node n = null;
		if ((n = g.get(index)) == null) {
			n = new Node(index);
		}
		Integer adjIndex = Integer.parseInt(detail[toIndex]);
		Node adj = g.get(adjIndex);
		if (adjIndex != index){
			if (adj == null) {
				adj = new Node(adjIndex);
				g.put(adj);
			}
			n.getAdjacencies().add(adj);
		}
		g.put(n);
	}
}

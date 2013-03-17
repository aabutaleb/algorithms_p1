package course.programming.exercices.ex6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import course.programming.Constants;

public class MedianMaintenance {

	private static final Integer SIZE = 10000;
	private static MinHeap highHeap = new MinHeap(SIZE);
	private static MaxHeap lowHeap = new MaxHeap(SIZE);
	private static int elements = 0;
	private static final String FILE_PATH = Constants.RESOURCES_DIR	+ "\\ex6\\Median.txt";
	private static List<Integer> medians = new ArrayList<Integer>();

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		loadFile();

		System.out.println("Total Median: "+calculateTotalMedian());
	}

	private static Integer calculateTotalMedian() {
		int totalMedian = 0;
		for (Integer i : medians){
			totalMedian += i;
		}
		totalMedian = totalMedian % SIZE;
		return totalMedian;
	}

	private static Integer calculateMedian() {
		Integer median = lowHeap.max();
		medians.add(median);
		return median;
	}

	private static void balanceHeaps() {
		int mediumSize = elements/2;
		while (highHeap.size() != mediumSize){
			if (Math.max(highHeap.size(), lowHeap.size()) == highHeap.size()){
				lowHeap.add(highHeap.removeMin());
			}
			else{
				highHeap.add(lowHeap.removeMax());
			}
		}
	}

	private static void insertIntoHeap(final int element) {
		if (highHeap.isEmpty() && lowHeap.isEmpty()){
			lowHeap.add(element);
		}
		else if (element > lowHeap.max()){
			highHeap.add(element);
		}
		else{
			lowHeap.add(element);
		}
	}

	private static void loadFile() {
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
				insertIntoHeap(Integer.parseInt(strLine));
				elements++;

				balanceHeaps();
				System.out.println("Median "+elements+": "+calculateMedian());
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}

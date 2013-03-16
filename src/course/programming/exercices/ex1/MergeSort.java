package course.programming.exercices.ex1;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import course.programming.Constants;

/**
 * 
 * @author Amin
 *
 */
public class MergeSort {
	public static void main(final String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		load(l);
		InvCount lOrdered = mergeSort(new InvCount(0, l));

		System.out.println(lOrdered);
	}

	private static InvCount mergeSort(final InvCount l) {
		if (l.size() > 1) {
			InvCount l1 = mergeSort(l.subList(0, l.size() / 2));
			InvCount l2 = mergeSort(l.subList(l.size() / 2, l.size()));
			List<Integer> result = new ArrayList<Integer>();
			long count = l1.getCount() + l2.getCount();

			int j = 0, k = 0;
			for (int i = 0; i < l.size(); i++) {
				if (k == l2.size() || (j < l1.size() && l1.get(j) <= l2.get(k))) {
					result.add(l1.get(j++));
				} else if (j == l1.size() || (k < l2.size() && l1.get(j) > l2.get(k))) {
					result.add(l2.get(k++));
					count += (l1.size() - j);
				}
			}

			return new InvCount(count, result);
		} else {
			return l;
		}
	}

	private static void load(final List<Integer> l) {
		try {
			FileInputStream fstream = new FileInputStream(Constants.RESOURCES_DIR+"\\ex1\\IntegerArray.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				l.add(Integer.parseInt(strLine));
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}



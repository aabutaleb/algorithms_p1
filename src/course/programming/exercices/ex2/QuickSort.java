package course.programming.exercices.ex2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Amin
 * 
 */
public class QuickSort {
	public static void main(final String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		load(l);

		CompCount lOrdered = quickSort(new CompCount(0, l));

		System.out.println(lOrdered);
	}

	public static CompCount quickSort(final CompCount l) {
		if (l.size() > 1) {
			Pivot p = PivotChooser.choosePivotMethod1(l.getList());
			int i = p.getPosition() + 1;
			for (int j = i; j < l.size(); j++) {
				if (l.get(j) < p.getValue()) {
					l.swap(j, i++);
				}
			}
			quickSort(l.subList(0, p.getPosition()-1));
			quickSort(l.subList(p.getPosition()+1,l.size()));
			l.swap(p.getPosition(), i - 1);
		}
		return l;
	}

	private static void load(final List<Integer> l) {
		// try {
		// FileInputStream fstream = new
		// FileInputStream(Constants.RESOURCES_DIR+"\\ex2\\quickSort.txt");
		// DataInputStream in = new DataInputStream(fstream);
		// BufferedReader br = new BufferedReader(new InputStreamReader(in));
		// String strLine;
		// // Read File Line By Line
		// while ((strLine = br.readLine()) != null) {
		// // Print the content on the console
		// l.add(Integer.parseInt(strLine));
		// }
		// // Close the input stream
		// in.close();
		// } catch (Exception e) {// Catch exception if any
		// System.err.println("Error: " + e.getMessage());
		// }
		l.add(8);
		l.add(2);
		l.add(4);
		l.add(5);
		l.add(7);
		l.add(1);
	}

}

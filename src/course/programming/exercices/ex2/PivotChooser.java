package course.programming.exercices.ex2;

import java.util.List;

public class PivotChooser {
	public static Pivot choosePivotMethod1(final List<Integer> list) {
		Integer pos = 0;
		return new Pivot(list.get(pos),pos);
	}

	public static Pivot choosePivotMethod2(final List<Integer> list) {
		Integer pos = list.size()-1;
		return new Pivot(list.get(pos),pos);
	}

	public static Pivot choosePivotMethod3(final List<Integer> list) {
		Double median = Math.floor(new Double(list.size())/2);
		Integer pos = median.intValue() -1;
		return new Pivot(list.get(pos),pos);
	}
}

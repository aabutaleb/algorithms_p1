package course.programming.exercices.ex2;

import java.util.Collections;
import java.util.List;

public class CompCount {
	private long count;
	private List<Integer> list;

	public CompCount(final long count, final List<Integer> list) {
		super();
		this.count = count;
		this.list = list;
	}

	public long getCount() {
		return count;
	}

	public void setCount(final long count) {
		this.count = count;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(final List<Integer> list) {
		this.list = list;
	}

	public int size() {
		return list.size();
	}

	public boolean add(final Integer e) {
		return list.add(e);
	}

	public Integer get(final int index) {
		return list.get(index);
	}

	public CompCount subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 ) {
			fromIndex = 0;
		}
		if (toIndex < 0) {
			toIndex = 0;
		}
		return new CompCount(count, list.subList(fromIndex, toIndex));
	}

	public void swap (final int first, final int second){
		Collections.swap(list, first, second);
	}

	@Override
	public String toString() {
		return this.count + " - " + this.list;
	}

}
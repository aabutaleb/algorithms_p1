package course.programming.exercices.ex1;

import java.util.List;

public class InvCount {
	private long count;
	private List<Integer> list;

	public InvCount(final long count, final List<Integer> list) {
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

	public InvCount subList(final int fromIndex, final int toIndex) {
		return new InvCount(count, list.subList(fromIndex, toIndex));
	}

	@Override
	public String toString() {
		return this.count + " - " + this.list;
	}

}
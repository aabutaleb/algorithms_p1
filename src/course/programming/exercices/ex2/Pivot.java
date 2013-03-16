package course.programming.exercices.ex2;

public class Pivot {
	private Integer value;
	private Integer position;

	public Pivot(final Integer value, final Integer position) {
		super();
		this.value = value;
		this.position = position;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(final Integer value) {
		this.value = value;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(final Integer position) {
		this.position = position;
	}

}

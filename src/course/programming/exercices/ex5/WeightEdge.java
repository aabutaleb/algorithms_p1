package course.programming.exercices.ex5;

public class WeightEdge {
	private Node node;
	private Integer weight;

	public WeightEdge(final Node node, final Integer weight) {
		super();
		this.node = node;
		this.weight = weight;
	}

	public Node getNode() {
		return node;
	}

	public Integer getWeight() {
		return weight;
	}
}

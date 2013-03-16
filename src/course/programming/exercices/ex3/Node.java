package course.programming.exercices.ex3;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private boolean collapsed = false;
	private Integer id;
	private String label;
	private List<Node> adjacencies;

	public Node(final Integer id) {
		super();
		this.id = id;
		this.label = id+"";
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public List<Node> getAdjacencies() {
		if (adjacencies == null) {
			adjacencies = new ArrayList<Node>();
		}

		return adjacencies;
	}

	public void setAdjacencies(final List<Node> adjacencies) {
		this.adjacencies = adjacencies;
	}

	public boolean isCollapsed() {
		return collapsed;
	}

	public void setCollapsed(final boolean collapsed) {
		this.collapsed = collapsed;
	}

	@Override
	public String toString() {
		String toString = "[ID:"+getId()+"] [LABEL:"+getLabel()+"] [ADJACENCIES:";
		for (Node nad : getAdjacencies()){
			toString+="\t "+nad.getLabel();
		}
		return toString+"]";
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

}

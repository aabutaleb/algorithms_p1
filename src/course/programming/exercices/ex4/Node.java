package course.programming.exercices.ex4;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private boolean explored = false;
	private Integer id;
	private String label;
	private List<Node> adjacencies;
	private Node leader;

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

	@Override
	public String toString() {
		String toString = "[ID:"+getId()+"] [LABEL:"+getLabel()+"] [ADJACENCIES:";
		for (Node nad : getAdjacencies()){
			toString+="\t "+nad.getLabel();
		}
		if (getLeader() != null){
			return toString+"] [LEADER: "+getLeader().getLabel()+"]";
		}
		else{
			return toString+"]";
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public boolean isExplored() {
		return explored;
	}

	public void setExplored(final boolean explored) {
		this.explored = explored;
	}

	public Node getLeader() {
		return leader;
	}

	public void setLeader(final Node leader) {
		this.leader = leader;
	}

}

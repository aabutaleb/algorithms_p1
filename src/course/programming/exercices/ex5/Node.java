package course.programming.exercices.ex5;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private Integer id;
	private String label;
	private int explored = -1;
	private List<WeightEdge> adjacencies;

	private List<Node> path = new ArrayList<Node>();
	private Integer pathWeight = Integer.MAX_VALUE;

	public Node(final Integer id) {
		super();
		this.id = id;
		this.label = id + "";
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public List<WeightEdge> getAdjacencies() {
		if (adjacencies == null) {
			adjacencies = new ArrayList<WeightEdge>();
		}

		return adjacencies;
	}

	@Override
	public String toString() {
		String toString = "[ID:" + getId() + "] [LABEL:" + getLabel()
		+ "] [ADJACENCIES:";
		for (int i = 0; i < getAdjacencies().size(); i++) {
			Node nad = getAdjacencies().get(i).getNode();
			Integer weight = getAdjacencies().get(i).getWeight();
			toString += "\t " + nad.getLabel() + "(" + weight + ")";
		}
		return toString + "]";
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public boolean isExplored(final int i) {
		return explored >= i;
	}

	public void setExplored(final int explored) {
		this.explored = explored;
	}

	public int getPathWeight() {
		return pathWeight;
	}

	public void setPathWeight(final int pathWeight) {
		this.pathWeight = pathWeight;
	}

	public List<Node> getPath() {
		if (path == null){
			path = new ArrayList<Node>();
		}
		return path;
	}

	public String getPathString(){
		String s = "";
		for (Node n : path){
			s+=n.getId()+",";
		}
		return s;
	}

	public void setPath(final List<Node> path) {
		this.path = path;
	}

}

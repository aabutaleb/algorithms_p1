package course.programming.exercices.ex5;

import java.util.ArrayList;



public class Graph {
	private final Node[] nodeList;
	private Integer size;

	public Graph(final int size) {
		nodeList = new Node[size];
		this.size = size;
	}

	public void put(final Node n){
		nodeList[n.getId()-1] = n;
	}

	public Node get(final Integer label){
		return nodeList[label-1];
	}


	public void printGraph() {
		for (Node n : nodeList) {
			System.out.println(n);
		}
	}

	public Integer getSize() {
		return size;
	}

	public void reset() {
		for (Node n : nodeList){
			n.setPath(new ArrayList<Node>());
			n.setPathWeight(Integer.MAX_VALUE);
		}
	}

}

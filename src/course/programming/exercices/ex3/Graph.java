package course.programming.exercices.ex3;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private final Node[] nodeList;
	private Integer size;

	public Graph(final int size) {
		nodeList = new Node[size];
		this.size = size;
	}

	public void collapse(final Node node1, final Node node2) {
		String collapsedNodeName = getCollapsedNodeName(node1, node2);
		//		System.out.println("Collapse "+node1.getLabel()+ " -> " + node2.getLabel() + " ==> " + collapsedNodeName);
		List<Node> newAdjList = new ArrayList<Node>();

		for (Node n : node1.getAdjacencies()){
			if (!isInLabel(collapsedNodeName,n.getId())){
				newAdjList.add(n);
			}
		}
		for (Node n : node2.getAdjacencies()){
			if (!isInLabel(collapsedNodeName,n.getId())){
				newAdjList.add(n);
			}
		}

		node1.setAdjacencies(newAdjList);
		node1.setCollapsed(true);
		node1.setLabel(collapsedNodeName);


		String[] collapsedNameSplit = collapsedNodeName.split("/");
		for (String s : collapsedNameSplit){
			Integer i = Integer.parseInt(s);
			Node nc = get(i);
			nc.setAdjacencies(newAdjList);
			nc.setCollapsed(true);
			nc.setLabel(collapsedNodeName);
		}
	}

	private boolean isInLabel(final String collapsedNodeName, final Integer id) {
		String[] names = collapsedNodeName.split("/");
		for (String n : names){
			if (n.equals(""+id)){
				return true;
			}
		}
		return false;
	}

	private String getCollapsedNodeName(final Node node1, final Node node2) {
		return node1.getLabel()+"/"+node2.getLabel();
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

}

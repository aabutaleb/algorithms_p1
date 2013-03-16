package course.programming.exercices.ex4;

public class Graph {
	private Node[] nodeList;
	private Node[] finishingTime;
	private Integer size;

	public Graph(final int size) {
		nodeList = new Node[size];
		finishingTime = new Node[size];
		this.size = size;
	}

	public void put(final Node n) {
		nodeList[n.getId() - 1] = n;
	}

	public Node get(final Integer id) {
		return nodeList[id - 1];
	}

	public void printGraph() {
		for (Node n : nodeList) {
			System.out.println(n);
		}
	}

	public void printFinishingTimeGraph() {
		for (Node n : finishingTime) {
			System.out.println(n);
		}
	}

	public SCCMap getSCC(){
		SCCMap scc = new SCCMap();
		for (Node n : nodeList){
			scc.increase(n.getLeader().getId()+"");
		}
		return scc;
	}

	public Integer getSize() {
		return size;
	}

	public void setLeader(final int index, final Node n) {
		nodeList[index-1].setLeader(n);
	}

	public Node getLeader(final int index) {
		return nodeList[index-1].getLeader();
	}

	public void setFinishingTime(final int index, final int value){
		finishingTime[index-1] = get(value);
	}

	public void computeFinishingTimeGraph(final Node[] finishingTime) {
		for (int i = 0; i < finishingTime.length; i++){
			nodeList[i].setLabel(finishingTime[i].getLabel());
			nodeList[i].setLeader(finishingTime[i].getLeader());
		}

		reorderArray(nodeList);
	}

	private void reorderArray(final Node[] nodeList) {
		Node[] nodeList2 = new Node[getSize()];
		for (Node n : nodeList){
			nodeList2[Integer.parseInt(n.getLabel())-1] = n;
			n.setId(Integer.parseInt(n.getLabel()));
		}

		this.nodeList = nodeList2;
	}

	public Node[] getFinishingTime() {
		return finishingTime;
	}

}

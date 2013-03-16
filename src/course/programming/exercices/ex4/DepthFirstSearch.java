package course.programming.exercices.ex4;

public class DepthFirstSearch {

	public int t = 0;
	public Node s = null;

	public void resetCount(){
		t = 0;
		s = null;
	}

	public void dpsLoop(final Graph g){
		for (int i = g.getSize(); i >= 1; i--){
			Node n = g.get(i);
			if (!n.isExplored()){
				s = n;
				dps (g,n);
			}
		}
	}

	public void dps(final Graph g, final Node node){
		node.setExplored(true);
		g.setLeader(node.getId(), s);
		for (Node adj : node.getAdjacencies()){
			if (!adj.isExplored()){
				dps(g,adj);
			}
		}
		g.setFinishingTime(node.getId(), ++t);
	}
}

import java.util.*;
public class Route{
	public static void main(String... args){
		Route r = new Route();
		GNode start = new GNode();
		GNode n1 = new GNode();
		GNode n2 = new GNode();
		GNode n3 = new GNode();
		GNode n4 = new GNode();
		GNode end = new GNode();
		start.adjNodes = new GNode[]{n1, n2, n3};
		n3.adjNodes = new GNode[]{n4};
		
		System.out.println(r.hasRoute(start, end));
	}

	boolean hasRoute(GNode start, GNode end){
		Queue<GNode> queue = new LinkedList<GNode>();
		queue.offer(start);
		while(!queue.isEmpty()){
			GNode src = queue.poll();
			GNode[] adjNodes = src.adjNodes;
			if(adjNodes != null){
				for(GNode n : adjNodes){
					if(n.state != State.VISITED){
						if(n == end){
							return true;
						}
						n.state = State.VISITED;
						queue.offer(n);
					}
				}
			}
		}
		return false;
	}

	static class GNode{
		State state;
		GNode[] adjNodes;
	}

	static enum State{
		VISITED
	}
}
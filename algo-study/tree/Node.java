public class Node {
	Object data;
	Node left;
	Node right;
	Node(){		
	}
	Node(Object data){ 
		this.data = data; 
	}
	public String toString(){
		return "Node " + data;
	}
}
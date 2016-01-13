import java.util.*;
public class LinkedListForEachDepth{
	public static void main(String... args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right.left = new Node(6);
		Map<Integer, List<Node>> result = new LinkedListForEachDepth().getLinkedListAtEachDepth(root);
		System.out.println(result);
	}

	Map<Integer, List<Node>> getLinkedListAtEachDepth(Node root){		
		Map<Integer, List<Node>> lists = new HashMap<Integer, List<Node>>();
		List<Node> list = new LinkedList<Node>();
		list.add(root);
		int depth = 0;
		lists.put(depth, list);
		while(true){
			list = new LinkedList<Node>();						
			for(Node node : lists.get(depth)){				
				if(node.left != null) list.add(node.left);
				if(node.right != null) list.add(node.right);				
			}
			if(list.size() == 0) break;
			else {
				lists.put(++depth, list);
			}
		}
		return lists;
	}

}
public class BalancedTree{
	public static void main(String... args){		
		Node root = new Node(0);
		makeTree(root);
		traverse(root, 0);
		int minDepth = minDepth(root);
		int maxDepth = maxDepth(root);
		System.out.printf("min: %d max: %d\n", minDepth, maxDepth);
		if(maxDepth - minDepth <= 1) System.out.println("It's a Balanced Tree.");
		else System.out.println("It's not a Balanced Tree.");
	}
	
	static int minDepth = Integer.MAX_VALUE;
	static int maxDepth = Integer.MIN_VALUE;

	static void traverse(Node node, int depth){
		if(node.left != null) traverse(node.left, depth + 1);
		if(node.right != null) traverse(node.right, depth + 1);
		if(leafNode(node)){
			if(minDepth > depth) minDepth = depth;
			if(maxDepth < depth) maxDepth = depth;
		}
	}
	
	static boolean leafNode(Node node){
		return node.left == null && node.right == null;
	}

	static void makeTree(Node root){
		root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
	}

	static int maxDepth(Node root){
		if(root == null) return 0;
		return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
	}

	static int minDepth(Node root){
		if(root == null) return 0;
		return 1 + Math.min(minDepth(root.right), minDepth(root.left));
	}
}
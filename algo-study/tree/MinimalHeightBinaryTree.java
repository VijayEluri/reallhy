import java.util.*;
public class MinimalHeightBinaryTree{
	public static void main(String... args){
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
		MinimalHeightBinaryTree mhbt = new MinimalHeightBinaryTree();
		Node root = mhbt.getNode(arr, 0, arr.length - 1);
		
		// get height
		System.out.println(mhbt.getHeight(root));
	}

	Node getNode(int[] arr, int start, int end){
		if(end < start) return null;
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);
		node.left = getNode(arr, start, mid - 1);
		node.right = getNode(arr, mid + 1, end);
		return node;
	}

	int getHeight(Node node){
		if(node == null) return 0;
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
}
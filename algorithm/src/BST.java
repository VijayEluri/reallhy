
public class BST {
    Node root;
    private class Node {
        Node left, right;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(int key, int value){
        root = put(root, key, value);
    }

    public Node put(Node node, int key, int value){
        if(node == null) {
            return new Node(key, value);
        }
        if(node.key > key) node.left = put(node.left, key, value);
        else if(node.key < key) node.right = put(node.right, key, value);
        else node.value = value;
        return node;
    }

    public int get(int key){
        return get(root, key);
    }

    private int get(Node node, int key) {
        if(node == null) return -1;
        if(node.key > key) return get(node.left, key);
        else if(node.key < key) return get(node.right, key);
        else return node.value;
    }

}
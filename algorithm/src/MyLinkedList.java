public class MyLinkedList{	
	private Node head;
	private Node tail;
	private int size;
	private static class Node{
		Object data;
		Node next;
		Node(Object data){
			this.data = data;
			this.next = null;
		}
		public String toString(){
			return data.toString();
		}
	}

	public void add(Object obj){
		Node node = new Node(obj);
		if(head == null) {
			head  = node;
		}
		else {
			tail.next  = node;
		}
		tail = node;
		size++;
	}

	public boolean remove(Object obj){
		Node previous = null;
		Node current = head;
		while(current != null){
			// if head node, head = current.next , if not head node, previous next = current.next
			if(obj.equals(current.data)) { 
				if(previous == null) head = current.next;
				else previous.next = current.next;
				size--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}

	public Object get(int index){
		assert index >= 0 : "index should not be negative.";
		Node current = head;
		int location = index;
		while(location-- > 0){
			if(current == null) throw new RuntimeException("Out of bound - size: "+size + ", index: "+ index);
			current = current.next;
		}
		if(current == null) throw new RuntimeException("Out of bound - size: "+size + ", index: "+ index);
		return current.data;
	}

	public int getSize(){
		return this.size;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("LinkedList - ");
		Node node = head;
		while(node != null){
			sb.append(node.data.toString() + " ");
			node = node.next;
		}
		return sb.toString();
	}


	public static void main(String... args){
		MyLinkedList list = new MyLinkedList();
		System.out.println(list);
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');

		System.out.println(list);
		System.out.println("head: " + list.head.data);
		System.out.println("tail: "+ list.tail.data);
		System.out.println("head.next: " + list.head.next.data);
		System.out.println("3rd item: " + list.get(2));
		System.out.println("size: " + list.size);
		System.out.println("remove: " + list.remove('b'));
		System.out.println(list);
		System.out.println("size: " + list.size);
		System.out.println("remove: " + list.remove('b'));
		System.out.println("remove: " + list.remove('a'));
		System.out.println("head: " + list.head.data);
		System.out.println(list);
		System.out.println("size: " + list.getSize());
		list.get(-1);  //Exception!
	}
}
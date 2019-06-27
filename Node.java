
public class Node<T> {
	
	public T data;
	@SuppressWarnings("rawtypes")
	private Node next;
	
	public Node() {
		this(null, null);
	}
	
	public Node(T entry){
		this(entry, null);
	}

	@SuppressWarnings("rawtypes")
	public Node(T dataPortion, Node nextNode) {
		data = dataPortion;
		next = nextNode;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T newData) {
		data = newData;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public Node getNextNode() {
		return next;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public void setNextNode(Node nextNode) {
		next = nextNode;
	}
	
}

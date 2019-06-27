/*This code was copied from user drewmore on StackOverflow,
 * with some slight alterations to the base. If you would like to find the original code,
 * you can find it at 
 * https://codereview.stackexchange.com/questions/48908/java-implementation-of-spell-checking-algorithm
 */
public class Bucket {

    @SuppressWarnings("rawtypes")
	public Node first;

    @SuppressWarnings("rawtypes")
	public boolean get(String in) {         //return key true if key exists
        Node next = first;
        while (next != null) {
            if (next.data.equals(in)) {
                return true;
            }
            next = next.getNextNode();
        }
        return false;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void put(String key) {
        for (Node curr = first; curr != null; curr = curr.getNextNode()) {
            if (key.equals(curr.data)) {
                return;                     //search hit: return
            }
        }
        first = new Node(key, first); //search miss: add new node
    }
}

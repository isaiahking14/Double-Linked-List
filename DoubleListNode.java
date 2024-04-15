public class DoubleListNode {
    public int data;
    public DoubleListNode next; // link to next node
    public DoubleListNode previous; // link to previous node

    // post: constructs a node with data 0 and null link
    public DoubleListNode() {
        this(0, null, null);
    }

    // constructs a node with given data, and null for next and prev
    public DoubleListNode(int data) {
        this(data, null, null);
    }

    // constructs a node with given data, next, and previous
    public DoubleListNode(int data, DoubleListNode next, DoubleListNode previous){
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
}

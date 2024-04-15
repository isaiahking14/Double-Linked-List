import java.io.*;
import java.util.*;

public class DoubleLinkedList {
    private DoubleListNode front;

    public DoubleLinkedList() {
        front = null;
    }

    public void loadFromFile(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        if (front == null) {
            front = new DoubleListNode(scan.nextInt());
            while (scan.hasNextInt()) {
                DoubleListNode current = front;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new DoubleListNode(scan.nextInt());
                current.next.previous = current;
            }

        } else {
            while (scan.hasNextInt()) {
                DoubleListNode current = front;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new DoubleListNode(scan.nextInt());
                current.next.previous = current;
            }
        }
        scan.close();
    }

    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            DoubleListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new DoubleListNode(value, front, null);
        } else {
            DoubleListNode current = nodeAt(index - 1);
            current.next = new DoubleListNode(value, current.next, current);
            current.next.next.previous = current.next;
        }
    }

    public void add(int value) {
        DoubleListNode current = front;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new DoubleListNode(value, null, current);
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
            front.next.previous = null;
        } else {
            DoubleListNode current = nodeAt(index - 1);
            if (current.next != null) {
                current.next = current.next.next;
                current.next.next.previous = current.next;
            } else {
                current.previous.next = null;
            }

        }
    }

    public DoubleListNode linearSearch(int value) {
        DoubleListNode current = front;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void insertionSort() {
        DoubleListNode current = front.next;
        while (current != null) {
            if (current.data < current.previous.data) {
                while (current.previous != null) {
                    if (current.data < current.previous.data) {
                        int temp = current.previous.data;
                        current.previous.data = current.data;
                        current.data = temp;
                    }
                    current = current.previous;
                }
            }
            current = current.next;
        }
    }

    private DoubleListNode nodeAt(int index) {
        DoubleListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}

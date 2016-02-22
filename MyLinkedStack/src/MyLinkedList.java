import java.lang.Object;

public class MyLinkedList<T> extends Object {
    private MyLinkedNode<T> front;
    private int length;

    public MyLinkedList() {
        this.front = null;
        this.length = 0;
    }

    public void add (T value) {
        this.add(value, this.length);
    }

    public void add (T value, int index) {
        MyLinkedNode curr = indexOf(index);
        curr.setNext(new MyLinkedNode(value));
    }

    /**
     * Returns the node at a given index
     * @param index
     * @return MyLinkedNode that is at given index
     */
    private MyLinkedNode indexOf (int index) {
        MyLinkedNode curr = front;
        for (int i = 0; i < this.length; i++) {
            curr = curr.getNext();
        }
        return curr;
    }

    public String toString() {
        String ret = "[";
        MyLinkedNode curr = front;
        while (curr.getNext() != null) {
            ret += curr.getValue();
            ret += ", ";
        }
        return ret + curr.getValue() + "]";
    }
}
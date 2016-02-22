/**
 * Created by steven on 1/17/2015.
 */
/**
 * MyLinkedNode
 *
 * A node in the MyLinkedList class
 */
public class MyLinkedNode<T> extends Object {
    private MyLinkedNode next;
    private T value;

    /**
     * simply creates a new node
     */
    public MyLinkedNode() {
        this(null, null);
    }

    /**
     * Inserts the next node with no value
     * @param next
     */
    public MyLinkedNode(MyLinkedNode next) {
        this(null, next);
    }

    /**
     * Inserts a value with no next node
     * @param value
     */
    public MyLinkedNode(T value) {
        this(value, null);
    }

    /**
     * inserts a value and also the next node
     * @param value
     * @param next
     */
    public MyLinkedNode(T value, MyLinkedNode next) {
        this.next = next;
        this.value = value;
    }

    /**
     * Sets the next node of this node
     * @param next
     */
    public void setNext(MyLinkedNode next) {
        this.next = next;
    }

    /**
     * Sets the value for this node
     * @param value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * gets the value of the node
     * @return Object value
     */
    public T getValue() {
        return value;
    }

    /**
     * gets the next node
     * @return MyLinkedNode next
     */
    public MyLinkedNode getNext() {
        return next;
    }

}
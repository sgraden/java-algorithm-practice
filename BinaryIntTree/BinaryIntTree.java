package testing;

public class BinaryIntTree {
	
	private IntNode front;
	
	public BinaryIntTree() {
//		this.front = first;
		this.front = null;
	}
	
	public void addNode(int value) {
		front = addNodeHelper(value, front);
	}
	
	public IntNode addNodeHelper(int value, IntNode curr) {
		if (curr == null) {
			return new IntNode(value);
		} else if (value <= curr.data) {
			curr.left = addNodeHelper(value, curr.left);
		} else { //value > curr.data
			curr.right = addNodeHelper(value, curr.right);
		}
		return curr;
	}
	
	public void printTree() {
		System.out.println(printTreeHelper(front));
	}
	
	private String printTreeHelper(IntNode curr) {
		if (curr == null) {
			return "";
		} else  {
			return curr.data + ", " + printTreeHelper(curr.left) + printTreeHelper(curr.right);
		}
	}
	
	public void printTreeStack() {
		
	}
	
}

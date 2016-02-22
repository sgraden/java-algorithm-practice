package testing;

public class IntNode {
	
	public IntNode left;
	public IntNode right;
	public int data;
	
	public IntNode(int data) {
		this.data = data;
	}
	
	public IntNode(int data, IntNode left) {
		this.data = data;
		this.left = left;
	}
	
	public IntNode(int data, IntNode left, IntNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	
}

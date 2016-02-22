package testing;

public class BinaryIntTreeTest {

	public static void main(String[] args) {
		BinaryIntTree tree = new BinaryIntTree();
		
		tree.addNode(100);
		tree.addNode(80);
		tree.addNode(42);
		tree.addNode(70);
		tree.addNode(65);
		tree.addNode(90);
		tree.addNode(200);
		tree.addNode(150);
		
		tree.printTree();
		tree.printTreeStack();

	}

}

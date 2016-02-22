package testing;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueStack {

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.enqueue(18);
		q.enqueue(25);
		q.enqueue(72);
		System.out.println(q.printQueue());
		System.out.println(q.dequeue()); //18
		System.out.println(q.printQueue());
		q.enqueue(19);
		System.out.println(q.dequeue()); //25
		q.enqueue(16);
		q.enqueue(92);
		System.out.println(q.dequeue()); //72
		System.out.println(q.dequeue()); //19
		System.out.println(q.printQueue());
	}

	/**
	 *
	 * @author steven
	 *
	 * A FIFO queue maintained by a stack.
	 * Stack always keeps "first" element on top
	 */
	private static class MyQueue {

		private Stack<Integer> in;
		private Stack<Integer> out;

		public MyQueue() {
			in = new Stack<Integer>();
			out = new Stack<Integer>();
		}

		public void enqueue(int n) {
			in.push(n);
		}

		public int dequeue() {
			if (out.isEmpty() && in.isEmpty()) {
				throw new EmptyStackException();
			}
			if (out.isEmpty()) {
				flipStack(in, out);
			}
			return out.pop();
		}

		public int peek() {
			return in.peek();
		}

		public String printQueue() {
			return in.toString() + ", " + out.toString();
		}

		/**
		 * Moves elements of an Integer stack from stack start to stack end
		 * @param start - Stack to empty
		 * @param end - Stack to move to
		 */
		private void flipStack(Stack<Integer> start, Stack<Integer> end) {
			while (!start.isEmpty()) {
				end.push(start.pop());
			}
		}
	}

}

package testing;

import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(fibonacciTo(8));
		fibonacciTo(8);
		fibonacciTo(9);
		fibonacciTo(2);
		fibonacciTo(1);
		fibonacciTo(0);
		fibonacciTo(15);
		fibonacciTo(65); //1836311903
	}
	
	//0, 1, 1, 2, 3, 5, 8, 13
	public static void fibonacciTo(int n) {
		long[] a = new long[n];
		
		for (int i = 1; i < n; i++) {
			if (i == 1) {
				a[i] = 1;
			} else {
				a[i] = a[i - 1] + a[i - 2];
			}
			
			if (a[i] < 0) { // Overflowed
				throw new IllegalStateException();
			}
		}
		System.out.println(n + ": " + Arrays.toString(a));
	}
	
	

}

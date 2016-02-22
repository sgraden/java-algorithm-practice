package testing;

import java.util.Arrays;

public class MergeArray {

	public static void main(String[] args) {
		// 5, 5, 12, 14, 15, 22, 22, 23, 23, 23, 24, 24, 24, 24, 24, 26, 26, 28
		int[] a1 = {5, 14, 22, 23, 24, 24, 26};
		int[] a2 = {5, 12, 15, 22, 23, 23, 24};
		
		int[] b1 = {5, 14, 22, 23, 0, 0, 0};
		int[] b2 = {5, 12, 30};
		
		//mergeArrays(a1, a2);
		
		mergeArraysInPlace(b1, b2, 3);

	}
	
	public static void mergeArraysInPlace(int[] a1, int[] a2, int end) {
		int p = 0;
		int i = 0;
		//for (int i = 0; i < a1.length; i++) {
		while (i != a1.length && p != a2.length) {
			if (a2[p] < a1[i]) {
				if (end != a1.length) {
					for (int j = end; j >= i; j--) {
						a1[j + 1] = a1[j];
					}
				}
				a1[i] = a2[p];
				end++;
				p++;
			}
			i++;
		}
		System.out.println(Arrays.toString(a1));
	}
	
	public static void mergeArrays(int[] aa, int[] ba) {
		int[] merged = new int[aa.length + ba.length];
		int a = 0;
		int b = 0;
		
		for (int i = 0; i < merged.length; i++) {
			if (a != aa.length && b != ba.length) { // if more in both arrays
				if (aa[a] <= ba[b]) {
					merged[i] = aa[a];
					a++;
				} else if (ba[b] < aa[a]) {
					merged[i] = ba[b];
					b++;
				}
			} else if (a != aa.length && b == ba.length) { //if more in aa and no more in ba
				merged[i] = aa[a];
				a++;
			} else if (a == aa.length && b != ba.length) { //if more in ba and no more in aa
				merged[i] = ba[b];
				b++;
			}
		}
		
		System.out.println(Arrays.toString(merged));
	}

}

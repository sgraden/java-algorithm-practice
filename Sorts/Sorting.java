import java.util.*;


public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {5, 3, 9, 8, 7, -1, 0, 1, 2, 12, 31, 9};
		selectionSort(a);
		insertionSort(a);
		mergeSort(a);
		quickSort(a);
	}
	
	/*
	 * Best Case:	O(n^2)
	 * Avg Case:	O(n^2)
	 * Worst Case:	O(n^2)
	 */
	public static void selectionSort (int[] array) {
		int[] a = Arrays.copyOf(array, array.length);
		System.out.println("Selection Unsorted: " + Arrays.toString(a));
		int curr = 0;
		for (int n = 0; n < a.length; n++) {
			for (int m = curr + 1; m < a.length; m++) {
				if (a[m] < a[curr]) {
					int temp = a[m];
					a[m] = a[curr];
					a[curr] = temp; 
				}
			}
			curr++;
		}
		System.out.println("Selection Sorted: " + Arrays.toString(a));
	}

	/*
	 * Best Case:	O(n) already sorted
	 * Avg Case:	O(n^2) 
	 * Worst Case:	O(n^2) Reverse sorted
	 * 
	 * Great efficiency at sorting mostly sorted arrays and small arrays
	 * Often used in quick and merge sort under certain thresholds
	 * 
	 * More stable, no recursion, less memory than quick and merge (thats what makes it better on smaller sets)
	 * Has more writes than selection
	 */
	public static void insertionSort (int[] array) {
		int[] a = Arrays.copyOf(array, array.length);
		System.out.println("Insertion Unsorted: " + Arrays.toString(a));
		
		for (int n = 1; n < a.length; n++) {
			if (a[n] < a[n-1]) {
				insertionSwap(a, n);
			}
		}
		
		System.out.println("Insertion Sorted: " + Arrays.toString(a));
	}
	
	/*
	 * while the selected variable is less than the previous one:
	 * replace the current point with the previous one
	 */
	public static void insertionSwap (int[] a, int curr) {
		int swapVal = a[curr];
		
		//move elements and find point to insert swapVal
		while (curr > 0 && swapVal < a[curr - 1]) {
			a[curr] = a[curr - 1];
			curr--;
		}
		
		a[curr] = swapVal;
		
	}
	
	/*
	 * Best Case:	O(nlog(n))
	 * Avg Case:	O(nlog(n))
	 * Worst Case:	O(nlog(n))
	 * 
	 * Takes O(n) memory to complete
	 */
	public static void mergeSort (int[] array) {
		int[] a = Arrays.copyOf(array, array.length);
		System.out.println("Merge Unsorted: " + Arrays.toString(a));
		
		a = mergeHelper(a);
		
		System.out.println("Merge Sorted: " + Arrays.toString(a));
	}
	
	public static int[] mergeHelper (int[] a) {
		if (a.length == 1) {
			return a;
		} else {
			int[] first = Arrays.copyOfRange(a, 0, (a.length / 2));
			int[] last = Arrays.copyOfRange(a, (a.length / 2), a.length);
			return mergeArrays(mergeHelper(first), mergeHelper(last));
		}
	}
	
	public static int[] mergeArrays (int[] first, int[] last) {
		int[] a = new int[first.length + last.length];
		int countFirst = 0;
		int countLast = 0;
		for (int i = 0; i < a.length; i++) {
			if (countFirst < first.length && countLast < last.length) {
				if (first[countFirst] <= last[countLast]) {
					a[i] = first[countFirst];
					countFirst++;
				} else {
					a[i] = last[countLast];
					countLast++;
				}
			} else if (countFirst == first.length) {
				a[i] = last[countLast];
				countLast++;
			} else {
				a[i] = first[countFirst];
				countFirst++;
			}
		}
		return a;
	}
	
	/*
	 * Best Case:	
	 * Avg Case:	O(N log(N))
	 * Worst Case:	O(N^2) rare
	 * 
	 * Often faster in practice than other O(N log(N)) algorithms
	 * Sequential and localized memory references work well with a cache
	 * Efficient algorithms are not stable
	 * Can be implemented in place (O(LOG(N)) additional space)
	 */
	/*
	 * Choose a pivot
	 * Wall at 0
	 * If current is less than pivot switch element just right of the wall with current element. and increment the wall.
	 * After all values are placed recursive call the function for both sides of the wall.
	 */
	public static void quickSort (int[] array) {
		int[] a = Arrays.copyOf(array, array.length);
		System.out.println("Quick Unsorted: " + Arrays.toString(a));
		quickSortHelper(a, 0, a.length);
		System.out.println("Quick Sorted: " + Arrays.toString(a));
	}
	
	//int lo = first index of subset
	//int hi = last index of subset
	public static void quickSortHelper (int[] a, int lo, int hi) {
		if (hi - lo >= 2) { 
			int wall = lo + 1;
			int pivotIndex = lo;//choosePivot(a, lo, hi);
			int pivotValue = a[pivotIndex];
			
			for (int i = lo + 1; i < hi; i++) {
				if (a[i] <= pivotValue) {
					int temp = a[i];
					a[i] = a[wall];
					a[wall] = temp;
					wall++;
				}
			}
			a[pivotIndex] = a[wall - 1];
			a[wall - 1] = pivotValue;
			
			quickSortHelper(a, lo, wall - 1);
			quickSortHelper(a, wall, hi);
		}
	}
}

import java.util.*;

public class ArrayFlip {

	public static void main(String[] args) {
		int[] arr = randomArray();
		int[] flipped = flipArray(arr);
		System.out.println(isFlipped(arr, flipped));
		
	}
	
	/**
	 * fills an array with random numbers
	 * @return int[] of random numbers
	 */
	public static int[] randomArray() {
		Random r = new Random();
		int[] arr = new int[r.nextInt(100)];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(100);
		}
		
		System.out.println(Arrays.toString(arr));
		
		return arr;
	}
	
	/**
	 * Takes an array of int and flips it
	 * @param arr int[]
	 * @return a flipped array of numbers 
	 */
	public static int[] flipArray(int[] arr) {
		int[] flippedArr = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = flippedArr[i];
			flippedArr[i] = flippedArr[flippedArr.length - 1 - i];
			flippedArr[flippedArr.length - 1 - i] = temp;
		}
		
		System.out.println(Arrays.toString(flippedArr));
		
		return flippedArr;
	}
	
	public static boolean isFlipped(int[] arr1, int[] arr2) {
		if (arr1.length == arr2.length) {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[arr2.length - 1 - i]) {
					return false;
				}
			}
		}
		return true;
	}

}

package testing;

public class PrintMultiTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printTable(50);
	}

	public static void printTable(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(String.format("%6d", i * j));
			}
			System.out.println();
		}
	}
}

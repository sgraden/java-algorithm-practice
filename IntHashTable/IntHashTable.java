package testing;

import java.util.Arrays;

public class IntHashTable {
	private int[] table;
	private boolean[] isUsed;
	private static int[] SIZES = {11, 23, 47, 97, 191};
	private int currSize;
	private int load;
	
	public IntHashTable () {
		this.currSize = 0;
		this.table = new int[SIZES[currSize]];
		//Arrays.fill(this.table, -1);
		this.isUsed = new boolean[SIZES[currSize]];
		this.load = 0;
	}
	
	public void insert (int n) {
		resize();
		int hash = hash(n);
		//System.out.println("he");
		table[hash] = n;
		isUsed[hash] = true;
	}
	
	public boolean contains (int n) {

	}
	
	private int hash (int n) {
		int hash = n % SIZES[currSize];
		int quad = 2;
		while (isUsed[hash]) {
			hash = hash + (int) Math.pow(2, quad) % SIZES[currSize];
			quad++;
			if (hash >= SIZES[currSize]) {
				hash = 0;
			}
		}
		return hash;
	}
	
	private void resize () {
		System.out.println((double) load / SIZES[currSize]);
		if ((double) load / SIZES[currSize] >= .5) {
			int[] oldTable = table;
			boolean[] oldIsUsed = isUsed;
			currSize++;
			table = new int[SIZES[currSize]];
			isUsed = new boolean[SIZES[currSize]];
			for (int i = 0; i < oldTable.length; i++) {
				if (oldIsUsed[i]) {
					insert(oldTable[i]);
				}
			}
		}
	}
	
	public String print () {
		return Arrays.toString(table);
	}
}

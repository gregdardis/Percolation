import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	private boolean[][] open;
	private int virtualTop = 0;
	private int virtualBottom;
	private int gridSize;
	private int numberOpen;
	private WeightedQuickUnionUF UF;
	
	public Percolation(int n) {
	    gridSize = n;
	    virtualBottom = (gridSize * gridSize) + 1;
		open = new boolean[gridSize][gridSize];
		UF = new WeightedQuickUnionUF((gridSize * gridSize) + 2);
	}
	
	private int rowAndColumnTo1D(int row, int col) {
	    return row + (col - 1) * gridSize;
	}
	
	public void open(int row, int col) {
//	   if (open[row][col]) {
//	       return;
//	   } else {
//	       open[row][col] = true;
//	       // connect to neighbours
//	       numberOpen++;
//	   }
	    
	}
	
	public boolean isOpen(int row, int col) {
	    return open[row][col];
	}
	
	public boolean isFull(int row, int col) {
	    if (row > 0 && row <= gridSize && col > 0 && col <= gridSize) {
	        return UF.connected(virtualTop, rowAndColumnTo1D(row, col));
	    } else {
	        throw new IndexOutOfBoundsException();
	    }
	}
	
	public int numberOfOpenSites() {
//	    return numberOpen;
	}
	public boolean percolates() {
	    // does the system percolate?
	}
	public static void main(String[] args) {
	    // test client (optional)
	}
}

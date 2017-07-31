/**
 * This program solves the percolation problem. It keeps track of a 2D array of booleans
 * to see which grid slots are open, and when there is a path of open slots from the top of the grid to
 * the bottom, the method percolates() returns true and the number of open sites can be counted.
 * Useful for experiments to figure out what percentage of sites need to be open in order for the 
 * array to be guaranteed to be percolated. 
 */

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
	
	/**
	 * Converts 2D coordinates from the 2D array (1 indexed) to a 1D object index in the array.
	 * 
	 * @return 1D object index corresponding to the given spot in the 2D array
	 */
	private int rowAndColumnTo1D(int row, int col) {
	    return row + (col - 1) * gridSize;
	}
	
	/**
	 * Opens the square with the given row and column in the 2D array, and connects it to all 
	 * open squares that are touching it.
	 */
	public void open(int row, int col) {
	    if (!rowAndColumnInBounds(row, col)) {
	        throw new IndexOutOfBoundsException();
	    }
	    
	    if (isOpen(row, col)) {
	        return;
	    }
	    
	    open[row - 1][col - 1] = true;
	    numberOpen++;
	    
	    if (row == 1) {
	        UF.union(rowAndColumnTo1D(row, col), virtualTop);
	    } else if (row == gridSize) {
	        UF.union(rowAndColumnTo1D(row, col), virtualBottom);
	    }
	    
	    if (row > 1 && isOpen(row - 1, col)) {
	        UF.union(rowAndColumnTo1D(row, col), rowAndColumnTo1D(row - 1, col));
	    }
	    
	    if (row < gridSize && isOpen(row + 1, col)) {
	        UF.union(rowAndColumnTo1D(row, col), rowAndColumnTo1D(row + 1, col));
	    }
	    
	    if (col > 1 && isOpen(row, col - 1)) {
	        UF.union(rowAndColumnTo1D(row, col), rowAndColumnTo1D(row, col - 1));
	    }
	    
	    if (col < gridSize && isOpen(row, col + 1)) {
            UF.union(rowAndColumnTo1D(row, col), rowAndColumnTo1D(row, col + 1));
        }
	}
	
	/**
	 * @return True if the square corresponding to the given row/column is open, false otherwise.
	 */
	public boolean isOpen(int row, int col) {
	    return open[row - 1][col - 1];
	}
	
	/**
	 * @return  True if the square for the given row/column is connected to the top row by open squares, false otherwise.
	 */
	public boolean isFull(int row, int col) {
	    if (rowAndColumnInBounds(row, col)) {
	        return UF.connected(virtualTop, rowAndColumnTo1D(row, col));
	    } else {
	        throw new IndexOutOfBoundsException();
	    }
	}
	
	/**
	 * @return True if the given row and column are on the grid, false otherwise.
	 */
	private boolean rowAndColumnInBounds(int row, int col) {
	    return row > 0 && row <= gridSize && col > 0 && col <= gridSize;
	}
	
	/**
	 * @return  The number of sites that have been opened.
	 */
	public int numberOfOpenSites() {
	    return numberOpen;
	}
	
	/**
	 * @return True if the system percolates, false otherwise.
	 */
	public boolean percolates() {
	    return UF.connected(virtualTop, virtualBottom);
	}
}

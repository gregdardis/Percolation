import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    
    private int numTrials;
    private Percolation percolation;
    private double[] trials;
    
	public PercolationStats(int gridSize, int numTrials) {
	    if (gridSize <= 0 || numTrials <= 0) {
	        throw new IllegalArgumentException();
	    }
	    this.numTrials = numTrials;
	    trials = new double[numTrials];
	    
	    for (int i = 0; i < numTrials; i++) {
	        percolation = new Percolation(gridSize);
	        while(!percolation.percolates()) {
	            int row = StdRandom.uniform(1, gridSize + 1);
	            int col = StdRandom.uniform(1, gridSize + 1);
	            percolation.open(row, col);
	        }
	        double openSites = percolation.numberOfOpenSites();
	        double gridSquared = (gridSize * gridSize);
	        double trial = openSites / gridSquared;
	        trials[i] = trial;
	    }
	}
	
	   public double mean() {
		   return StdStats.mean(trials);
	   }
	   
	   public double stddev() {
		   return StdStats.stddev(trials);
	   }
	   
	   public double confidenceLo() {
		   return mean() - (1.96 * stddev() / Math.sqrt(numTrials));
	   }
	   
	   public double confidenceHi() {
	       return mean() + (1.96 * stddev() / Math.sqrt(numTrials));
	   }
	   
	   public static void main(String[] args) {
    	   int gridSize = Integer.parseInt(args[0]);
    	   int numTrials = Integer.parseInt(args[1]);
    	   
    	   PercolationStats percolationStats = new PercolationStats(gridSize, numTrials);
    
    	   String confidence = percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi();
    	   System.out.println("mean = " + percolationStats.mean());
    	   System.out.println("stddev = " + percolationStats.stddev());
    	   System.out.println("95% confidence interval = " + confidence);
	   }
}

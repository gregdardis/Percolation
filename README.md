***This is Assignment 1 from Princeton's Algorithms Part I course, made using Eclipse.***

# Description
This program models percolation which is found everywhere, from liquid seeping through openings to electricity going through conductors within insulation.  

The Percolation class uses weighted quick union union-find to connect adjacent open squares in a grid until the top row is connected to the bottom row of squares, or in other words, until the system percolates.   

The PercolationStats class utilizes the Percolation class to run a series of randomized trials on a grid  of the requested size. In these trials random squares will be opened until the system percolates, then statistics are given on the percentage of open squares in the grid at that point. PercolationStats can return the mean percentage of open squares over all of the trials, the standard deviation of that percentage, as well as a 95% confidence interval.  

The PercolationVisualizer class utilizes Percolation to show an animation of what is actually happening. The .png files in the testing folder show what the corresponding .txt file should output if ran with PercolationVisualizer. The PercolationVisualizer class was provided in the assignment details, I did not write it.

# Command Line Instructions
`cd src/`
## Windows:
  
Compile:  
 `javac -cp ".;../algs4.jar" *.java`  

Run Visualizer with test text file:  
 `java -cp ".;../algs4.jar" PercolationVisualizer ../testing/<txt-file-name>`  
 
Run with custom number of trials on custom grid size for statistics:  
`java -cp ".;../algs4.jar" PercolationStats gridSize numTrials`

## Mac:

Compile:  
 `javac -cp ".:../algs4.jar" *.java`

Run Visualizer with test text file:  
`java -cp ".:../algs4.jar" PercolationVisualizer ../testing/<txt-file-name>`  

Run with custom number of trials on custom grid size for statistics:  
`java -cp ".:../algs4.jar" PercolationStats <gridSize> <numTrials>`  





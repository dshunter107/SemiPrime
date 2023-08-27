package math;



import java.util.Arrays;


import org.apache.commons.math3.linear.*;


public class EigenVectors {

	public static void main(String[] args) {
		int i, j;
		double[][] startingMatrix = {{1,2,-1},{2,1,2} ,{-1,2,1}};
		int rows = startingMatrix.length;
		int cols = startingMatrix[0].length;
		int rowKept = 0;
		double [][] eigenvector = {{1, Math.atan(1),Math.atan(1)}};
		
		for(i = 1; i< cols ;i++) {
			for(j = 0; j < rows; j++) {
				startingMatrix[i][j] = startingMatrix[i][j] /startingMatrix[i][rowKept];
				startingMatrix[i][j] = Math.atan(startingMatrix[i][j]);
			}
		}
		
		RealMatrix realMatrix = new Array2DRowRealMatrix(startingMatrix);
		RealMatrix realEigen = new Array2DRowRealMatrix(eigenvector);
		
		realEigen = realEigen.multiply(realMatrix);
		
		
		
		
		System.out.println(realMatrix);
		System.out.println(realEigen);
	}

	
}

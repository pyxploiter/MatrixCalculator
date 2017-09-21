package MatrixCalculator;

import java.util.Scanner;
import java.util.Random;

public class MatrixCalc {
	public static void main(String[] args) {
		double[][] tempMatrix;
		
		Matrix matrix1 = createMatrix("A");
		Matrix matrix2 = createMatrix("B");
		//tempMatrix = scalarMultiplication(matrix1.getElements(), 5);
		//tempMatrix = transposeMatrix(matrix1.getElements());
		//tempMatrix = addMatrices(matrix1.getElements(), matrix2.getElements());
		//tempMatrix = subtractMatrices(matrix1.getElements(), matrix2.getElements());
		//tempMatrix = multiplyMatrices(matrix1.getElements(), matrix2.getElements());
		//tempMatrix = inverse(matrix1).getElements();
		for (int i =0; i<tempMatrix.length; i++) {
			for (int j=0; j<tempMatrix[0].length; j++) {
				System.out.print(tempMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//function to create matrix with random elements
	public static Matrix createMatrix(String name) {
		Random rand = new Random();
		int row, column, numMatrix;
		Scanner in = new Scanner(System.in);
		System.out.println("No of rows in matrix "+name+": ");
		row = in.nextInt();
		System.out.println("No of columns in matrix "+name+": ");
		column = in.nextInt();
		double[][] matElements = new double[row][column];
		
		//randomly populate elements of matrix
		for (int i=0; i<row; i++) {
			for (int j=0; j<column; j++) {
				matElements[i][j] = rand.nextInt(100); 
			}
		}
		
		Matrix mat = new Matrix(matElements);
		return mat;
	}
	
	//calculating addition of matrices
	public static double[][] addMatrices(double[][] matrix1, double[][] matrix2){
		boolean valid = validateAddSubtract(matrix1, matrix2);
		double[][] result = new double[matrix1.length][matrix1[0].length];
		if(valid){
			for(int i = 0; i < matrix1.length; i++){
				for(int j = 0; j < matrix1[0].length; j++){
					double elementM1 = matrix1[i][j];
					double elementM2 = matrix2[i][j];
					result[i][j] = elementM1 + elementM2;
				}
			}
		} else{
			System.out.println("Dimensions of Matrics should be same for Addition.");
		}
		return result;
	}
	
	//calculating subtraction of matrices
	public static double[][] subtractMatrices(double[][] matrix1, double[][] matrix2){
		boolean valid = validateAddSubtract(matrix1, matrix2);
		double[][] result = new double[matrix1.length][matrix1[0].length];
		if(valid){
			for(int i = 0; i < matrix1.length; i++){
				for(int j = 0; j < matrix1[0].length; j++){
					double elementM1 = matrix1[i][j];
					double elementM2 = matrix2[i][j];
					result[i][j] = elementM1 - elementM2;
				}
			}
		} else{
			System.out.println("Dimensions of Matrics should be same for Subtraction.");
		}
		return result;
	}
	
	//calculating scalar multiplication
	public static double[][] scalarMultiplication(double[][] matrix1, double scalar){
		double[][] result = new double[matrix1.length][matrix1[0].length];
		for(int i = 0; i < matrix1.length; i++){
			for(int j = 0; j < matrix1[0].length; j++){
				double elementM1 = matrix1[i][j];
				result[i][j] = elementM1 * scalar;
			}
		}
		return result;
	}
	
	//calculating transpose of matrix
	public static double[][] transposeMatrix(double[][] matrix) {
		double[][] transpose = new double[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				transpose[j][i] = matrix[i][j];
			}
		}
		return transpose;
	}
	
	//calculating the multiplication of two matrices
	public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2){
		boolean status = validateMultiplication(matrix1, matrix2);
		double sum = 0;
		double[][] result = new double[matrix1.length][matrix2[0].length];
		if(status == true){
			for (int c = 0 ; c < matrix1.length ; c++ )
	         {
	            for (int d = 0 ; d < matrix2[0].length ; d++ )
	            {   
	               for (int k = 0 ; k < matrix2.length ; k++ )
	               {
	                  sum = sum + matrix1[c][k]*matrix2[k][d];
	               }
	 
	               result[c][d] = sum;
	               System.out.print(sum+" ");
	               sum = 0;
	            }
	            System.out.println();
			}
		}else{
			System.out.println("Invalid Input");
		}
		return result;
	}
	
	//changing sign of integer
	public static int changeSign(int i) {
		return -1*i;
	}
	
	//calculating determinant of matrix
	public static double determinant(Matrix matrix) {
	    if (!matrix.isSquare())
	        System.out.println("Matrix is not square");
	    if (matrix.getNumRows() == 1) {
	    	return matrix.getElements()[0][0];
	    }
	    if (matrix.getNumRows() == 2) {
	        return (matrix.getElements()[0][0] * matrix.getElements()[1][1] - 
	                         ( matrix.getElements()[0][1] * matrix.getElements()[1][0]));
	    }
	    double sum = 0.0;
	    for (int i=0; i<matrix.getNumColumns(); i++) {
	        sum += changeSign(i) * matrix.getElements()[0][i] * determinant(createSubMatrix(matrix, 0, i));
	    }
	    return sum;
	} 
	
	//calculating submatrix which are used to find cofactors
	public static Matrix createSubMatrix(Matrix matrix, int excluding_row, int excluding_col) {
	    Matrix mat = new Matrix(matrix.getNumRows()-1, matrix.getNumColumns()-1);
	    int r = -1;
	    for (int i=0;i<matrix.getNumRows();i++) {
	        if (i==excluding_row)
	            continue;
	            r++;
	            int c = -1;
	        for (int j=0;j<matrix.getNumColumns();j++) {
	            if (j==excluding_col)
	                continue;
	            mat.setElement(r, ++c, matrix.getElements()[i][j]);
	        }
	    }
	    return mat;
	} 
	
	//calculating cofactor/adjoint of matrix
	public static Matrix cofactor(Matrix matrix) {
	    Matrix mat = new Matrix(matrix.getNumRows(), matrix.getNumColumns());
	    for (int i=0;i<matrix.getNumRows();i++) {
	        for (int j=0; j<matrix.getNumColumns();j++) {
	            mat.setElement(i, j, changeSign(i) * changeSign(j) * 
	                             determinant(createSubMatrix(matrix, i, j)));
	        }
	    }
	    
	    return mat;
	}
	
	//calculating inverse of matrix
	public static Matrix inverse(Matrix matrix){
		Matrix temp = new Matrix(matrix.getNumRows(),matrix.getNumColumns());
		temp = cofactor(matrix);
		temp.setMatrix(transposeMatrix(temp.getElements()));
		scalarMultiplication(temp.getElements(), (1.0/determinant(matrix)));
		return temp;
	}
	
	//validating matrix if they can be multiplied
	public static boolean validateMultiplication(double[][] matrix1, double[][] matrix2){
		boolean valid;
		int columns = matrix1[0].length;
		int rows = matrix2.length;
		if( columns == rows){
			valid = true;
		}else{
			valid = false;
		}
		return valid;
	}
	
	//validating matrix if they can be added or subtracted
		public static boolean validateAddSubtract(double[][] matrix1, double[][] matrix2){
			boolean valid;
			int numRows1 = matrix1.length;
			int numColumns1 = matrix1[0].length;
			int numRows2 = matrix2.length;
			int numColumns2 = matrix2[0].length;
			if(numRows1 == numRows2 && numColumns1 == numColumns2){
				valid = true;
			}else{
				valid = false;
			}
			return valid;
		}
}

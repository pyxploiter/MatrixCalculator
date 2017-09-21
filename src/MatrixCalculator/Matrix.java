package MatrixCalculator;

public class Matrix {
	private String name;
    private int nrows;
    private int ncols;
    private double[][] element;

    public Matrix() {
    	
    }
    public Matrix(double[][] data, String name) {
        this.element = data;
        this.nrows = data.length;
        this.ncols = data[0].length;
        this.name = name;
    }
    
    public Matrix(double[][] data) {
        this.element = data;
        this.nrows = data.length;
        this.ncols = data[0].length;
    }
    
    public Matrix(int rows, int cols) {
    	this.nrows = rows;
    	this.ncols = cols;
    	element = new double[rows][cols];
    }
    
    public boolean isSquare() {
    	if (nrows == ncols) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public int getNumRows() {
    	return nrows;
    }
    
    public int getNumColumns() {
    	return ncols;
    }
    
    public double[][] getElements() {
    	return element;
    }
    
    public void setMatrix(double[][] mat) {
    	element = mat;
    }
    
    public void setElement(int row, int col,double value) {
    	element[row][col] = value;
    }
	
	public void printMatrix() {
		System.out.println(name);
		for (int i=0; i<nrows; i++) {
			for (int j=0; j<ncols; j++) {
				System.out.print(element[i][j]+" ");
			}
			System.out.println();
		}
	}
}

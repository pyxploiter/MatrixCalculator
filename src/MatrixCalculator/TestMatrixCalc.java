package MatrixCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMatrixCalc {
	public MatrixCalc testCalc;
	@Test
	public void testAddMatrices() {
		double[][] expected = {{3,10},{6,4}};
		double[][] mat1 = {{2,3},{2,1}};
		double[][] mat2 = {{1,7},{4,3}};
		double[][] result = testCalc.addMatrices(mat1,mat2);
		assertArrayEquals(expected, result);
	}

	@Test
	public void testSubtractMatrices() {
		double[][] expected = {{1,-4},{-2,-2}};
		double[][] mat1 = {{2,3},{2,1}};
		double[][] mat2 = {{1,7},{4,3}};
		double[][] result = testCalc.subtractMatrices(mat1,mat2);
		assertArrayEquals(expected, result);
	}

	@Test
	public void testScalarMultiplication() {
		double[][] expected = {{10,-2},{6,10}};
		double[][] mat1 = {{5,-1},{3,5}};
		double[][] result = testCalc.scalarMultiplication(mat1, 2);
		assertArrayEquals(expected, result);
	}

	@Test
	public void testTransposeMatrix() {
		double[][] expected = {{5,3},{-1,5}};
		double[][] mat1 = {{5,-1},{3,5}};
		double[][] result = testCalc.transposeMatrix(mat1);
		assertArrayEquals(expected, result);
	}

	@Test
	public void testMultiplyMatrices() {
		double[][] expected = {{8,8},{8,8}};
		double[][] mat1 = {{2,2},{2,2}};
		double[][] mat2 = {{2,2},{2,2}};
		double[][] result = testCalc.multiplyMatrices(mat1,mat2);
		assertArrayEquals(expected, result);
	}

	@Test
	public void testChangeSign() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeterminant() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateSubMatrix() {
		fail("Not yet implemented");
	}

	@Test
	public void testCofactor() {
		fail("Not yet implemented");
	}

	@Test
	public void testInverse() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidateMultiplication() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidateAddSubtract() {
		
	}

}
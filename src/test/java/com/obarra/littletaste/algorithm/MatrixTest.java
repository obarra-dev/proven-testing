package com.obarra.littletaste.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testPrintMatched() {
		char matrix[][] = {{'o','m','a'},{'o','m','a'},{'o','m','a'}};;
		Matrix.printMatched(matrix, "oma");
	}

}

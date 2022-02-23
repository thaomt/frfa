package ThaoMT8_Assigment_Day03.Exercise_5;

import java.util.Scanner;

/**
 Create a class called 'Matrix' containing constructor that initializes the number of rows and number 
 of columns of a new Matrix object. The Matrix class has the following information:
1 - number of rows of matrix
2 - number of columns of matrix
3 - elements of matrix in the form of 2D array
 
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int values;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input rows: ");
		int rows=scanner.nextInt();
		System.out.println("Input colums: ");
		int colums=scanner.nextInt();
		Matrix matrix=new Matrix(rows, colums);
		int array[][]=new int[rows][colums];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<colums;j++) {
				System.out.println("Input element array["+i+"]["+j+"]: of matrix");
				matrix.Element(i,j,scanner.nextInt());
			}
		}
		System.out.println("Matrix "+rows+" rows "+colums+" colums: ");
		matrix.printMatrix();
		
	}

}

package ThaoMT8_Assigment_Day03.Exercise_5;

public class Matrix {
	private int rows;
	private int colums;
	private int array[][];
	public Matrix(int rows,int colums) {
		this.rows=rows;
		this.colums=colums;
		array=new int[rows][colums];
	}
	
	public void Element(int rows, int colums, int valueElement) {		
		array[rows][colums]=valueElement;	
	}
	public void printMatrix() {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<colums;j++) {
				System.out.print(array[i][j]+"	");
			}
			System.out.println();
		}
	}

	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColums() {
		return colums;
	}
	public void setColumns(int colums) {
		this.colums = colums;
	}

}

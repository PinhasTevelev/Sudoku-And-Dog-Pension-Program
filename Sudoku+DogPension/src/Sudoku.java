
import java.util.Scanner;

public class Sudoku {
	

	int[][] sudokuBoard;
	int size;

	public Sudoku() {
		Scanner c = new Scanner(System.in);
		boolean fcontinue = false;
		do {
			System.out.println("Enter Board Size:");
			this.size = c.nextInt();
			if(Math.sqrt(size)%1 == 0 && size != 1) {
				fcontinue = true;
			} else {
				System.out.println("Wrong Size , Enter again!");
			}
			
			
			
		} while (!fcontinue);
		sudokuBoard = new int[size][size];
		System.out.println("Enter values:");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sudokuBoard[i][j] = c.nextInt();
			}

		}
		printSudokuBoard();
	}

	private void printSudokuBoard() {
		for(int i = 0 ; i < sudokuBoard.length; i++)  {
			for(int j = 0 ; j < sudokuBoard[i].length ; j++) {
				System.out.print(sudokuBoard[i][j] + "  ");
				
			}
			System.out.println();
		}
		
		
	}

	private boolean isValidSodukoRow(int indexRow) {
		for (int i = 0; i < size; i++) {
			if (sudokuBoard[indexRow][i] > size) {
				return false;
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = (size - 1); j > i; j--) {
				if (sudokuBoard[indexRow][i] == sudokuBoard[indexRow][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValidSodukoCol(int indexCol) {
		for (int i = 0; i < size; i++) {
			if (sudokuBoard[i][indexCol] > size) {
				return false;
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = (size - 1); j > i; j--) {
				if (sudokuBoard[i][indexCol] == sudokuBoard[j][indexCol]) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValidSodukoQuadrant(int Qr, int Qc) {
		int newSize = (int) Math.sqrt(size);
		int newRow = Qr * newSize;
		int newCol = Qc * newSize;
		int[] checkArr = new int[size];
		for (int i = newRow, k = 0; i < (newSize + newRow); i++) {
			for (int j = newCol; j < (newSize + newCol); j++) {
				checkArr[k++] = sudokuBoard[i][j];

			}

		}
		for (int i = 0; i < checkArr.length; i++) {
			if (checkArr[i] > size) {
				return false;
			}
		}

		for (int i = 0; i < checkArr.length; i++) {
			for (int j = (checkArr.length - 1); j > i; j--) {
				if (checkArr[i] == checkArr[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public int[][] getSudokuBoard() {
		return sudokuBoard;
	}

	public void setSudokuBoard(int[][] sudokuBoard) {
		this.sudokuBoard = sudokuBoard;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean checkSudoku() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (isValidSodukoRow(i) != false) {
					if(isValidSodukoCol(j) != false) {
						if(isValidSodukoQuadrant(i, j) != false) {
							return true;
						}
					}
				}
			}
		}
		return false;
		
	}

}

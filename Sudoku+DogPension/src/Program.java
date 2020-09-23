/* ID: 204424543
 * NANE: Pinhas Tevelev
*/

import java.util.Scanner;

public class Program {
	public static void cageTest() {
		CageTest.testCage();
	}
	public static void dogPension() {
		DogHouseTest.testDogPension();	
	}
	
	public static void checkSudoku() {
		Sudoku game = new Sudoku();
		boolean ok = game.checkSudoku();
		if (!ok) {
			System.out.println("Not a valid Sudoku");
		} else {
			System.out.println("A valid Sudoku");
		}
	}
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int choice = 0;
		while (choice != -1) {
			System.out.println("Choose a program");
			System.out.println("1 - Sudoku");
			System.out.println("2 - Dog Pension");
			System.out.println("-1 - To Exit");
			choice=s.nextInt();

			switch (choice) {
			case 1:
				checkSudoku();
				break;
			case 2:
				dogPension();
				break;
			case -1:
				System.out.println("Good Bye!!!");
				break;
			default:
				System.out.println("invalid input");
				break;
			}
		}
		s.close();
	}
}
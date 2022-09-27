
import java.util.Scanner;

class Main {
	static int[][] arr = new int[9][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		sudoku(0, 0);

		// 출력
		for (int[] i : arr) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static void sudoku(int row, int col) {

		// 줄바꿈 부분
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}

		// 출력부분 [9,0]에서 걸리게됨 [8,8]까지임
		if (row == 9) {
			for (int[] i : arr) {
				for (int j : i) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}

		// 1~9까지 가능한 수 탐색
		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (posible(row, col, i)) {
					arr[row][col] = i;
					sudoku(row, col + 1);
				}
			}
		
			arr[row][col] = 0; // 인대도 끝까지 다돌았다? 그럼 다시 0
			return;
		}

		// arr[row][col] != 0 이라면 다음자리 탐색
		sudoku(row, col + 1);

	}

	private static boolean posible(int x, int y, int k) {

		// 행검사
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] == k) {
				return false;
			}
			if (arr[i][y] == k) {
				return false;
			}
		}

		// 사각형 검사
		int positionX = (x / 3) * 3;
		int positiony = (y / 3) * 3;
		for (int i = positionX; i < positionX + 3; i++) {
			for (int j = positiony; j < positiony + 3; j++) {
				if (arr[i][j] == k) {
					return false;
				}
			}
		}
		return true;
	}

}


import java.util.Scanner;

public class Main {

	static char[][] arr; // 별이 들어갈 공간

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//print로 하면 시간 초과가 나기 때문에 stringBuilder를 사용한다. 
		StringBuilder sb = new StringBuilder();
		
		//크기 입력 받기, 크기는 3^k(k >= 1) 이다. 
		int N = sc.nextInt();
		arr = new char[N][N];
		
		//시작값과 사이즈 입력
		star(0, 0, N);

		//출력 
		for (char[] a : arr) {
			for (char b : a) {
				sb.append(b);
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	//별찍기 함수 
	static void star(int x, int y, int size) {
		//더 나눌 수 없는 사이즈가 되면 별찍기 
		if (size == 1) {
			arr[x][y] = '*';
			return;
		}

		//사이즈 감소 
		size = size/3;
		
		//0~size 까지 같은 도형을 3번 그려야 한다. 
		//때문에  i += size를 해줘서 for문이 3번 돌아가도록 한다. 
		for (int i = x; i < x + size*3; i+=size) {
			for (int j = y; j < y + size*3; j+=size) {
				
				//중앙값 찾기 
				if (i == (x+size) && j == (y+size)) {
					//중앙 값이면 (i,j) 위치부터 size만큼 빈칸이 생성되어야함 
					blank(i, j, size);
				} else {
					//벌찍기 함수.
					star(i, j, size);
				}
			}
		}
	}

	// size만큼 빈칸 만드는 함수
	static void blank(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = ' ';
			}
		}
	}
}

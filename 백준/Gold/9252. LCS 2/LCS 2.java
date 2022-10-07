import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String Astr = br.readLine();
		String Bstr = br.readLine();
		
		int Alen = Astr.length();
		int Blen = Bstr.length();

		// 배열 만들기
		int[][] dp = new int[Blen + 1][Alen + 1];

		// 문자열 배열
		for (int i = 1; i <= Alen; i++) {
			for (int j = 1; j <= Blen; j++) {
				if (Astr.charAt(i - 1) - '0' == Bstr.charAt(j - 1) - '0') {
					dp[j][i] = dp[j - 1][i - 1] + 1; // 둘이 같으면 대각선에 있는 값 +1
				} else {
					dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]); // 둘이 다르면 아래위에 있는놈 비교해서 제일 큰거 넣기
				}
			}
		}


 
		// 부분수열 담아둘 큐
		Stack<Character> s = new Stack<>();
		// 초기값 설정
		int i = Blen;
		int j = Alen;

		while (s.size() != dp[Blen][Alen]) { // q배열이 부분수열의 길이와 같아지면 종료
			if (Astr.charAt(j - 1) == Bstr.charAt(i - 1)) {
				s.add(Astr.charAt(j - 1));
				// 찾았으면 대각선으로 이동함
				i--;
				j--;
			} else { // 같은 값이 아니면 바로 왼쪽으로 이동하고 한번 맞는지 확인함
					if(dp[i][j] == dp[i][j-1]) { // 왼쪽이랑 같으면 이동
						j--;
					}else { // 왼쪽이랑 같지 않으면 아래로 이동 
						i--;
					}
				
			}
		} // end while

		System.out.println(dp[Blen][Alen]);
		while (!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}
}
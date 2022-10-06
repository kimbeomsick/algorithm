import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int day = Integer.parseInt(st.nextToken());
		int value= Integer.parseInt(st.nextToken());
		
		int dp[] = new int[day];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2;i<day;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		x : for(int i = 1;i<=100000;i++) {
			for(int j = i;j<=100000;j++) {
				if(dp[day-2]*i + dp[day-1]*j == value) {
					System.out.println(i);
					System.out.println(j);
					break x ;
				}
			}
		}
		
	}
}

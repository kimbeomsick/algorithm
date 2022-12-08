import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] map, dp;
	static int N;
	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[N][(1 << N) - 1]; // [지금선택한것][이전까지 선택한것의 집합]
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		 

		// dp초기화
		for (int[] d : dp) {
			Arrays.fill(d, INF);
		}

		System.out.println(dfs(0, 1));
	}

	private static int dfs(int node, int visited) {
		// TODO Auto-generated method stub

		if (visited == (1 << N) - 1) {
			if (map[node][0] == 0) {
				return INF;
			}
			return map[node][0];
		}

		if (dp[node][visited] != INF) {
			return dp[node][visited];
		}

		for (int i = 0; i < N; i++) {
			if (((visited & (1 << i)) == 0) && map[node][i] != 0) {
				// 내가 앞으로 갈 수 있는 거리중에 가장 작은것을 고른다
				dp[node][visited] = Math.min(dp[node][visited], dfs(i, visited | (1 << i)) + map[node][i]);
			}
		}

		return dp[node][visited];
	}
}
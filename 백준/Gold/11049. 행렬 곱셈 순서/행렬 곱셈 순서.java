import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int r, c;
    static int[][] map;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][2];
        dp = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map[i][0] = r;
            map[i][1] = c;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

        }
        for (int c = 1; c < N; c++) {  //가로
            for (int i = 0; i < N - c ; i++) { // 세로
                calc(i, i + c);
            }
        }
        System.out.println(dp[0][N-1]);

    }

    // start 행렬과 end 행렬의 곱을 정하려 한다.
    private static void calc(int start, int end){ // 0, 4
        for(int i = start; i<end;i++){ // start 2, end 4
            // i = 0 : dp[0][0] + ap[1][4] + map[0][0] * map[0][1] * map[4][1];
            // i = 1 : dp[0][1] + ap[1][4] + map[0][0] * map[1][1] * map[4][1];
            // i = 2 : dp[0][2] + ap[2][4] + map[0][0] * map[2][1] * map[4][1];
            // i = 3 : dp[0][3] + ap[3][4] + map[0][0] * map[3][1] * map[4][1];
            int cost = dp[start][i] + dp[i+1][end] + map[start][0] * map[i][1] * map[end][1];
            dp[start][end] = Math.min(dp[start][end], cost);
        }
    }
}
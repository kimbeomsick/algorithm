import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long dp[][] = new long[201][201];

        Arrays.fill(dp[1],1); // 1로 전부 정렬함

        for(int i = 2;i<=200;i++){
            dp[i][0] = 1;
            for(int j = 1;j<=200;j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000;
            }
        }

        System.out.println(dp[K][N]);
    }

}
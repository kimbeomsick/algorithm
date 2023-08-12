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

        long [] dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4;i<=1000000;i++){
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
        }

        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            System.out.println(dp[a]);
        }

    }

}
import java.util.*;

/**
 * 1. dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
 */

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int dp[] = new int[100];
        for (int t = 1; t <= tc; t++) {
            int N = sc.nextInt();
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;

            for(int i = 4;i <= N;i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            System.out.println(dp[N]);
        }

    }
}

import java.util.*;


class Solution {
    public int solution(int n) {
        
        
        int dp[] = new int[n+10];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 8;
        for(int i = 3;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
import java.util.*;

class Solution {
    static int INF = 1234567;
    static Long answer = 0L;
    public long solution(int n) {
        
        
        if(n <=2){
            return (long)n;
        }
        
        Long dp[] = new Long[n+1];
        
        dp[1] = 1l;
        dp[2] = 2l;
        
        for(int i = 3;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%INF;
        }
        
        
        
        return dp[n];
    }
    

}
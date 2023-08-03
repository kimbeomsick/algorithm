class Solution {
    static int INF = 1000000007;
    public int solution(int n) {
        
        if(n%2 != 0){
            return 0;
        }
        
        long dp[] = new long[50001];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;
        dp[4] = 11;
        
        for(int i = 4;i<=n;i+=2){
            dp[i] = (dp[i-2]*3)%INF;
            for(int j = i-4;j>=0;j-=2){
                dp[i] += (dp[j]*2)%INF;
            }
            dp[i] %= INF;
        }
        return (int)(dp[n]%INF);
    }
}
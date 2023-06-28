class Solution {
    
    static int result = 0;
    public int solution(int n) {
        
        
        for(int i = 1;i<=n;i++){
            int sum = 0;
            for(int j = i;j<=n;j++){
                sum += j;
                
                // System.out.printf("i:%d,  sum:%d\n",i,sum);
                
                if(sum > n)break;
                if(sum == n){
                    result++;
                    break;
                }
            }
        }
        
        
        return result;
    }

}
        
     
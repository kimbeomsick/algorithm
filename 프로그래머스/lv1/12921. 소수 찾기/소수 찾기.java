class Solution {
    
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 3;i <= n;i++){
            if(func(i)){
                
                answer++;
            }
        }
        
        return answer;
    }
    
    public static boolean func(int num){
        
        int cnt = 0;
        for(int i = 2 ; i*i <= num ;i++){ // 1은 너무 자명한거라 빼버림
            if(num%i == 0){
                return false;
            }
            
            if(i*i == num){
                return false;
            }
        }
        
        return true;
    }
}
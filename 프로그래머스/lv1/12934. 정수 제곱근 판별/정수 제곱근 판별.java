class Solution {
    public long solution(long n) {
        long answer = 0;
        
        if(Math.pow((int)Math.sqrt(n),2) == n){
            answer = (int)Math.sqrt(n)+1;
            answer *= answer;
        }else{
            return -1;
        }
        
        return answer;
    }
}
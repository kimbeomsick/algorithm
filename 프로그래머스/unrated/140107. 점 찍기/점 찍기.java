import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long c = (long)Math.pow((double)d/k,2);
        
        for(int i = 0;i<=d/k;i++){
            long a =(long)Math.pow(i,2);
            answer += (int)(Math.sqrt(c-a))+1;
        }
        
        return answer;
    }
}
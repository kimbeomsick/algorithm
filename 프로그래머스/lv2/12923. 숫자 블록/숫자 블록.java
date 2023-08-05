import java.util.*;

// 0을 다른걸로 변경함 


class Solution {
    public int[] solution(long begin, long end) {
        
        int idx = 0;
        int[] answer = new int[(int)(end-begin+1)];
        for(int i = (int)begin ; i <= (int)end ;i++){
            answer[idx++] = prime(i);
        }
       
        
        
        
        return answer;
    }
    
    static public int prime(int num){
        if(num == 1) return 0;
        
        int result = 1;
        for(int i = 2;i*i<=num;i++){
            
             if(num%i == 0 && i <= 10000000){
                 if(num/i <= 10000000){ //나눈수가 이거보다 작으면 반환이야~
                     return num/i;
                 }
                 result = Math.max(result, i);
             }
        }
        
        return result;
    }
}
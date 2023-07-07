
import java.util.*;

// 1. 두개의 누적합을 사용하자 

class Solution {
    static long start_plus[];
    static long start_minus[];
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        int size = sequence.length;
        int mul = 1;
        
        start_plus = new long[size];
        start_minus = new long[size];
        
        start_plus[0] = (-1)*sequence[0];
        start_minus[0] = sequence[0];
        
        answer = Math.max(start_plus[0], start_minus[0]);
        //음수로시작, 양수로 시작하는 누적합 배열
        for(int i = 1;i<size;i++){
            
            start_minus[i] = Math.max((-1)*mul*sequence[i] +start_minus[i-1] ,  (-1)*mul*sequence[i]);
            start_plus[i] = Math.max(mul*sequence[i] +start_plus[i-1] ,  mul*sequence[i]);
            
            mul *= -1; //+- 반전
            
            answer = Math.max(answer, Math.max(start_plus[i], start_minus[i]));
        }
        
        
    
        
        return answer;
    }
}

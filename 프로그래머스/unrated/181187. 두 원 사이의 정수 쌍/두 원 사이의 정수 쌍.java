import java.util.*;

//1사분면 구하고 4배하면 됨 
// x = 1에서 r2보다 작을 때까지 증가 
// 여기서 x = 1~r2일 때 y의 최대값과 최소값 구하기 
// + (r2-r1+1)*4

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(long i = 1;i<=r2;i++){
            long b =  (long)Math.floor(Math.sqrt((i+r2)*(r2-i))); // 바깥원의 최소값
            long a = r1-i < 0 ? (long)0.0 : (long)Math.ceil(Math.sqrt((i+r1)*(r1-i))); // 안쪽원의 최대값 
            answer += b-a+1;
        }
        
        
        return answer*4;
    }
}
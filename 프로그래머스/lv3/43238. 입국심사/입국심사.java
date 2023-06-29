import java.util.*;

// 1. 시간이 주어지면 최대 몇명까지 검사할 수 있는지 알 수 있다. 
// 2. 최대시간 최소시간을 기준으로 이분탐색을 한다. 
// 3. n명을 검사할 수 있는 최소시간을 찾자 

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        //시간순으로 정렬
        Arrays.sort(times);
        
        //이분탐색이니까 일부러 말도 안되게 잡음 
        long right = times[times.length-1]*(long)n; // 최대로 많이 걸리는시간
        long left = 0; // 최소시간
        
        
        while(left+1 < right){
            long mid = (right+left)/2; //중앙값
            
            long sum = 0; // 현제 mid의 시간으로 몇명까지 검사할 수 있는지 확인
            for(int i = 0;i<times.length;i++){
                long num = mid/times[i];
                // num == 0 이 뒤로도 다 0이기 때문에 할 필요가 없다. 
                // sum을 계속 더하다 보면 오버 플로우가 날수 있기 때문에 sum > 0 하면 탈출 
                if(num == 0 || sum > n) {
                    break;
                }else{
                    sum+= num; // 검사한 사람 횟수 더해주기
                }
            }
            
            if(n <= sum){ 
                right = mid;
            }else{
                left = mid;
            }
        }
        
        return right;
    }
}
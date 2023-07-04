import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        long sum1 = 0;
        long sum2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        
        for(int i = 0;i<queue1.length;i++){
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        long first_sum1 = sum1;
        long first_sum2 = sum2;
        
        //홀수면 정확히 둘로 나누는게 안됨
        if((sum1+sum2)%2 == 1){
            return -1;
        }
        
        long collect = (long)(sum1+sum2)/2;
        
        int cnt = 0;
        while(++cnt < queue1.length*3){
            if(sum1 > sum2){
                int num = q1.poll();
                sum2 += num;
                sum1 -= num;
                q2.offer(num);
            }else if(sum1 < sum2){
                int num = q2.poll();
                sum1 += num;
                sum2 -= num;
                q1.offer(num);
            }else{
                return cnt-1;
            }
            
            
            
        }
        
        
        return -1;
    }
}
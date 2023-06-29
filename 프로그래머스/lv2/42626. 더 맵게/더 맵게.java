import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int s : scoville){
            pq.add(s);
        }
        
        
        while(!pq.isEmpty()){
            int first = pq.peek();
            
            if(first >= K) {
                return answer;
            };
            
            if(pq.size() >= 2){
                first = pq.poll();
                int second = pq.poll();
                pq.add(first+(second*2));
                answer++;
            }else{
                break;
            }
 
        }
        
        return -1;
    }
}
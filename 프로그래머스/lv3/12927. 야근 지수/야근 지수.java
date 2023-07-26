import java.util.*;



class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i= 0;i<works.length;i++){
           
            pq.add(works[i]);
        }
        
        
        
        for(int i = 0;i<n;i++){
            int num = pq.poll();
            // System.out.println(num+"->"+(num-1));
            pq.add(num-1);
        }
        
        for(int i = 0;i<works.length;i++){
            int num = pq.poll();
            System.out.println(num);
            
            answer+= num <=0 ? 0:Math.pow(num,2);
        }
        return answer;
    }
}
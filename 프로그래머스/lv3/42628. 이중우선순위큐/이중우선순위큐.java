import java.util.*;



class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
            
        for(String operation : operations){
            
            String order = operation.split(" ")[0];
            int num = Integer.parseInt(operation.split(" ")[1]);
            
            // System.out.printf("order:%s, num:%d \n",order, num);
            
            if(order.equals("I")){ //넣기
                pq.add(num);
            }
            
            
            if(!pq.isEmpty()){
                 if(order.equals("D")){ //삭제
                if(num == -1){
                    pq.poll(); // 최소값 삭제
                }
                
                if(num == 1){ // 최대값 삭제 
                    pq.remove(lastValue(pq));
                }
            }
            }

            
        }
        
        if(pq.isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{lastValue(pq), pq.peek()};
        }
        
  
    }
    
    public static int lastValue(PriorityQueue<Integer> pq){
        PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
        
        int last_value = 0;
        while(!temp.isEmpty()){
            last_value = temp.poll();
        }
        
        return last_value;
    }
}
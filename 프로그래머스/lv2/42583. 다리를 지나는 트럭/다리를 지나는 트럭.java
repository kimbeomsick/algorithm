import java.util.*;

class Solution {
    static Queue<Integer> q = new LinkedList<>();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        
        for(int i = 0;i<bridge_length;i++){
            q.add(0);
        }
        int bridge_weight = 0;
        int after_bridge = 0; // 건넌 자동차 수 
        int idx = 0;
        
        while(after_bridge != truck_weights.length){ //트럭이 다 나올때까지 돔
            int out = q.poll();
            if(out != 0 ){
                after_bridge++; // 나온게 트럭이면 나온트럭 수 증가
            }
            bridge_weight -= out;
            
            //트럭이 남았고, 다리 하중에 여유가 있다면
            if(idx < truck_weights.length &&bridge_weight + truck_weights[idx] <= weight){
                q.add(truck_weights[idx]); // 트럭 넣기
                bridge_weight += truck_weights[idx]; //무게 추가
                idx++;
            }else{
                q.add(0);
            }
            answer++;
        }
        
        
        return answer;
    }
    

}
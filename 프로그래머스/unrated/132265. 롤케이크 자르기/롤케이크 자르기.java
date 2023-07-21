
import java.util.*;

// 1. 동일한 토핑이 있으면 공평하게 롤케이크를 나눴다고 할 수 있다. 
// 2. 토핑의 가지수로 차이를 나누게 된다. 


class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> left = new HashMap<>() ;
        HashMap<Integer, Integer> right = new HashMap<>(); 
        int left_cnt = 0;
        int right_cnt = 0;
        
        // 일단 right에게 몰아줌
        for(int i = 0;i<topping.length;i++){
            left.put(topping[i],0);
            
            if(right.containsKey(topping[i])){
                right.put(topping[i],right.get(topping[i])+1);
            }else{
                right_cnt++;
                right.put(topping[i],1);
            }
        }
        
        //i를 기준으로 나눠보자 
        
        for(int i = 0;i<topping.length;i++){
            
            // right에서 꺼냄
            if(right.get(topping[i]) == 1){
                right_cnt--;
            }
             right.put(topping[i], right.get(topping[i])-1);
            
            // left에 집어 넣음 
             if(left.get(topping[i]) == 0){
                left_cnt++;
            }
             left.put(topping[i], left.get(topping[i])+1);
            
            if(right_cnt == left_cnt){
                answer++;
            }
            // 둘이 같은지 확인
        }
        
        
        return answer;
    }
}
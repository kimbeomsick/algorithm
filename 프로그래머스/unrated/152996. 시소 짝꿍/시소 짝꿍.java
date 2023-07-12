import java.util.*;

class Solution {
    
    static Map<Double, Integer> map = new HashMap<>();
    public long solution(int[] weights) {
        long answer = 0;
        
    
        Arrays.sort(weights);
        
        for(int i = 0;i<weights.length;i++){
            double a = weights[i];
            double b = weights[i]*2.0 / 3.0;
            double c = weights[i]/ 2.0;
            double d = weights[i]*3.0 / 4.0;
            
            
            if(map.containsKey(a)) answer += map.get(a); // 나와 짝꿍이 될수 있는자 추가함
            if(map.containsKey(b)) answer += map.get(b); // 나와 짝꿍이 될수 있는자 추가함
            if(map.containsKey(c)) answer += map.get(c); // 나와 짝꿍이 될수 있는자 추가함
            if(map.containsKey(d)) answer += map.get(d); // 나와 짝꿍이 될수 있는자 추가함
            
            map.put((double)weights[i],map.getOrDefault((double)weights[i],0)+1);
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    static HashMap<String,Integer> map = new HashMap<>();
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int len = Integer.MAX_VALUE;
        
        for(int i = 0;i<gems.length;i++){
            String gem = gems[i];
                map.put(gem,0);    // 0 으로 초기화
        }
        int zero = map.size(); // 0인것의 갯수 
        
        int start = -1;
        int end = -1;
        while(true){
            if((start == gems.length-1 && end == gems.length-1) || (start > end)) break;
            if(zero == 0){ // 다 들어있니?
                if(end-start < len){
                    // System.out.printf("%d,%d \n",start+1+1,end+1);
                    len = end-start;
                    answer[0] = start+2; //초과라서 +2
                    answer[1] = end+1;
                }
                
                //지금 값 저장하기 
                start++;
                map.put(gems[start],map.get(gems[start])-1);
                if(map.get(gems[start]) == 0){
                    zero++;
                }
                }else{
                if(end == gems.length-1){
                    start++;
                    map.put(gems[start],map.get(gems[start])-1);
                    if(map.get(gems[start]) == 0){
                    zero++;
                }
                }else{
                    end++;
                    map.put(gems[end],map.get(gems[end])+1);
                    if(map.get(gems[end]) == 1){
                    zero--;
                }
                }
                    
            }
                
            
        }
        return answer;
    }
}
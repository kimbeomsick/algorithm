import java.util.*;

//초기 성격 유형
class Solution {
        
    
    
    public String solution(String[] survey, int[] choices) {
        //각 유형의 점수를 담을 map
    HashMap<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        
        char[][] types = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        
        for(int i = 0;i<survey.length;i++){
            char ch;
            int value = choices[i] - 4; //선택한 값 출력 
            
            // 0이면 점수 없음
            if(value == 0) continue;
            
            //음수면 왼쪽
            if(value < 0 ){
                ch = survey[i].charAt(0);
                int num = map.get(ch);
            map.put(ch,num-value);
                
            }
            
            //양수면 오른쪽
            if(value > 0){
                ch = survey[i].charAt(1);
                int num = map.get(ch);
            map.put(ch,num+value);
            }
            
            
        }
        
        //정답을 담기위한 stirngbuilder
        StringBuilder sb = new StringBuilder();
        
        
        for(int i = 0;i<4;i++){
            char left = types[i][0];
            char right = types[i][1];
            
            //점수가 더 큰 성격 저장하기 
            if(map.get(left) >= map.get(right)){ // 없을 수도 있음 
                sb.append(left);
            }else{
                sb.append(right);
            }   
        }
        
        return sb.toString();
    }

}
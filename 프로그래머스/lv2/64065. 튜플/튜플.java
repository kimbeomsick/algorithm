import java.util.*;


// 1. 순서를 따르는 요소 
// 2. 중복 가능, 순서가 다르면 다른거임, 원소의 개수는 유한함 

class Solution {
    
    
    public int[] solution(String s) {
        int[] answer;
        
        String[] strArr = s.replace("{{","").replace("}}","").replace("},{","-").split("-");
        Arrays.sort(strArr,(a,b)->{
            return a.length() - b.length();
        });
        
 
        int len = strArr.length;
        Set<Integer> set = new HashSet<>(); // 중복 확인하기 
        answer = new int[len]; // 전체 크기 
        for(int i = 0;i<len;i++){
            String sArr[] = strArr[i].split(",");
            for(int j = 0;j<sArr.length;j++){
                int num = Integer.parseInt(sArr[j]);
                if(set.contains(num)){
                    continue;
                }else{
                    set.add(num);
                    answer[i] = num;
                    break; // 넣었으니 퇴출 ! 
                }
            }
        }
        
        
        
        return answer;
    }
}
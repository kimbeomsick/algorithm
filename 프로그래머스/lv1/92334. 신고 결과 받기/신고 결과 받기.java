import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        
        HashMap<String, Set<String>> info  = new HashMap<>();
        HashMap<String, Integer> result  = new HashMap<>();
        
        //신고 받는 배열 생성
        for(int i = 0;i<id_list.length;i++){
            String name = id_list[i];
            result.put(name,0); //내가 신고한 사용자가 정지 받았을 경우
            info.put(name, new HashSet<String>()); // 나를 신고한 사람들 
        }
        
        //신고 스택 쌓기
        for(int i = 0 ;i<report.length;i++){
            String[] strArr = report[i].split(" ");
            info.get(strArr[1]).add(strArr[0]);
        }
        
        
        
        for(int i = 0;i<id_list.length;i++){
            int size = info.get(id_list[i]).size(); //신고받은 횟수
            
            if(size >= k){ //신고를 k번이상 받았다면 
            Set<String> list = info.get(id_list[i]); //나를 신고한 사람 리스트
                for(String name : list){
                    int num = result.get(name); 
                    result.put(name, num+1); //신고한 사람이 정지되었다고 알려줌
                }
            }
        }
        
        
        
        int[] answer = new int[id_list.length];
        for(int i = 0;i<id_list.length;i++){
            String name = id_list[i];
            int value = result.get(name);
            
            answer[i] = value;
        }
        
        
        
        
        
        return answer;
        
    }
}
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Queue<String[]> q = new LinkedList<>();
        Map<String, String> map = new HashMap<>();
        for(int i = 0;i<record.length;i++){
            String[] strArr = record[i].split(" ");

                    
            switch(strArr[0]){
                case "Enter":
                    q.offer(new String[]{strArr[1],"Enter"});
                    map.put(strArr[1],strArr[2]);
                    break;
                case "Change":
                    map.put(strArr[1],strArr[2]);
                    break;
                case "Leave":
                    q.offer(new String[]{strArr[1],"Leave"});
                    break;
            }
        }
        String[] answer = new String[q.size()];
        int len = q.size();
        for(int i = 0;i<len;i++){
            String[] strArr = q.poll();
            if(strArr[1].equals("Leave")){
                answer[i] = map.get(strArr[0])+"님이 나갔습니다.";
            }
            if(strArr[1].equals("Enter")){
                answer[i] = map.get(strArr[0])+"님이 들어왔습니다.";
            }
        }
        return answer;
    }
}
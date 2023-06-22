import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        int size = progresses.length;
        boolean visited[] = new boolean[size];
        ArrayList<Integer> list = new ArrayList<>(); //정답을 담아주는 리스트
        
        int total = 0; //얼마나 골랐는지 확인
        while(total != size){ //고른갯수랑 progresses.length랑 동일하면 전부 다 고른거니까 종료 
            int cnt = 0; //이번에 얼마나끝났는지 확인
            for(int i = 0;i<size;i++){
                progresses[i] += speeds[i]; //진행률 증가
            }
            for(int i = total; i <size;i++){ //total이전꺼는 끝난거기때문에 total부터 시작
                if(progresses[i] >= 100){ //걸리면 그 뒤에껏도 확인함
                    total++;
                    cnt++;
                }else{
                    break;
                }
            }
            if(cnt != 0){
                list.add(cnt); 
            }
        }
        int[] answer  = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
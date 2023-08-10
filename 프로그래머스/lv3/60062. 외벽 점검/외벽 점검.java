import java.util.*;

//최소한의 친구를 투입하려고 한다. 
//몇명이 있어야 weak를 전부 수리할 수 있ㄴ을까?
// 친구를 전부 투입해도 고치지 못하면 -1 리턴



class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        
        int len = weak.length;
        int answer = len+1;
        int d_len = dist.length;
        Arrays.sort(dist); // 내림차순으로 정렬한다. 큰것부터없애기 위해서 
        
        
        for(int i = 0;i<len;i++){
            int cnt = 0;
            int time = 0;
            int idx = d_len-1; // dist 몇개나 쓸건지 확인
            
            for(int j = 1;j<len;j++){
                int num = weak[(i+j)%len]-weak[(i+j-1)%len]; // 두 지점 사이의 거리
                num = num < 0 ? num+n : num;
                if(idx < 0) break; // 더이상 깔 수 있는 사람이 없음 
                
                if(time <= dist[idx]){
                    time += num;
                }else{
                    idx--;
                    time = num;
                    cnt++;
                }
            }
            if(idx < 0 || time > dist[idx]){
              continue; // 더이상 작업을 할 수 있는 사람이 없거나, 작업을 처리할 수 없으면 넘어감  
            }else{
                cnt++;
                answer = Math.min(cnt, answer);
            }
            
            
        }
        
        if(answer == len+1){ // answer가 변하지 않았다면 처리할 수 없는 것이기 때문에 종료 
            return -1;
        }else{
            return answer;
        }
        
    }
}


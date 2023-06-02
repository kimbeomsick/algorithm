import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve){
        
        int student[] = new int[n+1];
        Arrays.fill(student,1); // 전부 체육복으로 채우기
        
        //도난 처리
        for(int i = 0;i<lost.length;i++){ 
            int num = lost[i];
            student[num]--;
        }
        
        //여분처리
        for(int i = 0;i<reserve.length;i++){
            int num = reserve[i];
            student[num]++;
        }
        
        //빌려주기
        for(int i = 1;i<=n;i++){
            if(student[i] != 0) continue;
            
            if(student[i-1] > 1){
                student[i-1]--;
                student[i]++;
                continue;
            }
            
           if(i+1 <= n && student[i+1] > 1){
                student[i+1]--;
                student[i]++;
                continue;
            }
    
            
        }
        int answer = 0;
        for(int i = 1;i<=n;i++){
            if(student[i] > 0){
                answer++;
            }
        }
        
        return answer;
    }
}
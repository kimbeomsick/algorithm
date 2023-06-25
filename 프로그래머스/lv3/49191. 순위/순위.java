import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int visited[] = new int[n+1]; // 승패 결과 저장하기 
        int[][] map = new int[n+1][n+1];
        for(int i = 0;i<results.length;i++){
            int win = results[i][0];
            int loser = results[i][1]; 
            
            //진거 이긴거 표시 
            map[win][loser] = 1;
            map[loser][win] = -1;
            
        }
        
        for(int k = 1;k<=n;k++){
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                        map[j][i] = -1;
                    }
                    
                    if(map[i][k] == -1 && map[k][j] == -1){
                        map[i][j] =-1;
                        map[j][i] = 1;
                    }
                    
                }
            }
        }
        
       for(int i = 1;i<=n;i++){
           int cnt = 0;
           for(int j = 1;j<=n;j++){
               if(map[i][j] != 0){
                   cnt++;
               }
           }
           if(cnt == n-1){
               answer++;
           }
       }
        
        return answer; 
    }
}
import java.util.*;


class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        int goal_a = 0;
        int goal_c = 0;
        
        //목표치를 구하는 for문 
        for(int i = 0;i<problems.length;i++){
            goal_a = Math.max(problems[i][0], goal_a);
            goal_c = Math.max(problems[i][1], goal_c);
        }
        
        if(goal_a <= alp && goal_c <= cop){
            return 0; // 이미 목표치에 도달했을 경우
        }
        
        //이거 왜하는거지? => 둘중 하나가 더 클수도 있기 때문! 
        if(alp >= goal_a){
            alp = goal_a;
        }
        if(cop >= goal_c){
            cop = goal_c;
        }
        
        int[][] dp = new int [goal_a+2][goal_c+2];
        
        //최대값으로 초기화 
        for(int i=alp;i<=goal_a;i++){
            for(int j=cop;j<=goal_c;j++){
                dp[i][j]=Integer.MAX_VALUE;
          }
        }
        
        dp[alp][cop] = 0;
        
        for(int i = alp;i<=goal_a;i++){ //시작부터 goal까지 가는 과정 
            for(int j = cop; j<=goal_c;j++){
                dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);
            
            for(int [] p : problems){
                
                if(i >= p[0] && j >= p[1]){ //내가 갈 수 있는 곳이라면 
                    if(i+p[2]>goal_a && j + p[3] > goal_c){ //범위를 넘어가면 안되기 때문에 goal_a, goal_c로 낮춘다. 
                        dp[goal_a][goal_c] = Math.min(dp[goal_a][goal_c],dp[i][j]+p[4]);
                    }else if(i+p[2]>goal_a ){
                        dp[goal_a][j+p[3]] = Math.min(dp[goal_a][j+p[3]],dp[i][j]+p[4]);
                    }else if(j + p[3] > goal_c){
                        dp[i+p[2]][goal_c] = Math.min(dp[i+p[2]][goal_c],dp[i][j]+p[4]);
                    }else{
                        dp[i+p[2]][j+p[3]] = Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]);
                    }
                    
                    
                }
                
                
            }
            }
                
        }
        
        return dp[goal_a][goal_c];
    }
}
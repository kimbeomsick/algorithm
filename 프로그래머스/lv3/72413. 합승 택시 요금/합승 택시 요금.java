import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        int[][] map = new int[n+1][n+1];
        
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=n;j++){
                if(i == j ){
                    map[i][j] = 0;
                }else{
                    map[i][j] = 100000000;
                }
            }
        }
        
        for(int i = 0;i<fares.length;i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int distance = fares[i][2];
            
            map[start][end] = distance;
            map[end][start] = distance;
            
        }
        
        for(int k = 1;k<=n;k++){
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                        map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                    
                        map[j][i] = Math.min(map[j][i], map[j][k]+map[k][i]);
                }
            }
        }
        
        for(int i = 1;i<=n;i++){
            // System.out.printf("map[%d][%d]:%d + map[%d][%d]:%d + map[%d][%d]:%d\n",a,i,map[a][i],b,i,map[b][i],s,i,map[s][i]);
            
            answer = Math.min(answer, map[a][i]+map[b][i]+map[s][i]);
        }
        System.out.println(map[s][a]);
        
        return answer;
    }
}
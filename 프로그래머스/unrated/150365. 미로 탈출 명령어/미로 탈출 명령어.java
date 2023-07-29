import java.util.*;

class Solution {
    
        
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0,-1,1,0};
    static char[] dir = {'d','l','r','u'};
    
    static int mapX, mapY;
    static int endX, endY;
    static String tempAnswer = "";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        mapX = n;
        mapY = m;
        endX = r-1;
        endY = c-1;
        int diff = Math.abs(x-r)+Math.abs(c-y);
        dfs(x-1,y-1,k,"",diff);
        answer = tempAnswer.equals("") ? "impossible" : tempAnswer;
        
        return answer;
    }
    
    // diff : 남은거리 
    static public void dfs(int r, int c, int k ,String str, int diff){
        if(k==0 && diff == 0){
            tempAnswer = str;
            return;
        }
        
        if(!tempAnswer.equals("") || diff > k) return;
        
        
        for(int i = 0;i<4;i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            
            if(nr < 0 || nc < 0 || nr>= mapX ||nc >= mapY) continue;
            if(diff%2  == k%2){
                dfs(nr,nc,k-1,str+dir[i],Math.abs(nr-endX)+Math.abs(nc-endY));
            }
        }
    }
}
import java.util.*;

class Solution {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int R,C;
    static boolean visited[][];
    public int solution(int[][] maps) {
        int answer = 0;
        R = maps.length;
        C = maps[0].length;
        
        visited = new boolean[R][C];
        
        return func(maps);
    }
    
    public static int func(int[][]maps ){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int value = curr[2];
            
            if(r == R-1 && c == C-1){
                return value;
            }
            
            for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= R || nc < 0 || nc >=C) continue;
                if(maps[nr][nc] == 0)continue;
                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc,value+1});
                }
            }
        }

        return -1;
        
        
    }
        
        
        
}
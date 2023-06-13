
import java.util.*;

class Solution {
    static char[][] map ;
    static boolean visited[][];
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int R,C;
    
    static int result = Integer.MAX_VALUE;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        R = maps.length;
        C = maps[0].length();
        map = new char[R][C];
        visited = new boolean[R][C];
        
        int sr = 0;
        int sc = 0;
        
        int mr = 0;
        int mc = 0;
        
        int er = 0;
        int ec = 0;
        
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                map[i][j] = maps[i].charAt(j);
                
                if(map[i][j] == 'S'){
                    sr = i;
                    sc = j;
                }
                
                if(map[i][j] == 'L'){
                    mr = i;
                    mc = j;
                }
                
                if(map[i][j] == 'E'){
                    er = i;
                    ec = j;
                }
            }
        }
        
        int value = bfs(sr,sc,mr,mc); // 레버까지의 거리
        if(value == -1){
            
            System.out.println("here1"+value);
            return -1;
        }else{
            answer += value;
            visited = new boolean[R][C]; // 방문기록 초기화
            value = bfs(mr,mc,er,ec);
            if(value == -1){
                System.out.println("here2");
                return -1;
            }
            answer += value;
        }
        
        
        
        return answer;
    }
    
    public static int bfs(int sr, int sc, int er, int ec){
        
       Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc,0});
        visited[sr][sc] = true;
        
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            
            int r = curr[0];
            int c = curr[1];
            
            if(r == er && c == ec){
                return curr[2]; // 가장짧은 거리 
            }else{
                for(int i = 0;i<4;i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if(nr < 0 || R <= nr || nc < 0 || nc >= C) continue;
                    
                    if(map[nr][nc] == 'X')continue;
                    
                    if(visited[nr][nc]) continue;
                    
                    
                    
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc,curr[2]+1});
                }
            }
        }
        return -1;
        
        
        
    }
}
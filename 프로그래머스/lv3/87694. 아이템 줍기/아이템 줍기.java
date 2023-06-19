import java.util.*;

class Solution {
    
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int[][] map = new int[120][120];
    static boolean[][] visited = new boolean[120][120];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        
        
        
        for(int i = 0;i<rectangle.length;i++){
            int a1 = rectangle[i][0]*2;
            int b1 = rectangle[i][1]*2;
            int a2 = rectangle[i][2]*2;
            int b2 = rectangle[i][3]*2;
            
            //직사각형 그리기
            
            for(int x = a1 ; x<=a2;x++){
                for(int y = b1;y<=b2;y++){
                    if(x == a1 || x == a2 || y == b1 || y == b2 ){
                        if(map[x][y] == 2){
                            map[x][y] = 2;
                        }else{
                        map[x][y] = 1;    
                        }
                    }else
                        map[x][y] = 2;
                }
            }
      
        }
        
        
        // for(int i = map.length-1;i>=0;i--){
        //     System.out.println(Arrays.toString(map[i]));
        // }
        
        answer = bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer/2;
    }
    
    public static int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY ){
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{characterX, characterY,0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int cnt = curr[2];
            // System.out.println("cnt : "+cnt);
            if(r == itemX && c == itemY) return cnt;
            
            for(int i = 0;i<4;i++){
                int nr = r+ dr[i];
                int nc = c+ dc[i];
                
                if(nr < 0 || nr >= 120 || nc < 0 || nc >= 120) continue;
                if(map[nr][nc]!=1) continue;
                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc,cnt+1});
                }
            }
        }
        
        return -1;
            
        
    }
}
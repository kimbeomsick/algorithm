import java.util.*;


class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int[][][] visited;
    static int R, C;
    public int solution(int[][] board) {
        int answer = 0;
        
        R = board.length;
        C = board[0].length;
        visited = new int[R][C][4]; //마지막 하나는 방향임 
        //초기화 하기 
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                for(int k = 0;k <4;k++){
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        bfs(board);
  
        
        return Math.min(Math.min(visited[R-1][C-1][0], visited[R-1][C-1][1]), Math.min(visited[R-1][C-1][2], visited[R-1][C-1][3]));
    }
    
    static public void bfs(int[][] board){
        Queue<int[]> q = new LinkedList<>();
        
        //방향이 두개니까 이 두개를 먼저 세팅함 
        visited[0][0][0] = 0;
        q.offer(new int[]{0,0,1,0}); 
        q.offer(new int[]{0,0,0,0}); 
          
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dir = curr[2];
            
            for(int i = 0;i<4;i++){
                int nr =  r + dr[i];
                int nc =  c + dc[i];
                
                if(nr < 0 || nr >=R || nc <0 || nc >= C)continue;
                if(board[nr][nc] == 1)continue;
                
                int cost;
                
                if(dir == i){
                    cost = curr[3]+100;
                }else{
                    cost = curr[3]+600;
                }
                
                if(visited[nr][nc][i] > cost){
                    visited[nr][nc][i] = cost;
                    q.offer(new int[]{nr,nc,i,cost});
                }
            }
        }
    }
}
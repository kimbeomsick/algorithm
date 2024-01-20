import java.util.*;

class Solution {
    static int[][] p = new int[6][2];
    static int R,C;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static boolean[][] visited_blue;
    static boolean[][] visited_red;
    
    static int answer = Integer.MAX_VALUE; // 결과 값

    public int solution(int[][] maze) {
        
        R = maze.length;
        C = maze[0].length;
        
        for(int r = 0;r<R;r++){
            for(int c =  0;c<C;c++){
                int num = maze[r][c];
                if(num != 0){
                    p[num][0] = r;
                    p[num][1] =c;
                }
            }
        }
        
        visited_blue = new boolean[R][C];
        visited_red = new boolean[R][C];
        
        //여기탐색 알고리즘 시작 
        func(true, p[2][0],p[2][1],p[1][0],p[1][1],0,0,maze);
        // System.out.printf("answer : %d\n",answer);
        // System.out.println("--");
        func(false, p[2][0],p[2][1],p[1][0],p[1][1],0,0,maze);
        // System.out.printf("answer : %d\n",answer);
    
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public static void func(boolean blue, int b0, int b1, int r0,int r1, int blueMove, int redMove, int[][] maze){
        
        if((b0 == p[4][0] && b1 == p[4][1])&&(r0 == p[3][0] && r1 == p[3][1])){
            // System.out.printf("blueMove:%d, redMove:%d\n",blueMove, redMove);
            answer = Math.min(answer,Math.max(blueMove, redMove));
            // System.out.printf("answer : %d\n",answer);
            return;
        }
        
        
        if(blue){
            if(b0 == p[4][0] && b1 == p[4][1]){
                 maze[b0][b1] = 5;
                func(!blue, b0,b1,r0,r1,blueMove, redMove,maze);                        
                maze[b0][b1] = 4;
            }else{
                for(int i = 0;i<4;i++){
                    int nr = b0+dr[i];
                    int nc = b1 +dc[i];
                    
                    if(nr<0 || nc<0||nr>=R||nc>=C) continue; // 밖으로 넘어감 
                    if(maze[nr][nc] == 5) continue; // 벽에 걸림
                    if(nr == r0 && nc == r1) continue; // 빨간색이랑 겹침
                    if(visited_blue[nr][nc]) continue; // 이미 온길임 
                    
                    visited_blue[nr][nc] = true;
                    func(!blue, nr,nc,r0,r1,blueMove+1, redMove,maze);
                    visited_blue[nr][nc] = false;
                    
                }
            }
        }else{
            if(r0 == p[3][0] && r1 == p[3][1]){
                maze[r0][r1] = 5;
                func(!blue, b0,b1,r0,r1,blueMove, redMove,maze);   
                maze[r0][r1] = 3;
            }else{
                 for(int i = 0;i<4;i++){
                    int nr = r0+dr[i];
                    int nc = r1 +dc[i];
                    
                    if(nr<0 || nc<0||nr>=R||nc>=C) continue; // 밖으로 넘어감 
                    if(maze[nr][nc] == 5) continue; // 벽에 걸림
                    if(nr == b0 && nc == b1) continue; // 빨간색이랑 겹침
                    if(visited_red[nr][nc]) continue; // 이미 온길임 
                    
                    visited_red[nr][nc] = true;
                    func(!blue, b0,b1,nr,nc,blueMove, redMove+1,maze);
                    visited_red[nr][nc] = false;
                    
                }
            }
        }
        
        
    }
}
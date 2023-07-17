import java.util.*;

// 1. 공격과 회복을 번갈아가면서함 
// 2. 0 이하면 파괴된 건물이머 
// 3. 건물의 내구도는 건물이 파괴되어도 계속 내려감 ( 0, -1, -2, -3... );
// 4. 누적합 셋팅해놓고 나중에 한꺼번에 더하기

class Solution {
    static int R,C;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        R = board.length;
        C = board[0].length;
        int[][] map = new int[R][C];
        for(int i = 0;i<skill.length;i++){
            add(map,skill[i][1],skill[i][2],skill[i][3],skill[i][4],skill[i][0] == 1?((-1)*skill[i][5]): skill[i][5]);
 
        }
        
        
        //가로
        for(int i = 0;i<R;i++){
            for(int j = 1;j<C;j++){
                map[i][j] +=map[i][j-1];
            }
        }
        
 
        
        //세로
        for(int i = 0;i<C;i++){
            for(int j = 1;j<R;j++){
                map[j][i] +=map[j-1][i];
            }
        }
        

        
        return count(board,map);
    }
    
    //누적합 셋팅
    public static void add(int[][] map, int  r1, int  c1, int  r2,  int c2, int degree){
        map[r1][c1] += degree;
        if(c2+1 < C){
            map[r1][c2+1] -= degree;
        }
        if(r2+1<R){
            map[r2+1][c1] -= degree;
        }
        if(r2+1 < R && c2+1 <C){
            map[r2+1][c2+1] += degree;
        }
            
    }
    
    public static int count(int[][] board, int [][] map){
        int cnt = 0;
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(board[i][j]+map[i][j]>0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
import java.util.*;

class Solution {
    static int dr[] = {0,1,0,-1};
    static int dc[] = {1,0,-1,0};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        //초기값 세팅
        
        int map[][] = new int[rows][columns];
        int cnt = 1;
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<columns;j++){
                map[i][j] = cnt++;
            }
        }
        
        //query꺼내기
        for(int i = 0;i<answer.length;i++){
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            
            //좌표를 통해 한바퀴 돌리기
            answer[i] = func(rows,columns,map,x1,y1,x2,y2);
            
            // for(int[] m : map){
            //     System.out.println(Arrays.toString(m));
            // }
            // System.out.println();
        }
        
        return answer;
    }
    
    public static int func(int row, int col, int[][] map , int x1, int y1, int x2, int y2){
        int r = x1;
        int c = y1;
    
        int[][] new_map = new int[row][col];
        
        //복사
        for(int i = 0;i<row;i++){
            new_map[i] = map[i].clone();
        }
        
        //방향 회전
        int idx = -1;
        
        //최소값 찾기
        int answer = Integer.MAX_VALUE;
        
        
        while(idx != 5){ 
            //방향 전환
            if((r == x1 || r == x2) &&(c == y1 || c == y2)){
                idx+=1;
                if(idx == 4)break;
            }
            int value = map[r][c]; // 기존 값 꺼내기
            answer = Math.min(answer,value);
            
            //다음 좌표
            int nr = r + dr[idx];
            int nc = c + dc[idx];
            
            new_map[nr][nc] = value; //다음 값에 넣기
            
            //다음 좌표 셋팅
            r = nr;
            c = nc;
            
        }
    
        for(int i = x1;i<=x2;i++){
            for(int j = y1;j<=y2;j++){
                map[i][j] = new_map[i][j];
            }
        }
        return answer;
        
    }
}
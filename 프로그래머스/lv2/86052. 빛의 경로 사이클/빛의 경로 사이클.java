import java.util.*;

class Solution {
    //위부터 시계 방향으로 돌아가게 만듬 
    static int []dr = {-1,0,1,0};
    static int []dc = {0,1,0,-1};
    
    static char[][] map;
    static boolean [][][]visited ;
    
    public int[] solution(String[] grid) {
        
        int R = grid.length;
        int C = grid[0].length();
        
        map = new char[R][C];
        visited = new boolean[R][C][4]; // 각 좌표에 대해 상하좌우로 방문했는지 확인한다.
        
        //초기화 
        for(int i = 0;i<grid.length;i++){
            map[i] = grid[i].toCharArray();
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                for(int k = 0;k<4;k++){
                    if(!visited[i][j][k]){
                        list.add(func(i,j,k,R,C));
                    }
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    static public int func(int r, int c, int dir, int R,int C){

        
        
        //먼저 해당 dir로 전진
        int cnt = 0;
         while(true){
            if(visited[r][c][dir])break;
             
            visited[r][c][dir] = true;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

             //좌표 위치
            if(nr >= R){
                r = 0;
                c = nc;
            }else if(nr < 0 ){
                r = R-1;
                c = nc;
            }else if(nc >= C){
                c = 0;
                r= nr;
            }else if(nc <0){
                c = C -1;
                r = nr;
            }else{
                r = nr;
                c = nc;
            }
             
               //회전하기
            if(map[r][c] == 'R'){
                dir = (dir+1)%4;
            }
            if(map[r][c] == 'L'){
                dir = (dir+3)%4;
            }
             cnt++;
        }
            
        return cnt;
        
        
    }
}
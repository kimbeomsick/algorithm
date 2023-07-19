import java.util.*;

class Solution {
    
    
    int[] dr = {1, -1, 0};
    int[] dc = {0,1,-1};
    
    public int[] solution(int n) {
        
        
        int[][] map  = new int[n][n];
        boolean visited[][]  = new boolean[n][n];
        int r = -1;
        int c = 0;
        int idx = 0;
        int num = 1;
        boolean flag = false;
        while(true){
            
            int nr = r + dr[idx];
            int nc = c + dc[idx];
            
            //회전
            if((nr >= n || nr < 0 || nc >= n || nc < 0 ) || visited[nr][nc] ){
                idx = (idx+1)%3;
                if(flag) break;
                flag = true;
                
            }else{ // 직진
                flag = false;
                visited[nr][nc] = true;
                map[nr][nc] = num++;
                r = nr;
                c = nc;
            }
        }
        
        // for(int []m : map){
        //     System.out.println(Arrays.toString(m));
        // }
        
        idx = 0;
        int[] answer = new int [num-1];
        for(int i = 0;i<n;i++){
            for(int j = 0;j <=i;j++){
                answer[idx++] = map[i-j][j];
            }
        }
        
        
        
        return answer;
    }
}
import java.util.*;

class Solution {
    
    static int R,C;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    
    public int[] solution(String[] maps) {
        
        
        R = maps.length;
        C = maps[0].length();
        
        boolean visited[][] = new boolean[R][C];
        int[][] map = new int[R][C];
        boolean flag = true;
        //초기화
        for(int i = 0;i<maps.length;i++){
            for(int j = 0;j<map[0].length;j++){
                if(maps[i].charAt(j) == 'X') {
                    map[i][j] = -1;
                }else{
                    flag = false;
                    map[i][j] = maps[i].charAt(j)-'0';
                }                                
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(!visited[i][j] && map[i][j]!= -1){
                    list.add(bfs(map,visited,i,j));            
                }
                
            }
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        if(!flag){
            return answer;
        }else{
            return new int[]{-1};
        }
        
    }
    
    public static int bfs(int[][] map, boolean[][] visited, int r, int c){
        int result = 0;
        
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r,c});
        
        
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            result += map[curr[0]][curr[1]];
            
            for(int i = 0;i<4;i++){
                int nr = curr[0]+dr[i];
                int nc = curr[1]+dc[i];
                
                if(nr < 0 || nc <0||nr >= R||nc >= C) continue;
                if(visited[nr][nc] || map[nr][nc] == -1) continue;
                
                q.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }
            
        
        
            
        return result;
        
    }
    
}
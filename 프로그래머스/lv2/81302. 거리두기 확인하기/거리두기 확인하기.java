import java.util.*;


class Solution {
    
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    
    public int[] solution(String[][] places) {
        
        
        int size = places.length;
        int[] answer = new int[size];
        for(int i = 0;i<size;i++){
            answer[i] = dfs(places[i]);
        }
        
        
        return answer;
    }
    
    static public int dfs(String[] strArr){
        
        
        Queue<int[]> q = new LinkedList<>(); //짧은 거리를 측정함 
        
        // boolean[][] visited ; // 방문처리
            
        //배열 탐색    
        for(int i = 0;i<5;i++){
            String str = strArr[i];
            for(int j=0;j<str.length();j++){
                char ch = str.charAt(j);
                if(ch == 'P'){ //사람을 발견함 
                    boolean[][] visited = new boolean[5][5];//방문 배열
                    q.add(new int[]{i,j,0}); //자리 넣기 
                    visited[i][j] = true; //방문처리
                    
                    while(!q.isEmpty()){
                        
                        int[] curr = q.poll(); 
                        
                        int r = curr[0];
                        int c = curr[1];
                        int cnt = curr[2];
                        
                        //거리를 지키지 않은 사람 .. 
                        if((cnt <= 2 && cnt >=1 )&& strArr[r].charAt(c) == 'P') return 0;
                        
                        for(int k = 0;k<4;k++){
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            
                            if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                            if(visited[nr][nc] || strArr[nr].charAt(nc) == 'X') continue;
                            if(cnt + 1 >= 3) continue; //3칸 이상은 볼 필요가 없음 
                            
                            visited[nr][nc] = true;
                            q.add(new int[]{nr,nc,cnt+1});
                        }
                    }
                    
                    
                }
            }
        }
        return 1;
        

        
        
        
        
        
        
    }
}
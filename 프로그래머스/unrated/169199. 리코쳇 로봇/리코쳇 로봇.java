class Solution {
    static int[][] visited;
    static char[][] map;
    static int R,C;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int result = Integer.MAX_VALUE;
    static boolean flag = false;
    public int solution(String[] board) {
        int answer = 0;
        
        //초기화
        R = board.length;
        C = board[0].length();
        map = new char[R][C];
        visited = new int[R][C]; //해당 자리에 몇번만에 방문했는지 저장한다. 
        
        int r = 0;
        int c = 0;
        //map 초기화
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                //초기화
                map[i][j] = board[i].charAt(j);
                visited[i][j] = Integer.MAX_VALUE;
                
                //R의 위치 저장
                if(map[i][j] == 'R'){
                    r =i;
                    c = j;
                }
            }
        }
        
        dfs(r,c,0,-1);
  
        if(flag){
            return result;
        }else{
            return -1;
        }   
        
    }
    
    public static void dfs(int r, int c, int depth, int direction){
        // System.out.printf("(%d,%d)\n",r,c); 
        
        if(map[r][c] == 'G'){
            flag = true;
            result = Math.min(result,depth);
            return;
        }
        
        //도달 했다면
        if(visited[r][c] < depth) return; //멀리 돌아왔다면 빠꾸
        visited[r][c] = depth; // 어기까지 얼마만에 왔는가 확인 
        
        
        //4 방향 돌면서 길찾기
        for(int i = 0;i<4;i++){
            if(4-i == direction) continue; // 내가 왔던 방향을 패스 
            int nr = r + dr[i];
            int nc = c + dc[i];
            
           //갈 수 있는 길인가?
            if(nr >= R || nr < 0 || nc < 0 || nc >= C) continue; // 범위 넘어가면 아웃
            if(map[nr][nc] == 'D') continue; //길막
            
            // 갈 수 있다면 얼마나 갈 수있는가?
            while(true){
                if(nr >= R || nr < 0 || nc < 0 || nc >= C) break; // 범위 넘어가면 아웃
                if(map[nr][nc] == 'D') break; //길막
                
                //같은 방향으로 전진
                nr+=dr[i];
                nc+=dc[i];
            }
            
            
            dfs(nr-dr[i],nc-dc[i],depth+1,i);
        }
    }
}
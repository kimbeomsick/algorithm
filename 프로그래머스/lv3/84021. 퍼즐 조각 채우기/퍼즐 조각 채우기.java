import java.util.*;

class Solution {
    
    static class Point implements Comparable<Point>{
        int r;
        int c;
        
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        
        @Override
        public int compareTo(Point p){
            if(this.r == p.r){
                return Integer.compare(this.c,p.c);
            }else{
                return Integer.compare(this.r,p.r);
            }
        }
    }
    
    //배열 두개 
    ArrayList<ArrayList<Point>> board_list = new ArrayList<>(); //빈공간 배열
    ArrayList<ArrayList<Point>> table_list = new ArrayList<>(); //조각 배열
    
    //이동 배열
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        
        int size = game_board.length;
        
        //1과 0의 자리 교환 
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(game_board[i][j] == 1){
                    game_board[i][j] = 0;
                }else{
                    game_board[i][j] = 1;
                }
            }
        }
        
        //방문 배열 만들기
        boolean[][] g_visited = new boolean[size][size];
        boolean[][] t_visited = new boolean[size][size];
        
        
        //블록이랑 빈공간 배열 만들기 
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(!g_visited[i][j] && game_board[i][j] == 1){
                    bfs(i,j,g_visited, game_board, board_list);
                }
                
                if(!t_visited[i][j] && table[i][j] == 1){
                    bfs(i,j,t_visited, table, table_list);
                }
            }
        }

        
        
        return compareBlock(board_list, table_list);
    }
    
    public static void bfs(int r, int c, boolean[][] visited, int[][] board, ArrayList<ArrayList<Point>> list){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        visited[r][c] = true;
        
        ArrayList<Point> sub_list = new ArrayList<>();
        sub_list.add(new Point(0,0)); // 0,0을 기준으로 넣음 
        
        while(!q.isEmpty()){
            Point curr = q.poll();
            
            for(int i = 0;i <4;i++){
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                
                if(nr < 0 || nr >= visited.length || nc < 0 || nc >= visited.length) continue;
                if(!visited[nr][nc] && board[nr][nc] == 1){
                    visited[nr][nc] = true;
                    q.add(new Point(nr,nc));
                    sub_list.add(new Point(nr-r, nc-c)); // (0,0)을 기준으로 해야하기 때문에 여기서부터 시작 
                }
            }
            
        }
        list.add(sub_list); //블록 or 빈자리 배열 넣기 
    }
    
    //돌려가면서 채워 넣을 수 있는지 확인하기 
    public static boolean isRotate(ArrayList<Point> board, ArrayList<Point>table){
        Collections.sort(board); //비교를 쉽게 하기 위해 정렬
        
        for(int n = 0;n<4;n++){
            
            Collections.sort(table);
            
            //위에서 제일 왼쪽에 있는게 기준점임 => 정렬 후에 사용해야 하기 때문에 여기다 둠
            int p_r = table.get(0).r;
            int p_c = table.get(0).c;
            
            for(int i = 0;i<table.size();i++){
                table.get(i).r -= p_r;
                table.get(i).c -= p_c;
            }
            
            boolean check = true;
            
            //비교하기
            for(int i = 0;i<board.size();i++){
                if(table.get(i).r != board.get(i).r || table.get(i).c != board.get(i).c){
                    check = false;
                    break;
                }
            }
            
            if(check) {
                return true;
            }else{
                //90도 돌리기  x,y => y,-x
                for(int i=0 ;i<table.size();i++){
                    int temp = table.get(i).r;
                    table.get(i).r = table.get(i).c;
                    table.get(i).c = temp*(-1);
                }
            }
                
            
        }
        return false;
    }
    
    
    public static int compareBlock (ArrayList<ArrayList<Point>> board, ArrayList<ArrayList<Point>> table){
        int answer = 0;
        
        int board_size = board.size();
        int table_size = table.size();
        
        
        boolean[] visited = new boolean[table_size];
        
        for(int i = 0;i<board_size;i++){
            for(int j = 0;j<table_size;j++){
                //둘의 사이즈가 같고 아직 방문하지 않았다면..?
                
                if(!visited[j] && board.get(i).size() == table.get(j).size()){
                    if(isRotate(board.get(i), table.get(j))){
                        visited[j] = true;
                        answer += table.get(j).size();
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}
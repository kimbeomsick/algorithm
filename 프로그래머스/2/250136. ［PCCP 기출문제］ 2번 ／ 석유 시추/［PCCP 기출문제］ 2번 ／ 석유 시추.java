import java.util.*;

class Solution {
    // 영역의 값이 뭔지 저장
    static ArrayList<Integer> areaList = new ArrayList<>();
    static int[][] visited;
    static int answer = 0;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int R,C;

    
    public int solution(int[][] land) {
        
        
        R = land.length;
        C = land[0].length;
        
        //영역 초기화
        visited = new int[R][C];
        for(int r = 0;r<R;r++){
            for(int c = 0;c <C;c++){
                visited[r][c] = -1;
            }
        }
        
        int area = 0;
        for(int r = 0;r<R;r++){
            for(int c = 0;c <C;c++){
                if(land[r][c] == 1 && visited[r][c] == -1){
                areaList.add(func(r,c,land,area));
                area++;
                }
                    
            }
        }
        
        return max();
    }
    
    //각 영역 최대값 산출한는 BFS
    static public int func(int r, int c, int[][] map, int area){
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        visited[r][c] = area;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int rr = curr[0];
            int cc = curr[1];
            sum++;
            
            for(int i = 0;i<4;i++){
                int nr = rr + dr[i];
                int nc = cc + dc[i];
                
                if(nr < 0 || nr >=R || nc < 0 || nc >= C) continue; //범위 넘어가면 패스
                if(map[nr][nc] == 0) continue; //석유 없는곳이면 패스
                if(visited[nr][nc] == -1){ //방문하지 않았다면
                    visited[nr][nc] = area ; //index의 영역 , 넣을때 안하면 중복됨
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return sum;
    }
    
    //시추로 찍기 
    static public int max(){
        int size = areaList.size();
        int answer = Integer.MIN_VALUE;
        
        for(int c = 0;c<C;c++){
            boolean[] areaArr = new boolean[size];
            
            for(int r = 0;r <R;r++){
                int num = visited[r][c];
                if(num != -1){
                    areaArr[num]=true;
                }
            }   
            int sum = 0;
            for(int i = 0;i<size;i++){
            if(areaArr[i]){
                sum += areaList.get(i);
            }
         }
            answer = Math.max(answer,sum);
        }
        
        
        return answer;
        
    }
    
}
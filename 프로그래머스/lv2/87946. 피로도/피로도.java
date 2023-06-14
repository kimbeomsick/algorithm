
import java.util.*;


class Solution {
    
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        
        int size = dungeons.length;
        visited = new boolean[size];
       //깊이 탐색을 사용하자 
        
        dfs(k, size, 0, dungeons);
        return answer;
    }
    
    public static void dfs(int k, int size, int depth, int[][] dungeons){
        
        
        answer = Math.max(answer,depth);
        
        
        if(depth == size){ //더 갈때가 없다면 뒤로가야함 
            return;
        }
        
        for(int i = 0;i<size;i++){
            if(!visited[i] && dungeons[i][0] <= k ){
                visited[i] = true;
                dfs(k-dungeons[i][1], size, depth+1, dungeons);
                visited[i]=false;
            }
            
        }
        
    }
    
    
}
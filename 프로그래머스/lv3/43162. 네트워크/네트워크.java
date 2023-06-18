import java.util.*;

class Solution {
    
    static boolean []visited;
    static int R;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        R = computers.length;
        
        visited = new boolean[R];
        for(int i = 0;i<R;i++){
            
            if(!visited[i]){
                
                fun(computers,i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void fun(int[][] map, int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int i = 0;i<R;i++){
                int next = map[curr][i];
                
                if(next == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
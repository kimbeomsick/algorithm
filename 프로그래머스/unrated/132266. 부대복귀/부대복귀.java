import java.util.*;

class Solution {
    
    static List<Integer>[] list;
    static int INF = 100000000;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        list = new ArrayList[n+1];
        for(int i = 0;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0;i<roads.length;i++){
            int a = roads[i][0];
            int b = roads[i][1];
            
            //왕복
            list[a].add(b);
            list[b].add(a);
        }
        
        
        int dist[] = func(destination,n);
        for(int i = 0;i<sources.length;i++){
            int num = dist[sources[i]];
            answer[i] = num == INF ? -1 : num;
        }
        return answer;
    }
    
    public static int[] func (int destination, int n){
        boolean visited[] = new boolean[n+1];
        int dist[] = new int[n+1];
        Arrays.fill(dist, INF); // 초기화
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{destination,0});
        dist[destination] = 0;
        
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
                
            if(!visited[curr[0]]){
                visited[curr[0]] = true;
                
                for(int next : list[curr[0]]){
                    if(!visited[next]){
                        q.add(new int[]{next,curr[1]+1});
                        dist[next] = Math.min(dist[next],curr[1]+1);
                    }
                }
            }
        }
        
        return dist;
    } 
        
}
import java.util.*;

// 풀이 
// 산 꼭대기 가는 제일 빠른 방법 찾으면 되는거 아님? 중복해서 왔다 갔다 해도 되잖아 

class Solution {
    static List<int[]>[] list; // 인접 리스트 
    static int[] answer = new int[2]; //정답 리스트
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        
        boolean []summits_list = new boolean[n+1];
        for(int summit : summits){
            summits_list[summit] = true;
        }
        
        //리스트 배열로 정리 
        list = new ArrayList[n+1];
        for(int i = 0;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0;i<paths.length;i++){
            int a = paths[i][0];
            int b = paths[i][1];
            int dist = paths[i][2];
            
            //양방향 삽입
            list[a].add(new int[]{b,dist});
            list[b].add(new int[]{a,dist});
        }
 
        findLoad(n, summits,gates,summits_list);
        
        
        return answer;
    }
    
   
    public static void findLoad(int n, int[] summits, int[] gates, boolean[] summits_list){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        }); 
        int dist[] = new int[n+1]; // 거리배열
        boolean visited[] = new boolean[n+1]; // 방문 배열
        Arrays.fill(dist,Integer.MAX_VALUE); // 최대 값으로 채움
        
        for(int start : gates){
            pq.add(new int[]{start, 0}); // 시작점과 거리 0을 넣는다. 
            dist[start] = 0; // 시작점은 거리가 0
        }
        
        while(!pq.isEmpty()){
            
            int curr[] = pq.poll();
            
            int node = curr[0];
            int curr_dist = curr[1];
            
            if(!visited[node]){ // 아직 방문하지 않았다면 
                visited[node] = true;
                
                for(int i = 0;i<list[node].size();i++){
                    int next = list[node].get(i)[0];
                    int next_dist = list[node].get(i)[1];
                    
                    // 노드를 순회하면서 dist 정보를 업데이트 한다. 
                    if(dist[next] > Math.max(next_dist,curr_dist)){
                        dist[next] = Math.max(next_dist,curr_dist);
                        if(summits_list[next]) continue; // 꼭대기 도달했다면 이 이상 안넣어도 됨 
                        pq.add(new int[]{next,dist[next]}); //  값 갱신하기 
                    }
                }
            }
            // System.out.println("node : "+node+" -> "+Arrays.toString(dist));
        }
        Arrays.sort(summits);
        
        answer[0] = 0;
        answer[1] = dist[0];
        for(int summit: summits){
            if(answer[1] > dist[summit]){
                answer[1] = dist[summit];
                answer[0] = summit;
            }
        }
        
    }
}
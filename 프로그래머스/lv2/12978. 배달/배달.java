import java.util.*;

// 1. 방문 배열 만들기 
// 2. 

class Solution {
    static class Node implements Comparable<Node>{
        int n;
        int d;
        
        public Node(int n, int d){
            this.d = d;
            this.n = n;
        }
        
        @Override
        public int compareTo(Node o){
            return this.d - o.d; // 거리순으로 오름차순 
        }
    }
    
    static List<Node>[] list ;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        //배열 초기화
        list = new ArrayList[N+1];
        for(int i = 0;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        
        //마을 입력하기
        for(int[] r : road){
            list[r[0]].add(new Node(r[1],r[2]));
            list[r[1]].add(new Node(r[0],r[2]));
        }
        

        return func(N,K);
    }
    
    public static int func(int n, int k){
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];  //방문
        int dist[] = new int[n+1]; //거리
        Arrays.fill(dist,Integer.MAX_VALUE); // 방문거리 초기화
        dist[1] = 0; // 자기자신과의 거리는 0
        pq.add(new Node(1,0)); //1번 마을 음식점 
        
        
        while(!pq.isEmpty()){
            
            Node curr = pq.poll();
            
            if(!visited[curr.n]){
                visited[curr.n] = true;
                for(Node next : list[curr.n]){
                    
                    //방문하지 않았고 curr -> next가 최소거리라면
                    if(!visited[next.n] && dist[next.n] > curr.d + next.d){
                        dist[next.n] = curr.d+next.d;
                        pq.add(new Node(next.n, curr.d+next.d));
                    }
                }
            }
                
        }
        
        int result = 0;
        for(int d: dist){
            if(d <= k){
                result++;
            }
        }
        return result;
    }
}
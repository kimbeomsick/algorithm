import java.util.*;

class Solution {
    
    // 간선 정보를 저장하는 클래스
    static class Edge implements Comparable<Edge>{
        
        int value; //간선의 크기
        int s;  //시작
        int e;  //끝
        
        public Edge(int s, int e, int value){ //생성자
            this.s = s;
            this.e = e;
            this.value = value;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.value - e.value; //엣지 기준으로 정렬때려버리기 
        }
    }
    
    
    
    static int[] parent; //부모 배열
    public int solution(int n, int[][] costs) {
        int answer = 0; //결과 값
        parent = new int[n]; //
        Arrays.fill(parent, -1); //부모가 없다는 것
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0;i<costs.length;i++){
            pq.add(new Edge(costs[i][0],costs[i][1],costs[i][2]));
        }
        
        
        int cnt = 0;
        while(cnt != n-1){
            
            Edge curr = pq.poll();
            
            if(find(curr.s) != find(curr.e)){ //둘의 부모가 같지 않다면
                cnt++; //간선 추가됨
                union(curr.s, curr.e); //둘이 하나의 트리로 합침
                answer+=curr.value; //간선의 크기 결과에 추가하기
            }
        }
        
        
        return answer;
    }
    
    //부모 찾기 알고리즘 
    public static int find(int num){
        if(parent[num] == -1){
            return num;
        }else{
            return find(parent[num]);
        }
    }
    
    //합치기
    public static void union (int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa > pb){
            parent[pb] = pa;
        }else{
            parent[pa] = pb;
        }
    }
}
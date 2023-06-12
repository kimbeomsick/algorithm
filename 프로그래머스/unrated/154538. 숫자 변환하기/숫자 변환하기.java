import java.util.*;

class Solution {
    
    //이걸 Queue에 넣을거임 
    static class Node implements Comparable<Node>{
        int number; // 숫자
        int count; // 얼마나 변했는지 확인
        
        public Node(int number, int count){
            this.number = number;
            this.count = count;
        }
        
        @Override
        public int compareTo(Node n){
            return this.number - n.number; // 숫자로만 비교함 => 정렬하면 되기 때문이다. 
        }
    }
    
    static int result = Integer.MAX_VALUE; //도달하지 못했을 경우
    static int[] visited ;
    public int solution(int x, int y, int n) {
        
        visited = new int[y+1];
        Arrays.fill(visited,Integer.MAX_VALUE);
        
        func(x,y,n);
        
        if(result == Integer.MAX_VALUE){
            return -1;
        }
        
        return result;
    }
    
    
    public static void func(int x, int y, int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //초기 값 세팅
        visited[x] = 0; //방문처리
        pq.offer(new Node(x,0)); // 초기값 삽입
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            
            if(curr.number == y){
                System.out.println("asdfsadf");
                result = Math.min(result, curr.count);
            }
            
            if(curr.number * 3 <= y && visited[curr.number*3] > curr.count+1){
                    visited[curr.number*3] = curr.count+1;
                    pq.offer(new Node(curr.number*3,curr.count+1));
            }
            
            if(curr.number * 2 <= y && visited[curr.number*2] > curr.count+1){
                visited[curr.number*2] = curr.count+1;
                    pq.offer(new Node(curr.number*2,curr.count+1));
            }
            
            if(curr.number +n <= y && visited[curr.number+n] > curr.count+1){
                visited[curr.number+n] = curr.count+1;
                    pq.offer(new Node(curr.number+n,curr.count+1));
            }
 
        }
    }
}
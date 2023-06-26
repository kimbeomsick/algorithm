import java.util.*;

// 1. 각 노드에 연결된 노드를 만든다. Map<Node, Set<Node>> visited 방문처리!
// 2. 

class Solution {
    
    static class Node{
        int r;
        int c;
        
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(r,c);
        }
        
        @Override
        public boolean equals(Object o){
            Node node = (Node)o;
            return this.r == node.r && this.c == node.c;
        }
            
        
    }
    
    static int dr[] = {-1,-1,0,1,1,1,0,-1};
    static int dc[] = {0,1,1,1,0,-1,-1,-1};
    
    public int solution(int[] arrows) {
        int answer = 0;
        
        Map<Node, Set<Node>> visited = new HashMap<>();
        Node now = new Node(0,0);
        visited.put(now, new HashSet<Node>());
        
        
        
        for(int arrow : arrows){
            for(int i = 0;i<2;i++){
                Node next = new Node(now.r + dr[arrow], now.c + dc[arrow]);
                
                //1. 처음보는 노드라면
                if(!visited.containsKey(next)){
                    visited.put(next, makeDefaultSet(now));
                    visited.get(now).add(next);
                    
                    
                }else{ //2. 이미 봤던거라면
                    
                    if(!visited.get(next).contains(now)){ //이길로 방문한 이력이 없다면!
                        answer++;
                        visited.get(next).add(now);
                        visited.get(now).add(next);
                    }
                    
                }
                now = next;
            }
        }
        
        
        return answer;
    }
    
    public static Set makeDefaultSet(Node node){
        Set<Node> set = new HashSet<>();
        set.add(node);
        
        return set; //
    }
}
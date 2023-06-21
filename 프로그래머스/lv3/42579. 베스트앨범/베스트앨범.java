import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        String genres;
        ArrayList<int[]> list = new ArrayList<>();
        int sum;
        
        public Node(String genres, int sum){
            this.genres = genres;
            this.sum = sum;
        }
        
        @Override
        public int compareTo(Node o){
            return o.sum - this.sum ;
        }
                
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Node> map = new HashMap<>();
        
        for(int i = 0;i<genres.length;i++){
            Node node;
            if(map.containsKey(genres[i])){ //있다면
                node = map.get(genres[i]);
            }else{ //없다면 
                node = new Node(genres[i],0);
            }
            
            node.sum += plays[i]; //플래이수 증가 
            node.list.add(new int[]{i,plays[i]}); //고유번호, 재생횟수
            map.put(genres[i], node); // 넣기
        }
        
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(Node node : map.values()){
            q.add(node); //크기순서대로 정렬됨
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!q.isEmpty()){
            Node node = q.poll();
            
            Collections.sort(node.list,(a,b)->{
                return b[1]-a[1];
            });
                
            for(int i = 0; i< Math.min(2,node.list.size());i++){
                result.add(node.list.get(i)[0]);
            }
        }
        
        answer = new int[result.size()];
        for(int i = 0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
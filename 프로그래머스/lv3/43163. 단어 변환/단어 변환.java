import java.util.*;

class Solution {
    static class Node{
        String word;
        int cnt;
        
        public Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        
        boolean flag = false;
         for(int i = 0;i<words.length;i++){
             if(words[i].equals(target)){
                 flag = true;
                 break;
             }
         }
        
        
        if(flag){
            return func(words, begin, target);
        }else{
            return 0;
        }
        
        
    }
    
    
    public static int diff(String str1, String str2){
        
        if(str1.length() != str2.length() ){
            return -1;
        }
        
        int cnt = 0;
        for(int i = 0;i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i) ){
                cnt++;
            }
        }
        
        return cnt; //둘의 차이가 얼마나 나는지 확인 
    }
    
    public static int func(String[] words, String begin, String target){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            String word = curr.word;
            int cnt = curr.cnt;
            
            if(target.equals(word)){
                return cnt;
            }
            
            for(int i = 0;i<words.length;i++){
                if(!visited[i] && diff(word, words[i]) == 1){ // 둘의 차이가 1일경우
                    visited[i] = true;
                    q.add(new Node(words[i],cnt+1));
                }
            }
        }
        
        return -1;
    }
}



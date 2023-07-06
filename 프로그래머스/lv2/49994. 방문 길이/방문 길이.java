
import java.util.*;
class Solution {
    
    static class Edge{
        int start, end;
        public Edge(int start, int end){
            this.start = start;
            this.end = end;
            
        }
        
        @Override
        public boolean equals(Object o){
            Edge edge = (Edge)o;
            return (this.start == edge.start && this.end == edge.end);
        }
        
        @Override
        public int hashCode(){
            return this.start*100 + this.end;
        }
            
            
    }
    
    public int solution(String dirs) {
        int answer = 0;
        
        Map<Character, int[]> dir  = new HashMap<>();
        dir.put('U',new int[]{-1,0});
        dir.put('D',new int[]{1,0});
        dir.put('R',new int[]{0,1});
        dir.put('L',new int[]{0,-1});
        
        HashSet<Edge> set = new HashSet<>();
        
        int map[][] = new int[11][11];
        
        int r = 5;
        int c = 5;
        
        for(int i = 0;i<dirs.length();i++){
            char ch = dirs.charAt(i);
            
            int nr = r + dir.get(ch)[0];
            int nc = c + dir.get(ch)[1];
            
            if(nr < 0 || nc < 0 || nr > 10 || nc > 10)continue;
            
            Edge a = new Edge(r*11+c, nr*11+nc);
            Edge b = new Edge(nr*11+nc, r*11+c);
            // System.out.printf("(%d,%d) => (%d,%d) 이동\n",r,c,nr,nc);
            if(!set.contains(a) && !set.contains(b)) {
                
                set.add(a);
                set.add(b);
                
                answer++;
            }
            r = nr;
                c = nc;
                
            
            
        }
        
        
        
        return answer;
    }
}
import java.util.*;

// 1. 연결된 두점을 +1, -1 해서 둘다 0으로 만들기 
// 2. 전부다 0으로 만드는것이 불가능하다면 return -1; 
// 3. 가능하다면 최소 몇번만에 가능한지 확인 

class Solution {
    
    static List<Integer>[] list;
    static boolean[]visited;
    static long a_long[];
    static long answer = 0;
    public long solution(int[] a, int[][] edges) {
        
        long num = 0;
        a_long = new long[a.length];
        visited = new boolean[a.length]; // 방문배열
        list = new ArrayList[a.length]; // 연결 관계
        for(int i = 0;i<a.length;i++){
            list[i] = new ArrayList<>();
            num += a[i];
            a_long[i] = a[i];
        }
        if(num != 0 ) return -1; //합이 0이 아라면 빠꾸
        
        for(int i = 0;i<edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            
            list[x].add(y);
            list[y].add(x);
                
        }
        
        fun(0,a_long);
        return answer;
    }
    
    // 회수 구하기
    public static long fun(int idx, long[] a){
        visited[idx] = true;
        int num = 0;
        for(int i = 0;i<list[idx].size();i++){
            int child = list[idx].get(i);
            if(!visited[child]){
                 a_long[idx] += fun(child, a);
            }
        }
        
        //절대 값만 더하는 게 있고 , a_long에는 실제 값만 더해야할것같다. 
        answer += Math.abs(a_long[idx]);
        
        return a_long[idx];
        
    }
}
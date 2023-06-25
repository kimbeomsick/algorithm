import java.util.*;

class Solution {

    
    static int visited[];
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new int[n+1];
        
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i = 0;i <=n;i++){
            list[i] = new ArrayList<>();
        }
        
         for(int i = 0;i<edge.length;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            
             list[a].add(b);
             list[b].add(a);
            
        }
        
        Queue<Integer> q = new LinkedList<>();

        
        q.add(1);
        visited[1] = 1;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            
            int curr = q.poll();
            
            for(int i = 0;i<list[curr].size();i++){
                int num = list[curr].get(i);
                if(visited[num] == 0 ){
                    visited[num] = visited[curr]+1;
                    q.add(num);
                    
                    max = Math.max(max, visited[num]);
                }
            }
        }
        
        for(int i = 1;i<=n;i++){
            if(visited[i] == max){
                // System.out.println("i : "+i);
                answer++;
            }
        }
        
        System.out.println(Arrays.toString(visited));
        
        
        return answer;
    }
}

// print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]), 3)
// print(solution(11, [[1, 2], [1, 3], [2, 4], [2, 5], [3, 5], [
//       3, 6], [4, 8], [4, 9], [5, 9], [5, 10], [6, 10], [6, 11]]), 4)
// print(solution(4, [[1, 2], [2, 3], [3, 4]]), 1)
// print(solution(2, [[1, 2]]), 1)
// print(solution(5, [[4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]), 2)
// print(solution(4, [[1, 2], [1, 3], [2, 3], [2, 4], [3, 4]]), 1)
// print(solution(4, [[1, 4], [1, 3], [2, 3], [2, 1]]), 3)
// print(solution(4, [[3, 4], [1, 3], [2, 3], [2, 1]]), 1)
// print(solution(4, [[4, 3], [1, 3], [2, 3]]), 2)
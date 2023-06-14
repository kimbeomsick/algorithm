import java.util.*;
class Solution {
    
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        arr = new int[n+1][n+1];
        
        //인접 행렬
        for(int i = 0;i<wires.length;i++){
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        //선 끊어보면서 순회하기
        int a,b;
        for(int i = 0;i<wires.length;i++){
            a = wires[i][0];
            b = wires[i][1];
            
            //끊기
            arr[a][b] = 0;
            arr[b][a] = 0;
            
            //bfs
            answer = Math.min(answer,bfs(n,a));
            System.out.println();
                
            //연결하기
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        
        
        return answer;
    }
    
    public static int bfs(int n, int a){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[a] = true;
        q.add(a);
        int cnt = 1;
        
        while(!q.isEmpty()){
            
            int curr = q.poll(); // 뽑아라
            
            
            for(int i = 1;i<=n;i++){
                if(arr[curr][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
            
            
        }
        return Math.abs(n-(2*cnt));
        
    }
}
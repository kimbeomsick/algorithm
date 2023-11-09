

import java.io.*;
import java.util.*;

// tip: each public class is put in its own file
public class Main
{
	static int N,K;
	static Stack<Integer> stack = new Stack<>();
	static int result = Integer.MAX_VALUE;
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //총 행성 개수 
        K = Integer.parseInt(st.nextToken()); //처음 시작할 행성 

        int map[][] = new int[N][N];
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //map의 최소거리 갱신 
        map = dp(map); 
        //방문처리 하기 위한 배열 
        boolean visited[] = new boolean[N];
        //시작 행성 탐사 
        visited[K] = true;
        //dfs 돌면서 모든 행성 방문 
        func(K,map,visited, 1,0);
        
        
        System.out.println(result);


   }
   public static void func(int idx, int[][] map, boolean visited[], int depth, int sum ) {
	   // 다 돌았다면 return 
	   if(depth == N) {
		   
		   result = Math.min(result, sum);
		   return;
	   }
	   
	   // 거리가 너무 멀다면 뒤로 백트레킹 
	   if(result <= sum) {
		   return;
	   }
	   
	   for(int i = 0;i<N;i++) {
		   // 방문했다면 처리안함 
		   if(visited[i]) continue;
		   
		   // 방문처리 
		   visited[i] = true;
		   // 다음 거리 찾기 
		   func(i, map, visited, depth+1, sum+map[idx][i]);
		   // 방문 취소 처리 
		   visited[i] = false;
	   }
   }
    
    // 플로이드 워셜 알고리즘으로 각각의 최소거리 갱신 => 이렇게 할 수 있는 이유는 행성간 이동의 중복이 가능하기 때문 
    public static int[][] dp (int[][] map){
  
    	for(int k = 0;k<N;k++) {
    		for(int i = 0;i<N;i++) {
    			for(int j = 0;j<N;j++) {
    				if(i != j) {
    					if(map[i][k] + map[k][j] < map[i][j]) {
    						map[i][j] = map[i][k]+map[k][j];
    					}
    				}
    			}
    		}
    	}
    	return map;
    }


}
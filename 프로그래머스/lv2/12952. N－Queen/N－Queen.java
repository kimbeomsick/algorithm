import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int n) {
        
        int map[][] = new int[n][n];
        
        func(map,0,n);
        return answer;
    }
    
    public static void func(int[][] map, int idx, int n){
        if(idx == n){
            answer++;
            return;
        }
        // System.out.println("idx : "+idx+"\n\n");

        
        //for 문으로 현재 갈 수 있는 곳 확인
        //갈수 있는 곳 방문처리하고
        //재귀함수에 방문처리한 배열 넘기기
        
        for(int i =0;i<n;i++){
            if(map[idx][i] == 0){ //해당 줄에 퀸을 놓을 수 있는자리 
                int[][] map2 = newMap(map);
                // for(int[] m: map2){
                //     System.out.println(Arrays.toString(m));
                // }
                // System.out.println("--");
                settingMap(map2,idx,i,n);
                
                // for(int[] m: map2){
                //     System.out.println(Arrays.toString(m));
                // }
                
                 func(map2, idx+1,n);
            }
        }
    }
    
    //못가는곳 표시 
    public static void settingMap(int[][] map, int r, int c,int n){
        for(int i = 0;i<n;i++){
            
            map[r][i] = 1; 
            map[i][c] = 1;
            if(r+i < n && c+i < n){
                map[r+i][c+i] = 1;
            }
            if(r+i < n && c-i >=0){
                map[r+i][c-i] = 1;
            }
        }
    }
    
    //배열 복사 
    public static int[][] newMap (int[][] map){
        int n = map.length;
        //방문 배열 복사 
        int new_map[][] = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                new_map[i][j] = map[i][j];
            }
        }
        
        return new_map;
    }
}
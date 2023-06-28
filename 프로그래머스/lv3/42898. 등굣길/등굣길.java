import java.util.*;

class Solution {
    
    static int divider = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        
        int map[][] = new int[m+1][n+1];
        map[1][1] = 2;
        
        
        //물웅덩이 채우기 
        for(int i = 0;i<puddles.length;i++){
            
            int x = puddles[i][0];
            int y = puddles[i][1];
            
            map[x][y] = 1;
        }
        
        //1,1 이랑 물웅덩이 하기
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                
                if(map[i][j] != 0){
                    map[i][j]--;
                    continue;
                }
                
                map[i][j] = (map[i][j-1] + map[i-1][j])%divider;
            }
        }
        
        // for(int[] k : map){
        //     System.out.println(Arrays.toString(k));
        // }
        
        
        
        return map[m][n];
    }
}
import java.util.*;

// city map으로 지도가 주어짐 
// 자동차는 오른쪽 혹은 아래로 이동가능함
// 1 통행금지 , 2 우회전 금지 => 방향을 변경할 수 없음 
// 이동이 가능한 전체 경로의 수를 MOD로 나눈 값을 출력하세욧 


class Solution {
    static int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        int[][] map = new int[m][n];
        map[0][0] = 1;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(cityMap[i][j] == 0){
                    func(cityMap,map,i,j,m,n);
                }
            }
        }
        
        // for(int[] a : map){
        //     System.out.println(Arrays.toString(a));
        // }
        
        answer = map[m-1][n-1]%MOD;
        return answer;
    }
    
    static public void func(int[][] cityMap, int[][] map, int x, int y, int m ,int n){
        for(int i = x+1;i<m;i++){
            if(cityMap[i][y] == 0 ){
                map[i][y] += map[x][y];
                map[i][y] %= MOD;
                break;
            }else if(cityMap[i][y] == 1){
                break;
            }else{
                continue;
            }
            
        }
        for(int i = y+1;i<n;i++){
            if(cityMap[x][i] == 0 ){
                map[x][i] += map[x][y];
                map[x][i] %= MOD;
                break;
            }else if(cityMap[x][i] == 1){
                break;
            }else{
                continue;
            }
            
        }
        
        
        
    } 
}
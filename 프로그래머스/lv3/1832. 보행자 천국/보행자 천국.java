import java.util.*;

// city map으로 지도가 주어짐 
// 자동차는 오른쪽 혹은 아래로 이동가능함
// 1 통행금지 , 2 우회전 금지 => 방향을 변경할 수 없음 
// 이동이 가능한 전체 경로의 수를 MOD로 나눈 값을 출력하세욧 
// 

class Solution {
    static int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        int[][] map = new int[m][n];
        map[0][0] = 1;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(cityMap[i][j] == 0){ // 1,2에서는 고려할 수 없다고 판단하고 양쪽으로 다 갈 수 있는 0만 선택한다. 
                    func(cityMap,map,i,j,m,n);
                }
            }
        }
        
        
        answer = map[m-1][n-1]%MOD;
        return answer;
    }
    
    static public void func(int[][] cityMap, int[][] map, int x, int y, int m ,int n){
        for(int i = x+1;i<m;i++){
            if(cityMap[i][y] == 0 ){ // 밑으로 쭉 가다가 0인자리 만나면 그쪽으로 자기 자신의 값만큼 갈 수 있음  
                map[i][y] += map[x][y];
                map[i][y] %= MOD;
                break;
            }else if(cityMap[i][y] == 1){ // 1일 땐 고려안함
                break;
            }else{ // cityMap이 2라면 건너 뛰기 
                continue;
            }
            
        }
        for(int i = y+1;i<n;i++){
            if(cityMap[x][i] == 0 ){ // 오른쪽으로 쭉가다가 처음만난 0에게 자기자신의 값을 더함(자기를 통해 갈 수 있는 루트임)
                map[x][i] += map[x][y];
                map[x][i] %= MOD;
                break;
            }else if(cityMap[x][i] == 1){ //1이 나오면 그쪽으로는 못감
                break;
            }else{
                continue; // 2가 나오면 한 방향으로 밖에 갈 수 없기 때문에 건너뛰기 
            }
            
        }
        
        
        
    } 
}
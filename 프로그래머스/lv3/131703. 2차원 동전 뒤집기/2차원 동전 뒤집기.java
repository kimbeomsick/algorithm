import java.util.*;

// 같은 줄의 동전을 모두 뒤집어서 beginning -> target이 되도록 하자 
// 최소 횟수를 리턴하라 and 못하면 -1

// 새로를 먼저 뒤집냐 가로를 먼저 뒤집냐는 동일한가?

class Solution {
    static int answer = Integer.MAX_VALUE;
    static int R, C;
    public int solution(int[][] beginning, int[][] target) {
        
        R = beginning.length;
        C = beginning[0].length;
        
        dfs(beginning, target, 0,0,0);
        if(Integer.MAX_VALUE == answer){
            return -1;
        }
        return answer;
    }
    
    public static void dfs(int[][] beginning, int[][] target,int row, int col,  int change){   
        //가로세로 전부 거쳐왔다면 target이랑 맞는지 확인하기 
        if(row == R && col == C){
            if(correct(beginning, target)){//둘이 똑같으면
                answer = Math.min(change, answer);//최소값 선택
            }
            return ;
        }
        
        if(answer < change) return ; // 더크면 의미가 없기 때문에 백트레킹
        
        //가로먼저 뒤집기 
        if(row < R){
            dfs(reverse(beginning,row,-1),target,row+1,col,change+1);// 뒤집음
            dfs(beginning,target,row+1,col,change);// 안뒤집음
        }else{ //세로로 뒤집기 
            dfs(reverse(beginning,-1,col),target,row,col+1,change+1);// 뒤집음
            dfs(beginning,target,row,col+1,change);// 안뒤집음
        }
    }
    
    //원하는 부분 뒤집기 
    public static int[][] reverse(int[][] beginning, int row, int col){
        int[][] arr = new int[R][C] ;
        
        //복사
        for(int i=0;i<R;i++){
            arr[i] = beginning[i].clone();
        }
            
        //가로 뒤집기   
        if(row >=0){
            for(int i = 0;i<C;i++){
                arr[row][i] = arr[row][i] == 1 ? 0 : 1;
            }
        }
        
        //세로 뒤집기
        if(col >=0){
            for(int i = 0;i<R;i++){
                arr[i][col] = arr[i][col] == 1 ? 0 : 1;
            }
        }
        
        
        return arr;
    }
    
    //두 배열이 동일한지 확인 
    public static boolean correct(int[][] a, int[][] b){
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}
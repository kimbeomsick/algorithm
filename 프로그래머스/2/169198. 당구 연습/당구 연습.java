import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int size = balls.length;
        int[] list = new int[size];
        Arrays.fill(list,Integer.MAX_VALUE);
        
        
        for(int i = 0;i<size;i++){
            int x = balls[i][0];
            int y = balls[i][1];
            
            int continue_num = -1;
            if(x == startX){
                continue_num = y > startY ? 1 : 3;
            }else if(y == startY){
                continue_num = x > startX ? 2 : 0;
            }
            
            int[][] arr = new int[4][2];
            arr[0] = new int[]{-1*x,y}; //좌
            arr[1] = new int[]{x,2*n-y}; // 상
            arr[2] = new int[]{2*m-x,y}; //우
            arr[3] = new int[]{x,-1*y}; //하
            
            
            for(int j = 0;j<4;j++){
                if(continue_num == j) continue;
                int value = (int)Math.pow(arr[j][0]-startX,2) + (int)Math.pow(arr[j][1]-startY,2);
                list[i] = Math.min(list[i], value);    
            }
            
        }
        return list;
    }
    
   
}
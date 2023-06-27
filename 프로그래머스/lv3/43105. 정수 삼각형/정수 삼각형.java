import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int len = triangle.length;
        for(int i = 0;i<len-1;i++){
            for(int j = 0;j < triangle[i].length;j++){
                
                if(j == 0){
                    triangle[i+1][j] = triangle[i][j] + triangle[i+1][j];
                    
                }else{
                    triangle[i+1][j] = Math.max(triangle[i+1][j] - triangle[i][j-1] + triangle[i][j], triangle[i+1][j]);
                }
                triangle[i+1][j+1] = triangle[i][j] + triangle[i+1][j+1];
                answer = Math.max(answer, triangle[i+1][j]);
                answer = Math.max(answer, triangle[i+1][j+1]);
            }
        }
        
        // for(int[]a : triangle ){
        //     System.out.println(Arrays.toString(a));
        // }
        
        
        
        
        return answer;
    }
}
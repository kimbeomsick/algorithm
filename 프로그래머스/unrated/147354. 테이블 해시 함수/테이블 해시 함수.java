import java.util.*;

//  1. col번재 칼럼을 기준으로 내림차순 정렬 

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer[] = new int[data.length];
        
        
        
        //co1 ==2 면 두번째 칼럼이라는 뜻 
        Arrays.sort(data, (a,b)->{
            if(a[col-1] == b[col-1]){
                return b[0]-a[0]; //내림차순
            }else{
                return a[col-1] - b[col-1]; //오름차순
            }
         });
            
       
        
        for(int i = 0;i<data.length;i++){
            for(int j = 0;j<data[0].length;j++){
                answer[i] += data[i][j]%(i+1);
            }
        }
        
        
        
        int result = 0;
        boolean flag = true;
        for(int i = row_begin-1;i<row_end;i++){
            System.out.println(answer[i]);
            
            
            if(flag){
                flag = false;
                result = answer[i];
            }else{
                result ^= answer[i];    
            }
            System.out.println(result);
            
            
        }
        
        
        return result;
    }
}
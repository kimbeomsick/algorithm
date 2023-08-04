class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        
        int R1 = arr1.length;
        int C1 = arr1[0].length;
        
        int R2 = arr2.length;
        int C2 = arr2[0].length;
        
        int[][] answer = new int[R1][C2];
         
        for(int i = 0;i<R1;i++){
            for(int j = 0;j<C2;j++){
                
                    for(int k = 0;k<C1;k++){
                        answer[i][j]+= arr1[i][k]*arr2[k][j];
                    }
                
            }
        }
        
        return answer;
    }
}
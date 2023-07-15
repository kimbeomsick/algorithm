

// 1024부터 천천히 검사하는게 좋을까? 나누기 2하면 되니까 

class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        func(0,0,arr,arr.length);
        return answer;
    }
    
    public static void func(int r, int c, int[][]arr, int size){
        if(check(r,c,size,arr)){
            if(arr[r][c] == 1){
                answer[1]++;
            }else{
                answer[0]++;
            }
            return ;
        }
        
        func(r,c,arr,size/2);
        func(size/2+r,c,arr,size/2);
        func(r,size/2+c,arr,size/2);
        func(size/2+r,size/2+c,arr,size/2);
    }
    
    public static boolean check(int r, int c, int size, int[][] arr){
        
        int num = arr[r][c];
        for(int i = r;i<r+size;i++){
            for(int j = c;j<c+size;j++){
                if(arr[i][j]!=num) return false;
            }
        }
        
        return true;
    }
}
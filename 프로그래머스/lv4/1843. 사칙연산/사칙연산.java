import java.util.*;


class Solution {
    
    int[][] max , min;
    int[] list;
    public int solution(String arr[]) {
        
        
        int size = arr.length/2 + 1; // 숫자 갯수
        max = new int[size][size];
        min = new int[size][size];
        
        //숫자만 담아둘 배열 (편하게 찾으려고) 
        list = new int[size];
        
        //초기화 하기
        for(int i = 0;i <arr.length;i+=2){
            int num = Integer.parseInt(arr[i]);
             if(i == 0){
                 list[i/2] = num;
             }else{
                 list[i/2] = arr[i-1].equals("+") ? num : -num;
             }
        }
        
        
        for(int i = size-1;i>=0;i--){
            for(int j = i;j<size;j++){
                if(i == j){
                    max[i][j] = list[i];
                    min[i][j] = list[i];
                }else{
                    //초기화
                    max[i][j] = Integer.MIN_VALUE; 
                    min[i][j] = Integer.MAX_VALUE;
                    
                    for(int k = i; k < j ;k++){
                        boolean value = k == i ? true : false;
                        func(min[i][k], min[k+1][j], i,j, value);
                        func(min[i][k], max[k+1][j], i,j, value);
                        func(max[i][k], min[k+1][j], i,j, value);
                        func(max[i][k], max[k+1][j], i,j, value);
                    }
                }
            }
        }
        
        
        return max[0][size-1];
    }
    
    public void func(int a, int b, int x, int y , boolean value){
        if(value && a< 0){ // i가 첫번째 값이고 음수이면.. 
            min[x][y] = Math.min(min[x][y], Math.min(a-b, a+b));//맨앞에 있는게 음수면 뒤에 있는것도  음수로 바뀌니까 -b!
            max[x][y] = Math.max(max[x][y], Math.max(a-b, a+b));
        }else{
            min[x][y] = Math.min(min[x][y], (a+b));
            max[x][y] = Math.max(max[x][y], (a+b));
        }
    }
}
import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[] arr = new int[n];
        //or 으로 비트 연산함
        for(int i = 0;i<arr1.length;i++){
            arr[i] = (int)(arr1[i] | arr2[i]);
        }
        
        for(int i = 0;i<n;i++){
            answer[i] = fun(arr[i], n);
        }
        
        
        return answer;
   }
    
    public static String fun(int num, int n){
        int d = (int)Math.pow(2,n);
        
        StringBuilder sb = new StringBuilder();
        while(d != 1){
            d /= 2;
            
            sb.append((int)num/d == 1 ? "#" : " ");//값 넣기
            num %= d;
        }
        return sb.toString();
        
        
    }
}
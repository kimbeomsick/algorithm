import java.util.*;

class Solution {
    public String solution(String s) {
        
        
        
        
        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);
        
        for( char ch : chArr){
            System.out.print(ch+" ");
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = chArr.length-1 ; i >=0;i--){
            sb.append(chArr[i]);
        }
        
        return sb.toString();
    }
}
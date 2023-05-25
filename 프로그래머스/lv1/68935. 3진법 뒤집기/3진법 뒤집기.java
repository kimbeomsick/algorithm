import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        while(n >= 3){
            
            sb.append(n%3);
            n /=3;
        }
        sb.append(n);
        
        System.out.println(sb.toString());
        
        String str = sb.toString();
        int k = 3;
        
        
        int num = 1;
        for(int i = str.length()-1;i>=0;i--){
            answer += (str.charAt(i) - '0')*num;
            num *= k;
        }
        
        
        return answer;
    }
}
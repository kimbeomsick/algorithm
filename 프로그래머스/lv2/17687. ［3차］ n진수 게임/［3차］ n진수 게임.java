import java.util.*;


class Solution {
    static String[] strArr = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        
        StringBuilder sb = new StringBuilder();
        // 총 길이 m*(t-1)+p
        int idx = 0;
        while(sb.length() < (m*(t)+p)){
            sb.append(func(n,idx));
            idx++;
        }
        
        
        String str = sb.toString();
        System.out.println("str : "+str);
        sb = new StringBuilder();
        for(int i = 0;i<t;i++){
            sb.append(str.charAt(m*i+p-1));
        }
        
        
        
        
        return sb.toString();
    }
    
    
    
    // n진수로 idx 변환 
    public static String func(int n, int idx){
        if(n == 10){
            return strArr[idx];
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(true){
            if(idx < n){
                sb.insert(0,strArr[idx%n]);
                break;
            }
            
            sb.insert(0, strArr[idx%n]);
            idx /= n;
        }
        
        return sb.toString();
    }
}
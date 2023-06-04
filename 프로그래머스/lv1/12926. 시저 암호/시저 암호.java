import java.util.*;

// 소문자 : 97 ~ 122
// 대문자 : 65 ~ 90
// 공백 : 32

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i <  s.length();i++){
            int ch = (int)s.charAt(i);
            if(ch == ' '){
                sb.append((char)ch);
            }else{
                if(ch >= 'a' && ch <='z'){
                    if(ch+n > 'z'){
                        ch-=26;
                    }
                    sb.append((char)(ch+n));
                }else if(ch >= 'A' && ch <='Z'){
                    if(ch+n >'Z'){
                        ch -= 26;
                    }
                    sb.append((char)(ch+n));
                }
                
                
            
            }       
        }
      
        String answer = sb.toString();
        return answer;
    }
}
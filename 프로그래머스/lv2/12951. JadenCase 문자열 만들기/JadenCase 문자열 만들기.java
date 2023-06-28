import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == ' '){
                flag = true;
            }else if(i == 0 || flag ){ //띄어쓰기 다음에 만난 문자
                if(ch >= 97 && ch <= 122 ){
                    ch -= 32;    
                }
                flag = false;
            }else if(!flag&&(ch >= 65 && ch <= 90) ){ //문자 다음에 만난 문자
                ch += 32;
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}

 
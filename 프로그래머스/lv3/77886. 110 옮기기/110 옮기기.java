import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb;
        
        for(int i = 0;i<s.length;i++){
            Stack<Character> stack = new Stack<>();
            int cnt = 0;
            String str = s[i];
            for(int j = 0;j<str.length();j++){
                char z = str.charAt(j);
                
                if(stack.size()>=2){
                    char y = stack.pop();
                    char x = stack.pop();
                    
                    if(x == '1' && y == '1' && z == '0'){
                        cnt++;
                    }else{
                        stack.push(x);
                        stack.push(y);
                        stack.push(z);
                    }
                }else{
                    stack.push(z);
                }
            }
            
            //그럼 0이 있는 배열인지 어떻게 확인하지?
        
            int idx = stack.size();
            boolean flag = false;
            sb = new StringBuilder();
            while(!stack.isEmpty()){
                if(!flag && stack.peek()=='1'){
                    idx--;
                }
                
                if(!flag && stack.peek() =='0'){
                    flag = true;
                }
                
                sb.insert(0,stack.pop());
            }
            
            if(cnt > 0){
                while(cnt > 0){
                    sb.insert(idx,"110");
                    cnt--;
                }
                answer[i] = sb.toString();
            }else{
                answer[i] = s[i];
            }
            
        }
        return answer;
    }
}
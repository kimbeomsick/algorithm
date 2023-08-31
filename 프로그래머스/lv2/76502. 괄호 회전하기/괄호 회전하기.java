import java.util.*;

//1. 배열의 크기만큼 회전하기
//2. stack에 담기 
//3. 괄호 제거해서 제일 큰 값 정하기 

class Solution {
    
    
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        Queue<Character> q = new LinkedList<>();
        for(int i = 0;i<len;i++){
            q.add(s.charAt(i));
        }
        
        for(int i = 0;i<len;i++){
            //회전하기
            char ch = q.poll();
            q.add(ch);
            int cnt = 0;
            Stack<Character> stack = new Stack<>();
            
            for(int j = 0;j<len;j++){
                char ch2 = q.poll(); // 하나 뽑음
                q.add(ch2);
                
                if(stack.isEmpty()){
                    stack.push(ch2);
                }else if(stack.peek() == '[' && ch2 == ']'){
                    stack.pop();
                }else if(stack.peek() == '{' && ch2 == '}'){
                    stack.pop();
                }else if(stack.peek() == '(' && ch2 == ')'){
                    stack.pop();
                }else{
                    stack.push(ch2);// 그냥 넣어버려!
                }
                
            }
                            if(stack.isEmpty()){
                                answer++;
                }

        }
        
        return answer;
    }
}
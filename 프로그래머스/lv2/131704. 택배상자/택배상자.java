import java.util.*;

class Solution {
    
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> q = new LinkedList<>();
    public int solution(int[] order) {
        int answer = 0;
        
        // 물건 초기화
        for(int i =1;i<=order.length;i++){
            q.add(i);
        }
        
        int idx = 0;
        while(true){
            if(!q.isEmpty()&& order[idx] == q.peek()){
                q.poll();
                answer++;
                idx++;
            }else if(stack.size() !=0&&stack.peek() == order[idx]){
                    stack.pop();
                    answer++;
                    idx++;    
            }else{
                stack.push(q.poll());
            }
            
            if(idx == order.length)break;
            if(q.isEmpty() && (stack.size()!=0 && stack.peek() != order[idx]))break;
            
            
        }            
        
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0;i < moves.length;i++){ // 0~7
          int line = moves[i]-1; // 몇번째 라인에 있는걸 꺼낼 것인지  line == column

            int pick = 0;
            for(int j  = 0; j < board.length ; j++){ //위에서 내려옴
                if(board[j][line] == 0) continue; // 집을게 없으면 넘어감
                
                int doll = board[j][line]; // 인형 집음
                board[j][line] = 0; //집어간 자리 빔
                if(stack.size() == 0){
                    stack.push(doll); // 넣기 
                }else{
                    if(stack.peek() == doll){ // 집어간거랑 동일하면
                        stack.pop();
                        answer += 2; 
                    }else{
                        stack.push(doll);
                    }
               }
        break;        
            }
            
         
        }
        return answer;
    }
}
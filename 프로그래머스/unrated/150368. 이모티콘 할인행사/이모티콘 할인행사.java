import java.util.*;

// 1. 이모티콘 플러스 가입자 증가 
// 2. 이모티콘 판매액 최대로 늘리기 

class Solution {
    static int sale_list[] = {40,30,20,10};
    static Stack<Integer> stack = new Stack<>();
    static int[] answer = new int[2]; //{플러스 가입자수, 이모티콘 판매액};
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        func(users,emoticons);        
        return answer;
    }
    
    
    static public void func(int[][] users, int[] emoticons){
        if(stack.size() == emoticons.length){
            calc(users, emoticons);
            return; 
        }
        
        
        
        for(int i = 0;i<4;i++){
            stack.push(sale_list[i]);
            func(users,emoticons);
            stack.pop();
        }
    }
    
    
    //계산하기
    static public void calc(int[][] users, int[] emoticons){
        int[] result = {0,0};
        
        //사람 
        for(int i = 0 ;i<users.length;i++){
            int sum = 0;
            
            // 살수 있는 이모티콘 계산
            for(int j = 0;j<emoticons.length;j++){ 
                int discount = stack.get(j);
                
                if(users[i][0] <= discount){ //내가 원하는 할인가보다 크거나 같으면 이모티콘 사는거임
                    sum += (emoticons[j]*(100-discount))/100;
                }
            }
            
            if (sum >= users[i][1]){
                result[0]++; //이모티콘 플러스 구매 
            }else{
                result[1]+=sum; //이모티콘 구매 가격 추가 
            }
        }
        
        if(result[0] > answer[0]){
            answer[0] = result[0];
            answer[1] = result[1];
        }else if(result[0] == answer[0]){
            answer[1] = Math.max(answer[1],result[1]);
        }
        
        
    }
}
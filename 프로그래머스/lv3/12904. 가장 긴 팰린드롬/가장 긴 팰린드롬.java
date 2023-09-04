import java.util.*; 

//앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬이라고 한다. 
// 제일구린 방법으로 풀기

class Solution{
    public int solution(String s){
        int answer = 0;
        
        char[] chArr = s.toCharArray();
        
        for(int i = 0;i<chArr.length;i++){
            
            //팰린드롬이 홀수일때
            int left = i-1;
            int right = i+1;
            int num = 1;
            while(left >= 0 && right < chArr.length){
                if(chArr[left] == chArr[right]){
                    num += 2;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
             answer = Math.max(answer,num);
            
            //짝수일 때
            left = i;
            right = i+1;
            num = 0;
            while(left >= 0 && right < chArr.length){
                if(chArr[left] == chArr[right]){
                    num += 2;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
             answer = Math.max(answer,num);
        }

        return answer;
    }
}
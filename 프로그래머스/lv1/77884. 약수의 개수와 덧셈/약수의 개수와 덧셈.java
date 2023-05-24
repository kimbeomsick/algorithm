class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int n = left; n <= right; n++){
            if(n == 1){
                answer--;
                continue;
            }
            
            int value = func(n);
            if(value %2 == 1){ //홀수
                answer -= n;
            }else{ //짝수
                answer += n;
            }
        }
        
        return answer;
    }
    
    
    //약수 찾기
    public static int func(int num){
        
        int result = 0;
        for(int i = 1;i*i <= num ;i++){
            if(num % i == 0) result+=2; //한쌍이 되기 때문에 +2
            
            if(i*i == num ) result++; //하나만 존재하기 때문에 +1
            
        }
        
        return result;
    }
}
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
   
        for(int i = 1;i<= number;i++){
            int num = primary(i);
            
            if( limit < num){
                answer+=power;
            }else{
                answer+=num;
            }
        }
        
        return answer;
    }
    
    public static int primary(int num){
        if (num == 1) return 1;
        
        int result = 0;
        for(int i = 1;i*i <= num;i++){
            if(i*i == num){
                result ++;
            }else if(num%i == 0){
                result += 2;
            }
        }
         return result;
    }
}
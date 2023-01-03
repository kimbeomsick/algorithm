class Solution {
    public int solution(int storey) {
        //결과
        int answer = 0;
        
        //주어진 값이 0이 되기 전까지      
        while (storey != 0) {
            //10의 자리수
            int upperNumber = (storey %100)/10;
            //1의 자리수 
            int number = storey % 10;
            
            //10의 자리수가 
            if (number > 5 || number == 5 && upperNumber>=5) {
                storey += 10; // 올림 값이 된다. 
                answer += (10 - number);
            } else {
                answer += number; //그냥 더해준다. 
            }
            storey = storey / 10; // 1의자리숫자 삭제 
        }  
        return answer;
    }
}
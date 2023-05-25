class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int zero = 0;
        int[] numbers = new int[50]; // 로또 번호 저장
        for(int i = 0;i<lottos.length;i++){
            if(lottos[i] == 0){
                zero++; //0의 갯수 증가 
            }else{
                numbers[lottos[i]]++;
            }
        }
        
        
        int result = 0; // 몇개나 일치하는지 확인 
        for(int i = 0;i<win_nums.length;i++){
            int num = win_nums[i];
           if(numbers[num] != 0 ){
               result++;
           }
        }
        
        
        int ranking[] = {6,6,5,4,3,2,1};
        int[] answer = {ranking[result+zero] ,ranking[result]};
        return answer;
    }
    
    
}
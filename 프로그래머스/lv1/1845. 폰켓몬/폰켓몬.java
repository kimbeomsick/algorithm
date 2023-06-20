class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int[] arr = new int[200001]; //포켓몬 종류 배열
        for(int i = 0;i<nums.length;i++){
            arr[nums[i]]++;
            
        }
        
        int result = 0;
        answer = nums.length/2; // 가질수 있는 포켓몬
        for(int i = 0;i<arr.length;i++){
            if(arr[i] > 0){
                result++;
                answer--;
            }
            if(answer == 0)break;
        }
            
            
        
        
        
        return result;
    }
}
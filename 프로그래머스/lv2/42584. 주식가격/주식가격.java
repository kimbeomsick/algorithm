class Solution {
    public int[] solution(int[] prices) {
        
        int size = prices.length;
        boolean visited[] = new boolean[size];
        
        int[] answer = new int[size];
        
        for(int i = 0;i<size-1;i++){
            for(int j = i+1;j<size;j++){
                answer[i]++;
                if(prices[i] <= prices[j]){
                    continue;
                }else{
                    break;
                }
            }
        }
        return answer;
    }
}
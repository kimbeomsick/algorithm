import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        Collections.sort(list);
        
        for(int i = 0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        if(list.size() == 0){
            return new int[]{-1};
        }
        
        
        
        return answer;
    }
}
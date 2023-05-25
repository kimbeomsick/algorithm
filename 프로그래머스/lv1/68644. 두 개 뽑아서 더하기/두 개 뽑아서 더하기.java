import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        
        int result[] = new int[201];
        
        int size = numbers.length;
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(i == j) continue;
                result[numbers[i]+numbers[j]]++;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<result.length;i++){
            if(result[i] == 0) continue;
            list.add(i);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
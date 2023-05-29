import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer ;
        
        ArrayList<Integer> list  = new ArrayList<>();
        list.add(arr[0]);
        
        System.out.println(arr.length);
        
        int idx = 0;
        for(int i = 1;i<arr.length;i++){
            if(list.get(idx) == arr[i]) continue;
            list.add(arr[i]);
            idx++;
        }
        answer = new int[list.size()]; // 사이즈 늘리기 
        System.out.println(list.size());
        for(int i = 0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        
        return answer;
    }
}
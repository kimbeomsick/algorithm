import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
       
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        
        int high1 = 0;
        int high2 = 0;
        int high3 = 0;
        
        for(int i = 0;i<answers.length;i++){
            if(answers[i] == arr1[i%arr1.length]){
                high1++;
            }
            
            if(answers[i] == arr2[i%arr2.length]){
                high2++;
            }
            
            if(answers[i] == arr3[i%arr3.length]){
                high3++;
            }
        }
        
        int highest = ((high1 > high2) ? high1 : high2) > high3 ?  ((high1 > high2) ? high1 : high2) : high3;
        ArrayList<Integer> list = new ArrayList<>();
        
        if(highest == high1){
            list.add(1);
        }
        if(highest == high2){
            list.add(2);
        }
        if(highest == high3){
            list.add(3);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}
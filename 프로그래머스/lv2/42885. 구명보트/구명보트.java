import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int end = people.length-1;
        
        Arrays.sort(people);
        
        while(start <= end){
            
            if(start == end){
                // System.out.println("here3");
                answer++;
                break;
            }
            
            //이러면 큰쪽에서 내려와야함
            if(limit < people[start] + people[end]){
            // System.out.println("here1");    
                end--;
            }else if(limit >= people[start] + people[end]){
                // System.out.println("here2");
                start++;
                end--;
            }
            
            answer++;
        }
        
        return answer;
    }
}
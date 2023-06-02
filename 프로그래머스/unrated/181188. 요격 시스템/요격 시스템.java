import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 끝나는지점으로 부터 요격 
        Arrays.sort(targets, (a,b)-> a[1]-b[1]);
        int cut = 0;
        for(int i = 0;i<targets.length;i++){
            if(targets[i][0] >= cut){
                answer++;
                cut = targets[i][1];
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int L = 0;
        int S = 0;
        
        for(int i = 0;i<sizes.length;i++){
            int large = Math.max(sizes[i][0], sizes[i][1]);
            int small = Math.min(sizes[i][0], sizes[i][1]);
            
            L = Math.max(large,L);
            S = Math.max(small,S);
            
        }
        
        int answer = L*S;
        return answer;
    }
}
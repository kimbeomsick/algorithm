import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
        Arrays.sort(citations);
            
        for(int i = 0;i<citations[size-1];i++){ // 제일 작은수 부터 최대큰 수까지
            int cnt = 0;
            int idx = size-1;
            while(idx >= 0 && citations[idx] >=i  ){ // 몇개나 할 수 있을까?
                cnt++;
                idx--;
            }
            
            if(i <= cnt){
                answer = Math.max(answer,i);
            }
                
        }
        return answer;
    }
}
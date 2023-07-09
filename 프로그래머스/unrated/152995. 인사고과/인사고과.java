import java.util.*;


// 1. (근무 태도 점수, 동료 평가)
// 2. 자기보다 높은 점수 합을 가진 사람 answer++;
// 3. 근무 태도 내림차순 + 동료평가 오름차순
// 4. for문을 돌면서 동료 평가 최고 값 갱신, 최고 값보다 동료평가가 낮다면 인센티브 못받음 
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        
        int a = scores[0][0];
        int b = scores[0][1];
        
        Arrays.sort(scores, (o1, o2) -> {
        if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        
        
        int max_score = scores[0][1];
        
        for(int i =0 ;i<scores.length;i++){
            if(a < scores[i][0]&& b < scores[i][1]){
                return -1;
            }
        }
        
        for(int i =0 ;i<scores.length;i++){
            if(max_score <= scores[i][1] && a+b < scores[i][0]+scores[i][1]){
                max_score = scores[i][1];
                answer++;
            }
        }
        
         
        return answer;
    }
}
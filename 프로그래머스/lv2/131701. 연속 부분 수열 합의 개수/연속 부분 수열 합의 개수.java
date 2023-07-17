import java.util.*;

// 1. 연속하는 부분 수열의 합으로만들 수 있는 숫자


class Solution {
    
    static Set<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        
        for(int i = 0;i<len;i++){//위치
            for(int j = 1;j<=len;j++){ //개수
                int num = 0;
                for(int k = 0;k<j;k++){ 
                    num += elements[(i+k)%len];                    
                }
                set.add(num);
            }
        }
                
        
        return set.size();
    }
}
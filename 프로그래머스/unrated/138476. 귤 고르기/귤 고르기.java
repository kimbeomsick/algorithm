import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int size = 10000001;
        int arr[] = new int[size];
        for(int i = 0;i<tangerine.length;i++){
            arr[tangerine[i]]++; 
        }
        
        Arrays.sort(arr);
        
        
        int num =0 ;
        for(int i = size-1;i>=0;i--){
            num += arr[i];
            answer++;
            if(k <= num){
                return answer;
            }
        }
        return answer;
    }
}
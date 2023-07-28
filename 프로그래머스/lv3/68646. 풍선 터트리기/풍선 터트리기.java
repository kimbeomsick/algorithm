import java.util.*;

//나를 기준으로 오른쪽 원소 왼쪽 원소의 최소값을 찾아야 한다. 


class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        
        //오른쪽으로 가면서 최소값
        int[] min_right = new int[len];
        //왼쪽으로 가면서 최소값
        int[] min_left = new int[len];
        
        //각각의 최소값을 저장하기 위한 수 
        int right = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        
        
        //오른쪽 왼쪽으로 가면서 최소값 찾기
        for(int i = 0;i<len;i++){
            right = Math.min(right, a[i]);
            min_right[i] = right;
            
            left = Math.min(left,a[len-i-1]);
            min_left[len-1-i] = left;
        }        
        
        //최소 값이 있는가 
        for(int i = 0;i<len;i++){
            //좌우 둘다 나보자 작은 값이 존재 하는가?
            if(a[i] > min_left[i] && a[i] > min_right[i]){
                continue;
            }
            answer++;
            
        }
        
        
        
        return answer;
    }
}
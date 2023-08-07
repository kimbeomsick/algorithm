import java.util.*;



class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int len = cores.length; // 프로세스의 길이 
        
        n = n-len; // 0시간에 할 수 있는건 빼버림 
        int right = 0;
        for(int i = 0;i<len;i++){
            right = Math.max(right, cores[i]); // 제일 큰 값 찾기 
        }
        
        // 시간을 작업을 n번하기 위한 시간을 찾아라 
        int left = 1 ;
        right = right * (n/len);
        
        while(left+1 < right){
            int mid = (left+right)/2;
            int mid_work = work(mid,cores);
            
            if(mid_work <= n){
                left=mid;
            }else{
                right=mid+1;
            }
        }
        
        // left는 시간임 그 시간에 할 수 있는 작업량이 같은지 확인해야함 
        if(work(left, cores) == n){ //해당시간에 작업을 모두 끝낼 수 있다면.. 
            for(int i = len-1;i>=0;i--){
                if(n/cores[i] == 0){
                    return i+1;
                }
            }
        }else{ // 작업을 전부 끝내지 못하면.. 
            int cnt =n - work(left,cores);
            for(int i = 0;i<len;i++){
                if(n/cores[i] == 0){
                    cnt--;    
                }
                
                if(cnt == 0){
                    return i;
                }
            }
        }
            
        
        
        return left;
    }
    
    // time에 할 수 있는 작업량 찾기
    public static int work(int time, int[] cores){
        int result = 0;
        for(int i = 0;i<cores.length;i++){
            result += time/cores[i];
        }
        return result;
    }
}
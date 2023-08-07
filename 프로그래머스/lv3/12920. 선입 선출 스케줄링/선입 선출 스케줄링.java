 import java.util.*;



class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int len = cores.length; // 프로세스의 길이 
        
        
        int right = 0;
        for(int i = 0;i<len;i++){
            right = Math.max(right, cores[i]); // 제일 큰 값 찾기 
        }
        
        // 시간을 작업을 n번하기 위한 시간을 찾아라 
        int left = 0 ;
        right = right * (n/len);
        
        int working_cnt = 0;
        System.out.printf("left:%d  right:%d\n",left,right);
        while(left+1 < right){
            int mid = (left+right)/2;

            if(work(mid,cores) >= n){ // mid시간의 작업량이 찾는거랑 같거나 더 크면 
                right = mid; //큰쪽이 내려온다. 
                    
            }else{
                left = mid;
            }
        }
        
        System.out.printf("right : %d\n",right);
        
        // 내가 비교할 작업시간은 right
        
        int cnt = work(right,cores) - n; // 실제 작업량과 내가 찾은 시간의 작업량이 얼마나 차이나는지 확인         
        for(int i = cores.length-1;i>=0;i--){
            if(right%cores[i] == 0){
                if(cnt == 0){
                    return i+1;
                }else{
                    cnt --;    
                }
                
            }
        
        }
        
        
        
        
        
        
        
        return 0;
    }
    
    // time에 할 수 있는 작업량 찾기
    public static int work(int time, int[] cores){
        if(time == 0){ //작업 시간이 0시간이면 
            return cores.length;
        }
        
        int result = 0;
        for(int i = 0;i<cores.length;i++){
            result += time/cores[i];
        }
        return result+cores.length;
    }
}
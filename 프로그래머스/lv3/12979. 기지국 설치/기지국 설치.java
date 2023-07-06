import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int len = w*2+1;
        
        int idx= 1;
        for(int i = 0;i<stations.length;i++){
            int num = stations[i] - w - idx; // 기지국 사이의 빈공간 
            idx = stations[i]+w+1; //다음 빈공간 스타트 
            
            
            if(num > 0 ){
                if(num%len != 0){
                    answer+=1;
                }
                answer += num/len;
            }
            if(idx >= n) break; //다음 빈공간 배열 크기를 넘어가면 안됨 
        }
        
        
        if(stations[stations.length-1]+w <n){
            
     
        int num = n - (stations[stations.length-1]+w);
        
        if(num%len != 0){
                    answer+=1;
                }
                answer += num/len;
    }

        return answer;
    }
}
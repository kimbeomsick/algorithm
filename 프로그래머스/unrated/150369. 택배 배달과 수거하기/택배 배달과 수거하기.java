import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        //제일 뒤의 위치 찾기 
        int a = 0;
        int b = 0;
        for(int i = deliveries.length-1;i>=-1;i--){
            if(i == -1){
                a = -1 ;
                break;
            }
            if(deliveries[i] !=0 ){
                a = i;
                break;
            }
        }
        
        for(int i = pickups.length-1;i>=-1;i--){
            if(i == -1){
                b = -1 ;
                break;
            }
            if(pickups[i] !=0 ){
                b = i;
                break;
            }
        }
        
        while(a != -1 || b != -1){
            //둘중 더 멀리 있는 곳까지 다녀와야함 
            answer += ((a > b ? a : b)+1)*2;
            
            //캡으로 뒤에서 부터 배달할때 어디까지 배달 가능한지 
            int num = cap;
            while(a >= 0){
                if(num >= deliveries[a]){
                    num -= deliveries[a];
                    a--;
                }else{
                    deliveries[a] -= num;
                    break;
                }
            }
            
            //캡으로 수거할 때 어디까지 수거 가능한지 
            num = cap;
            while(b >= 0){
                if(num >= pickups[b]){
                    num -= pickups[b];
                    b--;
                }else{
                    pickups[b] -= num;
                    break;
                }
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
       int answer[] = new int[starts.length];
        
        Point dp[] = new Point[e+1];
        
        //모든 약수 초기화 
        for(int i = 0;i<=e;i++){
            dp[i] = new Point(i,1);
        }
        
        //억억에서 몇번이나 출현하는지 구하기 
        for(int i = 2;i<=e;i++){
            for(int j = i;j<=e;j+=i){
                dp[j].cnt++;
            }
        }
        
        //1. cnt 내림차순 2. num 오름차순
        Arrays.sort(dp,(a,b)->{
            if(a.cnt == b.cnt){
                return a.num - b.num;
            }else{
                return b.cnt - a.cnt;
            }
        });
            
        for(int i = 0;i<starts.length;i++){
            for(int j = 0;j<=e;j++){
                if(starts[i] <= dp[j].num){
                    answer[i] = dp[j].num;
                    break;
                }
            }
        }
        
        
        return answer;
        
    }
    
  static class Point{
      int num;
      int cnt;
    public Point(int num, int cnt){
          this.num = num;
          this.cnt = cnt;
      }
  }

}
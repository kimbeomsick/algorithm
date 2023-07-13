import java.util.*;


class Solution {
    
    static boolean[] visited;
    public int solution(int[] cards) {
        int answer = 0;
        
        
        int a =1;
        int b =1;
        for(int i = 1;i<=cards.length;i++){
            visited = new boolean[cards.length+1];    
            a = func(cards,i);
            for(int j = i+1;j<=cards.length;j++){
                if(!visited[j]){
                    b = func(cards,j);
                    // System.out.printf("(%d,%d)\n",a,b);
                    answer = Math.max(a*b,answer);
                }
            }
        }
        
        return answer;
    }
    
    public static int func(int[] cards,int idx){
        int cnt = 0;
        while(true){
            if(!visited[idx-1]){
                visited[idx-1] = true;
                cnt++;
                idx = cards[idx-1];
            }else{
                break;
            }
        }
        
        return cnt;
    }
}
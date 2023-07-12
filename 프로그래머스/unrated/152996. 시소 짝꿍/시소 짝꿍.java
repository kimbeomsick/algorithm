import java.util.*;


class Solution {
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visited ;
    static long answer = 0;
    public long solution(int[] weights) {
        
        
        visited = new boolean[weights.length];
        func(0,0,weights);
        return answer;
    }
    
    public static void func(int idx , int depth, int[] weights){
        if(depth == 2){
            if(isCollect())answer++;
            return ;
        }
        
        for(int i = idx;i<weights.length;i++){
            if(!visited[i]){
                visited[i] = true;
                stack.push(weights[i]);
                func(i+1, depth+1,weights);
                stack.pop();
                visited[i] = false;
            }
            
        }
    }
    
    public static boolean isCollect(){
        
        if(stack.get(0) == stack.get(1))return true;
        
        
        for(int i = 2;i<=4;i++){
            for(int j = 2;j<=4;j++){
                if(i != j){
                    if(stack.get(0)*i == stack.get(1)*j){
                      System.out.printf("%d * %d === %d * %d\n",stack.get(0),i,stack.get(1),j);
                        return true;
                    } 
                }        
            }
        }
        
        return false;
    }
}
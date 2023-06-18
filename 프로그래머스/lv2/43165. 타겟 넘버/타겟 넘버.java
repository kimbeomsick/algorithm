import java.util.*;

class Solution {
    static int result = 0;
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        int size = numbers.length;
        dfs(target, 0, 0 ,size, numbers);
        return result;
    }
    
    
    public static void dfs(int target, int depth, int sum, int size, int[] numbers){
        if(depth == size){
            if(target == sum){
                result++;
            }
            return;
        }
        
            dfs(target, depth+1, sum - numbers[depth], size, numbers);
            dfs(target, depth+1, sum + numbers[depth], size, numbers);
        
    }
}
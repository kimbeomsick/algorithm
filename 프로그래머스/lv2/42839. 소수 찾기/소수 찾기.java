import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static int arr[];
    static boolean visited[];
    static int answer = 0;
    public int solution(String numbers) {
        
        int size = numbers.length();
        //초기화
        arr = new int[size];
        visited = new boolean[size];
        
        
        for(int i = 0;i<size;i++){
            arr[i] = numbers.charAt(i) - '0';
        }
        
        System.out.println(primary(1));

        
        dfs(size, 0, 0);
        return set.size();
    }
    public static void dfs(int size, int num, int depth){
        
        if(primary(num)){
        set.add(num);
        }
        if(depth == size) return ;
                
        for(int i = 0;i<size;i++){
            if(!visited[i]){ //방문하지 않았다면
                visited[i] = true;
                dfs(size, num*10 + arr[i], depth+1);
                visited[i] = false;
            }    
        }
    }
    
    //소수 판별 함수
    public static boolean primary(int num){
        if(num == 0 || num == 1){
            return false;
        }
        
        for(int i = 2;i*i <= num;i++){
            if(num %i == 0){
                return false;
            }
        }
        return true;
    }
}
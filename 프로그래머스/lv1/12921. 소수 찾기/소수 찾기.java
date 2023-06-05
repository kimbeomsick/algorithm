import java.util.*;

class Solution {
   static ArrayList<Integer> list = new ArrayList<>();
    public int solution(int n) {
        
        list.add(2);
        for(int i = 3;i <= n;i++){
            if(func(i)){
                
                list.add(i);
            }
        }
        
        return list.size();
    }
    
    public static boolean func(int num){
        
        
        for(int j = 0 ; j < list.size() ;j++){ // 1은 너무 자명한거라 빼버림
            int i = list.get(j);
            if(num%i == 0) return false; //나눠지면 탈출
            if(i*i > num) break; //제곱근을 넘어가면 탈출
        }
        return true;
    }
}
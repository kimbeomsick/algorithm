import java.util.*;

class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;i*i <= n;i++){
            if(i*i == n){
                list.add(i);
            }else if(n % i == 0){
                list.add(i);
                list.add(n/i);
            }
        }
        
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
            answer+= list.get(i);
        }
        
        
        
        return answer;
    }
}
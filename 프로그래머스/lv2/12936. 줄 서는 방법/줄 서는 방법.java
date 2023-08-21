import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        ArrayList<Integer> list = new ArrayList<>();
        //1부터 n까지 숫자를 넣어 사용할 숫자를 담아둠
        for(int i = 1;i<=n;i++){
            list.add(i);
        }
        
        for(int i = n;i>=1;i--){
            long fac = factorial(i-1);// 펙토리얼 계산
            
            if(k == 0){ // 만약 k가 없다면 뒤에서 부터 넣음 
                answer[n-i] = list.get(list.size()-1);
                list.remove(list.size()-1);
                continue;
            }
            
            if(k%fac == 0){ //나머지 없음 // 0~1 이라고 할 때 1 일경우 
                answer[n-i] = list.get((int)(k/fac) -1); // 몫에서 하나 빼서 넣음 
                list.remove((int)(k/fac) -1); // 넣은건 다시 못쓰니까 제외
            }else{ // 나머지 있음
                answer[n-i] = list.get((int)(k/fac)); // 나머지가 있다면 몫에서 1을 빼지 않음 
                list.remove((int)(k/fac)); //사용한거는 마찬가지로 list에서 제외
            }
            k %= fac;
        }
        return answer;
    }
    
    
    //펙토리얼 구하는 함수 
    static public long factorial(int n){
        if(n == 0){
            return 1;
        }else{
            return n*factorial(n-1);
        }
        
    }
}
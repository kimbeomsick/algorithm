import java.util.*;

// 1. n워 10일동안 회원
// 2. 1가지 할인 1개만 살 수 있음 
// 3. 원하는 제품과 수량이 할인하는 날짜와 10이 ㄹ연속으로 일치하는 경우 회원가입
// 4. 원하는 제품을 모두 할인받을 수 있는 회원등록 날짜의 총 일수 return 

class Solution { 
    static Map<String,Integer> map = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        //장바구니 초기화
        for(int i = 0;i<want.length;i++){
            map.put(want[i], number[i]);
        }
        
        for(int i = 0;i<discount.length;i++){
             String str = discount[i];
                if(map.containsKey(str)){ //내가 원하는 목록에 있다면 
                    map.put(str,map.get(str)-1); // 하나 산거임 
                }
   
                if(i>=10){
                    if(map.containsKey(discount[i-10])){ //10일전에껀 못삼
                        map.put(discount[i-10], map.get(discount[i-10]) + 1 );
                    }

                    
                }
            
            if(i>= 9){
                if(func()){ //장바구니에 있는거 전부 샀는가?
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
    
    // 장바구니에 있는거 전부 살수 있는가?
    static public boolean func(){
        boolean flag = true;    
        
        for(String str : map.keySet()){
            int num = map.get(str);
            if(num > 0){
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}
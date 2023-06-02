import java.util.*;

class Solution {
    static     ArrayList<Integer> list = new ArrayList<>();
    public int solution(String dartResult) {
        
    
        
        
        int num = 0; // 숫자를 담을 변수
        int idx = 0; // 몇개까지 담겼는지 확인하는 index 변수
        boolean cut = false;
        for(int i = 0;i<dartResult.length();i++){
            char ch = dartResult.charAt(i);
            
            if( ch-'0' >=0 && ch-'0' < 10){ //숫자로 판명나면 
                if(cut){
                    list.add(num); // 숫자 삽입 
                    num = 0;
                    cut = false;
                    idx++;
                }
                
                num = num*10 + ch-'0';
            }else{ // 문자라면
                if(!cut){
                  cut = true; // 다음에 숫자오면 걸리게 장치 해둠
                System.out.println("num : "+ num);
                } 
                num = func(num, ch, idx);
                   
            }
            
            if(i == dartResult.length()-1){
                list.add(num);
            }
            
        }
        
        int answer = 0;
        
        for(int i = 0;i<list.size();i++){
            int value = list.get(i);
            System.out.print(value+" ");
            answer += value;
        }
        return answer;
    }
    
    public static int func(int num, char ch, int idx){
        switch(ch){
            case 'S':
                return num;
                case 'D':
                return num*num;
                case 'T':
                return num*num*num;
                case '*':
                if(idx > 0){
                    list.set(idx-1,list.get(idx-1)*2); // 앞에 있는 값 *2 해줌 
                }
                return num*2;
                case '#':
                return num*(-1);
            default:
                return num;
        }
    }
}
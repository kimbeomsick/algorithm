import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int [] numbers = new int[10]; // 0~9 까지 있는 배열
        
        //문자열에 각 숫자가 몇개씩 있는지 확인
        for(int i = 0;i < X.length(); i++){
            int n = X.charAt(i) - '0';
            
            numbers[n] ++; 
        }
        
        boolean zeroFlag = true;
        
        for(int i = 0;i<Y.length();i++){
            int n = Y.charAt(i)-'0';
            
            if(numbers[n] > 0){ // 0 아니라면
                list.add(n);
                numbers[n]--;
                if(n != 0 ) zeroFlag = false; // 0만 담긴게 아니라는 의미 
            }
        }
        
        //아무것도 담기지 않았다면
        if(list.size() == 0){
            return "-1";
        }
        
        
        // 0만 담겼다면
        if(zeroFlag){
            return "0";
        } 
        
        StringBuilder sb = new StringBuilder();
        
        Collections.sort(list);
        
        int answer = 0;
        for(int i = list.size()-1;i>=0;i--){
            sb.append(list.get(i));
        }        
        
        return sb.toString();
    }
}
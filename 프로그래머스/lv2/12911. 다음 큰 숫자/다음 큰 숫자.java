import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = Integer.toBinaryString(n);
        int oneCnt = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == '1'){
                oneCnt++;
            }
        }
        if(oneCnt == str.length()){
            return allOne(str.length());
        }
        
        while(true){
            str = Integer.toBinaryString(++n);
            
            int cnt = 0;
            for(int i = 0;i<str.length();i++){
                if(str.charAt(i) == '1'){
                    cnt++;
                }   
            }
            if(cnt == oneCnt){
                break;
            }
            
        }
        
        return n;
    }
    
      //전부 1일 때 계산하기
    public static int allOne(int size){ //이 size는 배열의 길이임!
        int result = 0;
        for(int i = 0;i<=size;i++){
            if(i == size-1) continue;
            result += Math.pow(2,i);
        }
        
        return result;
    }
}
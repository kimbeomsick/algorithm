import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        
        for(int i = 1;i<=s.length();i++){ //압축할 단위
            answer = Math.min(answer, compress(i,s));
        }
        
        return answer;
    }
    
    static public int compress(int len, String s){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int cnt = 1;
        String origin = s.substring(idx,idx+len), compare;
        
        while(true){
            idx += len;
            if(idx+len <= s.length()){
                compare = s.substring(idx,idx+len);    
            }else{
                if(cnt == 1){
                    sb.append(origin).append(s.substring(idx));    
                }else{
                    sb.append(cnt).append(origin).append(s.substring(idx));    
                }
                
                break;
            }
            
                        
            if(origin.equals(compare)){
                cnt++;
            }else{
                if(cnt == 1){
                    sb.append(origin);
                    origin = compare;
                }else{
                    sb.append(cnt).append(origin);
                    origin = compare;
                    cnt = 1;
                }
            }
        }
        // System.out.printf("len:%d => %s \n",len,sb.toString());
        return sb.toString().length();
    }
}
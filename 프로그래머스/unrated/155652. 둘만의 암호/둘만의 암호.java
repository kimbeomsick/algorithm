import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        
        int[] arr = new int[200]; //스킵할거 저장해둠
        for(int i = 0;i<skip.length();i++){
            int num = (int)skip.charAt(i); //숫자로 변환
            arr[num]++; //스킵할거 알려줌
        }
        
        //정답 저장
        StringBuilder sb = new StringBuilder();
        
        
        
        for(int i = 0;i<s.length();i++){ //모든 문자를 돈다
            char ch = s.charAt(i); // 뒤로 밀어야할 문자 
            
            int newCh = (int)ch;//뒤로 밀리는 값 찾기
            int cnt = index; //5

            while(cnt > 0){ // 이 순서를 제일 조심해야함
                
                newCh++; //다음 값 확인
                
                if(newCh > 122){ //z가 넘어가면 추가
                    newCh -= 26;
                }
                
                if(arr[newCh] == 0) { //스킵여부 확인
                    cnt--;
                }
            }
            sb.append((char)newCh);
        }
        
        
        
        return sb.toString();
    }
}
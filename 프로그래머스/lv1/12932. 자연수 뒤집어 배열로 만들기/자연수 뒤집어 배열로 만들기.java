import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        StringBuilder sb = new StringBuilder();
        String str = Long.toString(n);
        
        int size = str.length();
        int[] answer = new int[size];
        for(int i = 0; i<size;i++){
            answer[size-1-i] = str.charAt(i)-'0';
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int R = wallpaper.length;
        int C = wallpaper[0].length();
        int[] answer = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        
        for(int r = 0 ;r < R;r++){
            for (int c = 0; c<C;c++){
                if(wallpaper[r].charAt(c) == '#'){
                    
                    
                    answer[0] = Math.min(answer[0],r);
                    answer[1] = Math.min(answer[1],c);
                    answer[2] = Math.max(answer[2],r+1);
                    answer[3] = Math.max(answer[3],c+1);
                }
            }
        }
        
       
    
        
        
        return answer;
    }
}
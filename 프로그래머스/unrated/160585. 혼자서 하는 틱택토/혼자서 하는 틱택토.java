import java.util.*;

class Solution {
    public int solution(String[] board) {
        
        //0 표시가 있는가?
        // x표시가 있는가?
        //하나만 3개 인가?
        //둘의 갯수 차이가 0~1 인가?
        
        
        int O = 0;
        int X = 0;
        
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length();j++){
                char ch = board[i].charAt(j);
                if(ch == 'O') O++;
                if(ch == 'X') X++;
            }
        }
        
        if(Math.abs(O-X) > 1) return 0; // 차이가 1 이상 나면 안됨 
        if(O < X) return 0; // x가 더 많으면 안됨
        if(O == 0 && X == 0) return 1; // 둘다 0 가능
        
        char ch = fun(board); // 승자 출력
        if(ch == 'O' && X >= O) return 0;
        if(ch == 'X' && X < O) return 0;
        if(ch == 'B') return 0;
        if(ch == 'N') return 1;
        
        
        
        
       
        
        
        int answer = 1;
        return answer;
    }
    
    public static char fun(String[] board){
        
        char win = ' ';
        int X = 0;
        int O = 0;
        //가로
        for(int i = 0;i<3;i++){
            int num = 0;
            for(int j = 0;j<3;j++){
                char ch = board[i].charAt(j);
                if(ch == 'O') num++;
                if(ch == 'X') num--;
            }
            if(num == 3){
                O++;
                
            } 
            if(num == -3){
                X++;
            }
            
            num = 0;
            for(int j = 0;j<3;j++){
                char ch = board[j].charAt(i);
                if(ch == 'O') num++;
                if(ch == 'X') num--;
            }
             if(num == 3){
                O++;
                
            } 
            if(num == -3){
                X++;
            }
        }
        // 아직 승자를 못찾았다면 대각선을 확인하자
            
            int num = 0;
            for(int i = 0;i<3;i++){
                char ch = board[i].charAt(i);
                if(ch == 'O') num++;
                if(ch == 'X') num--;
            }
             if(num == 3){
                O++;
                
            } 
            if(num == -3){
                X++;
            }
            
            num = 0;
            for(int i = 0;i<3;i++){
                char ch = board[2-i].charAt(i);
                if(ch == 'O') num++;
                if(ch == 'X') num--;
            }
             if(num == 3){
                O++;
                
            } 
            if(num == -3){
                X++;
            }
            
            
        if(X >= 1 && O == 0) return 'X';
        if(X == 0 && O >= 1) return 'O';
        if(X >= 1 && O >= 1) return 'B';
        if(X == 0 && O == 0) return 'N';
        
        return 'N';
        
    }    
}

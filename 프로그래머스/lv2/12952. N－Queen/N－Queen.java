class Solution {
    
    static int[] board;
    static int answer;
    public int solution(int n) {
        
        board = new int[n];        
        func(0,n);
        return answer;
    }
    
    public static void func(int idx, int n){
        if(idx == n){
            answer++;
            return;
        }
        
        for(int i = 0;i<n;i++){
            board[idx]= i;
            if(check(idx)){
                func(idx+1,n);
            }
        }
    }
    
    public static boolean check(int idx){
        for(int i = 0 ;i<idx;i++){
            if(board[i] == board[idx]) return false;
            if(Math.abs(i-idx) == Math.abs(board[i] - board[idx])) return false;
        }
        return true;
    }
}
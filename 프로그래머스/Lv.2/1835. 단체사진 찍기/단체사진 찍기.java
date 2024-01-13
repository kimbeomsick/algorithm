class Solution {
    
    static char[] charArr = {'A','C','F','J','M','N','R','T'};
    static boolean[] visited = new boolean[8];
    static int answer = 0;
    public int solution(int n, String[] data) {
        answer = 0;
        
        func(0,"",data);
        return answer;
    }
    
    static public void func(int depth, String sum, String[] data){
        if(depth == 8){
            if(check(sum,data)){
                answer++;
            }
            return ;
        }
        
        for(int i = 0;i<8;i++){
            if(!visited[i]){
                visited[i] = true;            
                func(depth+1,sum+charArr[i], data);
                visited[i] = false;
            }
        }
    }
    
    static public boolean check(String sum, String[] data){
        for(int i = 0;i<data.length;i++){
            
            char start = data[i].charAt(0);
            char end = data[i].charAt(2);
            char condition = data[i].charAt(3);
            int len = data[i].charAt(4)-'0';
            // System.out.println(start+" "+end+" "+condition+ " "+len);
            
            int a = sum.indexOf(start);
            int b = sum.indexOf(end);
            
            if(condition == '=' && (Math.abs(a-b)-1 == len)) continue;
            if(condition == '>'&& (Math.abs(a-b)-1 > len)) continue;
            if(condition == '<' && (Math.abs(a-b)-1 < len)) continue;
            return false;
            
        }
        
        
        return true;
    }
}
class Solution {
    
    static char[] strArr = {'A', 'E','I','O','U'};
    static int answer = -1;
    static int cnt = -1;
    public int solution(String word) {
        
        dfs("",word, 0);
        return answer;
    }
    public static void dfs(String str, String word, int depth){
        cnt++;
        // System.out.printf("%d,  %s\n",cnt, str);
        if(str.equals(word)){
            answer = cnt;
        }
        
        
        if (answer != -1 || depth > 4){
            return;
        }
        
        for(int i = 0;i<strArr.length;i++){
            dfs(str+strArr[i],word,depth+1);
        }
    }
    
    
}
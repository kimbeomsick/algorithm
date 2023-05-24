class Solution {
    
    static int answer = 0;
    
    public int solution(int[] number) {
        
        
        
        
        dfs(number, 0,0,0);
        return answer;
    }
    


public static void dfs (int[] number, int idx, int depth ,int sum){
    if(depth == 3){ //3총사 선택함
        if(sum == 0){ //셋의 합이 0이면 삼총사 
            answer++;
        }
        return;
    }
    
    for(int i = idx ; i<number.length;i++){
        //겹치지 않기 위해 깊이우선 탐색 진행
        dfs(number, i+1, depth+1, sum + number[i]);
    }
    
    
    
}
    
}



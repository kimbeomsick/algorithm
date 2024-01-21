import java.util.*;

class Solution {
    static boolean[] visited; // 다들렸는지 확인하는 배열
    static ArrayList<Integer> []list;
    static int answer = 0;
    public int solution(int n, int[][] lighthouse) {
        visited = new boolean[n+1]; // 1~n 까지 보기
        
        
        //링크드 리스트 초기화
        list = new ArrayList[n+1];
        for(int i = 0;i<=n;i++){
            list[i] = new ArrayList<Integer>();
        }
        
        
        int len = lighthouse.length;
        for(int i = 0;i<len;i++){ //몇번이 몇번 나왔는지 넣기 
            int a =lighthouse[i][0];
            int b =lighthouse[i][1];
            
            //양방향
            list[a].add(b);
            list[b].add(a);
        }
        
        func(1,0);
        return answer;
    }
    
    public static int func(int curr, int before){
        // 1. 사이즈가 1
        // 2. 이전값이랑 마지막 남은게 동일함 
        if(list[curr].size() == 1 && list[curr].get(0) == before){
            return 1; //이걸 리턴했다는건 안키겠다는거임 
        }  
        
        int sum = 0;
        for(int i = 0;i<list[curr].size();i++){
            int next = list[curr].get(i);
            if(before == next) continue;
            sum += func(next,curr);  // 다음거 긁어오기 
        }
        
        if(sum == 0){
            return 1; //자식이없기 때문에 나 안켜요 엄니가 켜주세요 
        }else{
            answer++;
            return 0; //나 켰으니까 자식취급 하지 말아주세요 return 0
        }
        
    }
    
 
    
}
import java.util.*;

//0 점과 제일 가까워지는 게임
// 남들보다 점수가 크면 실격
// 먼저 0만들기 > 싱글 or 불이 많이 > 선공
// 0을 먼저 만들기 위해 던지고 싱글 or 불을 많이 던저야 한다. 

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static int[] answer= new int[2];
    public int[] solution(int target) {
        
        
        // 1~20의 숫자가 있음 
        // 최선의 경우로 다트를 던진다. 
        // 아 .. 그러니까 6트리플 말고 18을 던지라 이거구나 
        //set에 넣어보자 
        set.add(50);
        for(int i = 1;i<=20;i++){
            for(int j = 1;j<=3;j++){
                set.add(i*j);
            }
        }
        
        func(target);
        
        return answer;
    }
    
    static public void func(int target){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] == b[1]){
                return b[2] - a[2];
            }else{
                return a[1]-b[1];
            }
        });
        boolean visited[] = new boolean[target+1];
        pq.add(new int[]{0,0,0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            if(curr[0] == target){
                // System.out.println("here1");
                answer[0] = curr[1]; //몇번 진행됐는지
                answer[1] = curr[2]; //1~20 || 50은 몇개를 사용했는지 
                return;
            }
            
            if(!visited[curr[0]]){
                visited[curr[0]] = true;
                
                for(int s : set){
                    
                    if(curr[0]+s <= target && ! visited[curr[0]+s]){
                        if(s <= 20 || s == 50){
                            pq.add(new int[]{curr[0]+s,curr[1]+1,curr[2]+1});
                        }else{
                            pq.add(new int[]{curr[0]+s,curr[1]+1,curr[2]});
                        }
                    }
                }
            }
        }
        return;
    }
}
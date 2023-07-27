import java.util.*;

// 걍 완탐 돌리면 됨; 

class Solution {
    static int[] answer = new int[11];
    static int[] result = new int[11];
    static int max = 0;
    public int[] solution(int n, int[] info) {
    
        int arrow = 0;
        for(int i = 0;i<info.length;i++){
            arrow+= info[i];
        }
        
        dfs(0,arrow, info);
        if(max == 0){
            return new int[]{-1};
        }
        return result;        
    }
    
    static public void dfs(int idx, int arrow, int[] info){
        if(arrow == 0){

            int num = calc(info); //최대 차이 계산
            if(num > max){  //새로운 최대차이라면 answer에 결과 저장하기 
                max = num;
                result = answer.clone();    
            }
            if(num == max){
                if(check()){
                    result = answer.clone();    
                }
            }
            return;
        }
        
        if(arrow < 0 || idx == 11){
            return;
        }
        
        for(int i=0;i<11;i++){
            answer[idx] = i;
            dfs(idx+1, arrow-i, info);
            answer[idx] = 0;
        }
    }
    
    //차이 반환
    static public int calc(int[] info){
        int sum = 0;
        for(int i = 0;i<11;i++){
            if(answer[i] == 0 && info[i] == 0)continue;
            if(answer[i] > info[i]){
                sum+=10-i;
            }else{
                sum-=10-i;
            }
        }
        return sum;
    }
    
    // 더 작은 값이 많은것 찾기 
    static public boolean check(){
        //더 낮은것 반환 
        for(int i = 10;i>=0;i--){
            if(result[i] > answer[i]){
                return false;
            }
            if(result[i] < answer[i]){
                return true;
            }
            
        }
        return false;
    }
    
}
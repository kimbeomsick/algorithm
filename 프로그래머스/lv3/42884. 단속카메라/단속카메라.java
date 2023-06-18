import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        //끝점 기준으로 오름차순 정렬
        Arrays.sort(routes, (a,b)->{
            return a[1] - b[1];
        });
            
        int line = routes[0][1]; // 처음 라인의 끝
        answer++; //하나 넣었으니까 ++;
        for(int i = 1;i<routes.length;i++){
            // System.out.println(routes[i][0]+" "+line+" "+routes[i][0]);
            if(line >= routes[i][0] && line <= routes[i][1]){ //해당 감시카메라로 감당 된다면
                continue;
            }else{
                line = routes[i][1];
                
                answer++;
            }
        }
        
        
        return answer;
    }
}
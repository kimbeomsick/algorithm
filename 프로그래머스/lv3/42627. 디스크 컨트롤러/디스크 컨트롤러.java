import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
 
        
        //시작 시간 순서로 정렬
        Arrays.sort(jobs, (a,b)->{
            return a[0]-b[0];   
        });
            
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{return a[1]-b[1];});
        
        int end = 0; // 시작시간이 0 미만인것 찾기 
        int jobIdx = 0; 
        int cnt = 0;//사용한 작업의 갯수
        while(cnt != jobs.length){
        
            //end시간 이하로 실행시킬 수 있는거 다 넣기 
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= end){
                pq.add(jobs[jobIdx++]); //여기서 작업시간순서대로 정렬됨 
            }
            
            if(pq.isEmpty()){ //중간에 빈공간이 나타난다면 다음 시작시간이 빠른것부터 넣음 
                end = jobs[jobIdx][0];
            }else{ 
                int[] curr = pq.poll(); //지금 실행할 수 있는것중에 실행시간이 가장 짧은것 
                answer += curr[1]+end-curr[0]; //총 시간에 넣음
                end +=curr[1]; //end값 이동 
                cnt++; //실행한 작업의 갯수 증가 
            }
            
        }
       
        
        return (int)Math.floor(answer/jobs.length);
    }
}




 
        
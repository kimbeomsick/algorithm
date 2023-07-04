import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        //총 시간 배열 만들기 
        int total_time = timeToNumber(play_time);
        int[] timeline = new int[total_time+10]; //부족할까봐 10 더 넣음 
        
        
        //초기화
        for(String log : logs){
            int start =  timeToNumber(log.split("-")[0]);
            int end =  timeToNumber(log.split("-")[1]);
            
            //시간 채우기 => 마지막에 시청시간을 없애야 
            for(int i = start;i<end;i++){
                timeline[i]++; 
            }
        }
        
        int ad_len = timeToNumber(adv_time); //광고 총 시간
        
        
        long max_time = 0;  //얼마나 많이 보는지 확인
        for(int i = 0;i<ad_len;i++){
            max_time += (long)timeline[i]; //초기 최댓값
        }
        
        int start_time = 0; //광고 시작시간
        int idx = 0; //제일 광고를 많이 볼수 있는 시작 시간
        int end_time = ad_len; //광고 끝나는 시간 =>마지막 값은 시청시간에 포함하지 않게된다. 
        long time = max_time;
        while(end_time <= total_time+5){ //마지막 시간을 못줌; 
  
            if(max_time < time){
                idx = start_time;
                max_time = time;
            }
            
            time = time + (long)timeline[end_time] - (long)timeline[start_time]; //이건 그 사이에 있는 값이 아니다; 
            
            end_time++;
            start_time++; 
        }
        
        int second = 3600;
        StringBuilder sb = new StringBuilder();
        
        while(second != 0){
            int num = idx/second;
            if(num < 10){
                sb.append(0);
            }
                
            sb.append(num);
            if(second != 1){
                sb.append(":");    
            }
            
            idx %= second;
            second /= 60;
        }
        
        
        return sb.toString();
    }
     
    
    // 시간을 숫자로 변경하는 함수
    public static int timeToNumber(String str){
        
        int num = 0;
        String time[] = str.split(":"); 
        
        num += Integer.parseInt(time[0])*3600;
        num += Integer.parseInt(time[1])*60;
        num += Integer.parseInt(time[2]);
        
        return num;
    }
}
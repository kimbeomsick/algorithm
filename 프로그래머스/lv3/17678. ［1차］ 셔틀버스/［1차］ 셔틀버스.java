import java.util.*;



class Solution {
    
    
    public String solution(int n, int t, int m, String[] timetable) {
        
        //숫자로 변환
        int[] list = new int[timetable.length];
        for(int i = 0;i<list.length;i++){
            list[i] = stringToNumber(timetable[i]);
        }
        
        
        
        //오름차순 정렬
        Arrays.sort(list);
        int last_time = 9*60+(t*(n-1)); // 마지막 시간
        int idx = 0, cnt = 0;
        for(int i = 0;i<n;i++){
            int time = 9*60+(t*i); //버스가 도착하는시간 
            cnt = 0;
            while(true){
                if(idx >= list.length) break;
                //시간보다 일찍 줄 서기 and m명 이하로 타기 
                if(time >= list[idx] && cnt < m){
                    idx++;
                    cnt++; // 들어가는 사람 추가 됨 
                }else{
                    break;
                }
            }
        }
    
        if(cnt < m){
            return numberToString(last_time);
        }else{
            return numberToString(list[idx-1]-1);
        }
    }
    
    
    
    public static int stringToNumber(String str){
        int a = Integer.parseInt(str.split(":")[0])*60;
        int b = Integer.parseInt(str.split(":")[1]);
        return a+b;
    }
    
    public static String numberToString(int num){
        String a,b;
        if(num/60 < 10){
            a = "0"+String.valueOf(num/60);
        }else{
            a = String.valueOf(num/60);
        }
        
        if(num%60 < 10){
             b = "0"+String.valueOf(num%60);
        }else{
            b = String.valueOf(num%60);
        }
        return (a+":"+b);
    }
}
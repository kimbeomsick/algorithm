import java.util.*;


class Solution {
    
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time,(a,b)->{
            return StringToInteger(a[0]) - StringToInteger(b[0]);
        });
            
            
        for(String[] time : book_time){
            if(q.isEmpty()){
                q.add(StringToInteger(time[1]));
            }else{
                int end = q.peek();
                if(end+10 <= StringToInteger(time[0])){
                    q.poll();
                    q.offer(StringToInteger(time[1]));
                }else{
                    q.offer(StringToInteger(time[1]));
                }
            }
        }
        
         
        
        return q.size();
    }
    
    public static int StringToInteger(String str){
        int a = Integer.parseInt(str.split(":")[0])*60;
        int b = Integer.parseInt(str.split(":")[1]);
        return a+b;
    }
}
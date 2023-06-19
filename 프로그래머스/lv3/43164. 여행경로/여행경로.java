import java.util.*;

class Solution {
    
    static Stack<String> stack = new Stack<>();;
    static boolean[] visited;
    static String[] result;
    static boolean flag = false;
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        result = new String[tickets.length+1]; //시작 부분을 제외해야 하기 때문에 하나 많아야함
        //0. 정렬
        //1. ICN이 제일 앞에 
        //[0] 사전 순서대로
        //[1] 사전 순서대로
        Arrays.sort(tickets,(a,b)->{
            if(a[0].equals("ICN")){
                return -1;
            }
            if(b[0].equals("ICN")){
                return -1;
            }
            
            if(a[0].equals(b[0])){ 
                return a[1].compareTo(b[1]);
            }else{
                return a[0].compareTo(b[0]);
            }
        });
        
        stack.push("ICN"); // 미리하나 저장
        func("ICN",0,tickets);
        
        
        return result;
    }
    
    public static void func(String start, int depth, String[][] tickets){
            
        pr();
        if(depth == visited.length){ 
            // pr();
            //결과에 담기
            for(int i = 0;i<stack.size();i++){
                result[i] = stack.get(i);
            }
            flag = true;
            
            return;
        }
        
        if(flag) return;
        
        for(int i = 0;i<visited.length;i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                
                visited[i] = true;
                stack.push(tickets[i][1]);
                func(tickets[i][1],depth+1,tickets);
                stack.pop();
                visited[i] = false;
            }
        }
        
    }
    
    public static void pr(){
        for(int i = 0;i<stack.size();i++){
            System.out.print(stack.get(i)+" ");
        }
                    System.out.println();
    }
}
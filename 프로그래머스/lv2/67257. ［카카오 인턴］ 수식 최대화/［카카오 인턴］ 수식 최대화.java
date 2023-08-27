import java.util.*;

//* , + , -  : 수식의 순위를 정해서 주어진 값의 최대 절대값을 구하라 

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static String[] operList = {"*+-","*-+","+*-","+-*","-+*","-*+"};
    public long solution(String expression) {
        long answer = 0;
        
        
        //문자열 자르기 
        String num = "";
        for(int i = 0;i<expression.length();i++){
            char ch = expression.charAt(i);
        
            if(ch == '+' || ch == '-' || ch == '*'){ // oper 거르기 
                list.add(num); // 숫자넣기
                list.add(ch+""); // oper넣기 
                num = "";
            }else{
                num += ch;
            }
        }
        list.add(num);
        
        for(int i = 0;i<operList.length;i++){ //우선순위 돌아보기
            ArrayList<String> copyList = copyArray();
            for(int j = 0;j<operList[i].length();j++){ //우선순위 하나씩 뽑기
                int idx = 0; // operation 위치 찾기 
                char oper = operList[i].charAt(j);
                while(true){
                    if(copyList.get(idx).equals(oper+"")){ // 우선순위와 일치한다면
                        //앞뒤 더하고 
                        String strNum = clac(copyList.get(idx-1),copyList.get(idx+1),oper);
                        //3개정도 없애야함 
                        copyList.remove(idx-1);
                        copyList.remove(idx-1);
                        copyList.remove(idx-1);
                                        
                        //없앤 자리에 합한거 넣기
                        copyList.add(idx-1,strNum);
                        idx--;
                    }else{
                        idx++;
                        
                    }
                    if(idx >= copyList.size())break; //끝까지 가면 멈춰야함 
                }                
            }
            
            answer = Math.max(answer,Math.abs(Long.parseLong(copyList.get(0))));
        }
        
        
        return answer;
    }
    
    // String 넣어서 String 나오게 하자 
    static public String clac(String a, String b, char oper){
        Long la = Long.parseLong(a);
        Long lb = Long.parseLong(b);
        
        if(oper == '+'){
            return Long.toString(la+lb);
        }else if(oper == '-'){
            return Long.toString(la-lb);
        }else{
            return Long.toString(la*lb);
        }
    }
    
    static public ArrayList<String> copyArray(){
        ArrayList<String> copy = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            copy.add(list.get(i));
        }
        
        return copy;
    }
}
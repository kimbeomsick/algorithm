import java.util.*;

// 후보키 => 기본키가 될 수 있는 컬럼 
// 후보키의 최대 갯수를 구하라 
// [이름 전공]을 묶는다면 후보키가 될 수 있다. 
// [이름 전공 학년] 도 후보키가 될 수 있지만 굳이 세가지가 다 있을 필요가 없기 때문에 깨지게 된다. 
// 후보키가 될 수 있는 조합은?

// 방법 1 
// 모든 조합 찾기.. 
class Solution {
    
    static int answer = 0;
    static Stack<Integer> stack = new Stack<>();
    static Set<String> real_set = new HashSet<>();
    public int solution(String[][] relation) {
        int R = relation.length;
        int C = relation[0].length;
        
        for(int i=1;i<=C;i++){
            // System.out.println("\ni : "+i);
            func(0,relation,R,i,""); // 1개일 때 2개일 때 각각 조합함 
        }
        
        //꺼내보기 
        for(String s : real_set){
            System.out.print(s+" ");
        }
        
        return answer;
    }
    
    public static void func(int idx, String[][] relation, int R, int C,String str){
        
        // System.out.println("str : "+str+",   mini(str) : "+mini(str));
        //최소성을 만족하지 않는다면 뒤로감 
        if(mini(str)) return;
        
        // System.out.printf("str:%s, str.length():%d\n",str,str.length());
        if(str.length() == C ){
                if(check(relation,str)){ // 유일성을 만족하는가.. 
                    real_set.add(str);
                    answer++;
                }
            return;
        }
        
        
        for(int i = idx;i<relation[0].length;i++){
            func(i+1,relation,R,C,str+i); // 최소성이 날아감.. 
        }
        
    }
    
    //최소성 검사 
    public static boolean mini(String str){
        if(str.equals("")) return false;
        
        for(String s : real_set){
            
            int cnt = 0;
            for(int i = 0;i<s.length();i++){
                if(str.contains(s.charAt(i)+"")){
                    cnt++;
                }       
            }
            if(cnt == s.length()) return true;
            
        }
        return false;
    }
    
    public static boolean check(String[][] relation, String str){
        Set<String> set = new HashSet<>();
        for(int i = 0;i<relation.length;i++){
            String s = "";
            for(int j = 0;j<str.length();j++){
                s += relation[i][str.charAt(j)-'0'];
            }    
            set.add(s); // 담아보자
        }
        
        if(set.size() == relation.length){
            return true;
        }else{
            return false;
        }
        
    }
    
    
}
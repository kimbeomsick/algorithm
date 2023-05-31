class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        s = s.toUpperCase();
        
        int P = 0;
        int Y = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch -'P'==0) P++;
            if(ch -'Y'==0) Y++;
            
        }
        System.out.printf("p:%d, y:%d\n", P,Y);
        if(P == Y){
            return true;
        }else{
            return false;
        }
        
       
 
    }
}
class Solution {
    
    
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n!=0){
            int remain = n%3;
            
            if(remain == 0){ // 딱 나눠 떨어지면 뒤에 4 붙임
                sb.insert(0,4);
                n = n/3-1; // 하나 줄어듬 
            }else{
                sb.insert(0,remain); // 
                n /= 3;
            }
            
        }
        
        
        return sb.toString();
    }
}
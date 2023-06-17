class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int length = number.length();
        int size = length - k;
        StringBuilder sb = new StringBuilder();
        
        
        int idx = 0;
        int cnt = 0;
        while(cnt != length - k){
            // System.out.printf("idx:%d,  length-size:%d",idx, length-size);
            int max = Integer.MIN_VALUE;
            for(int i = idx;i<= length - size;i++){
                
                if(number.charAt(i)-'0' > max){ //최대값 찾기 
                    max = number.charAt(i)-'0';
                    idx = i;
                }
            }
            // System.out.println("   "+number.charAt(idx));
            
            size --;
            sb.append(number.charAt(idx)); // 최대 값 넣기 
            idx++; // 바로다음거 부터 봐야하기 때문에
            cnt++;
            
        }
        
        return sb.toString();
    }
}
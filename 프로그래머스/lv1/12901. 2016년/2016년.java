class Solution {
    public String solution(int a, int b) {
        
        int []days = {31,29,31,30,31,30,31,31,30,31,30,31};
        String []weeks = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        
        int count = 0;
        for(int i = 0;i<a-1;i++){
            count+=days[i];
        }
        count += b;
        count %= 7;
        
        
        
        String answer = weeks[(count+4)%7];
        return answer;
    }
}
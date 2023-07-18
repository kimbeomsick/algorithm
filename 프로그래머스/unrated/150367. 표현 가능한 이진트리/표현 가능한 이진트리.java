import java.util.*;


class Solution {
    static boolean flag ;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0;i<numbers.length;i++){
            String binary = addZero(toBinaryString(numbers[i]));
            
            flag = true;
            func(binary,0,binary.length()-1);
            
            if(flag){
                answer[i] = 1;
            }
            
        }
        
        return answer;
    }
    //0인데 자녀가1 인 값이 있는가?
    public static void func(String str, int start, int end){
        if(start == end) return;
        
        //지금 배열에서 부모와 자식을 비교해 보자 
        int root = (start+end)/2;
        int left = (start+root-1)/2;
        int right = (end+root+1)/2;
        
        if(str.charAt(root) == '0'){
            if(str.charAt(left) == '1' ||str.charAt(right) == '1' ){
                flag = false; // 표현할 수 없음 
            }
        }
        
        //둘로 나눠서 비교
        func(str, start, root-1);
        func(str, root+1, end);
        
    }
    
    //2진수로 만들기 
    public static String toBinaryString(long num){
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            sb.insert(0,num%2);
            num /= 2;
        }
        
        return sb.toString();
    }
    
    //0더 붙이기
    public static String addZero(String str){
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        
        int num = 0;
        while(true){
            int a = (int)Math.pow(2,num)-1;
            if(len <= a){
                len = a;
                break;
            }else{
                num++;
            }
        }
        
        sb.append(str);
        for(int i = 0;i<len-str.length();i++){
            sb.insert(0,0);
        }
        
        return sb.toString();
    }
}

import java.util.*;
class Solution {
    
    public String solution(int[] numbers) {
        String answer = "";
        
        int size = numbers.length;
        boolean flag = true;
        Integer[] nums = new Integer[size]; // 람다식을 사용하려면 객체형 이여야함
        for(int i = 0;i<size;i++){
            nums[i] = numbers[i];
            if(nums[i] != 0){
                flag = false;
            }
        }
        
        Arrays.sort(nums,(a,b)->{
            String sa = String.valueOf(a);
            String sb = String.valueOf(b);
            return (sb+sa).compareTo(sa+sb);
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(Integer a : nums){
            sb.append(a);
        }
        
        
        if(flag){
            return "0";
        }
        return sb.toString();
    }
}
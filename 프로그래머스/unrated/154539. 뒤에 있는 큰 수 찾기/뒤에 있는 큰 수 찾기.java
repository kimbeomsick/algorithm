import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Arrays.fill(answer, -1);
        Stack<int[]> stack = new Stack<>();
        for(int i = 0;i<size;i++){
            while(stack.size() > 0 && stack.peek()[1] < numbers[i] ){
                answer[stack.pop()[0]] = numbers[i];
            }
            stack.push(new int[]{i,numbers[i]}); // 자리와 값을 삽입 
        }
        return answer;
    }
}
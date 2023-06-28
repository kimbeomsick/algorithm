import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
       Arrays.sort(A);
        Arrays.sort(B);
        
        boolean visited[] = new boolean[A.length];
        
        int answer = 0;
        for(int i = 0;i<A.length;i++){
            int a = i;
            int b = A.length-1-a;
            
            answer += A[a]*B[b];
            
            
        }

        return answer;
    }
}


import java.util.*;

// 1. 1,2번 싸움 => 1번 =>1번 => 1번
// 2. 3,4번 싸움 => 2번 => 1번 =>1번
// 3. 5,6번 싸움 => 3번 => 2번 => 1번 

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(a != b){
            a = a%2 == 0 ? a/2 : a/2+1;
            b = b%2 == 0 ? b/2 : b/2+1;
            answer++;
        }

        return answer;
    }
}
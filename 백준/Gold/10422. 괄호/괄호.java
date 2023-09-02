import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int DIV = 1000000007;
        long dp[] = new long[5001]; //미리 만들어 놓기

        dp[0] = 1;
        dp[2] = 1;
        dp[4] = 2;
        
        long sum = 6; // 이전 값을 전부 더한 것
        for(int i = 6;i<=5000;i+=2){
            for(int j = 0;j<=i-2;j+=2){
                dp[i] += dp[j]*dp[i-2-j];
                dp[i] %= DIV;
            }
        }

//        System.out.println(Arrays.toString(dp));
        
        for(int t = 0;t < T;t++){ //테스트 케이스 순회
            int idx = Integer.parseInt(br.readLine()); //찾아야 하는 index,
            System.out.println(dp[idx]);
        }
    }}

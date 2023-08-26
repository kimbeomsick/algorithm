import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int dp[] = new int[K+1];
        dp[0] = 1;

       for(int i : arr){
           for(int j = i;j<=K;j++){
               dp[j] += dp[j-i];
           }
       }
        System.out.println(dp[K]);

    }
}
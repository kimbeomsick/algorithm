import java.util.*;

public class Main {

    static int N;
    static int [] arr, dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        dp = new int[N];
        Arrays.fill(dp,1);

        for(int i = 0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int result = 1;
        for(int i = 1;i<N;i++){
            for(int j = 0;j<i;j++){
                if(arr[i] > arr[j]){ //증가하는 수열이 만들어 진다면.
                    //기존에 찾았던거랑 나중에 찾은것중 증가하는 수열이 긴것
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        System.out.println(result);

    }
}
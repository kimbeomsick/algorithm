import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Long[] arr = new Long[N];
        Long[] dp = new Long[N]; // 전부 0으로 초기화 되어있음

        Arrays.fill(dp,(long)(-1));

        //배열 초기화
        for(int i = 0;i<N;i++){
            arr[i] = sc.nextLong();
        }

        for(int i = 0 ;i<N-1;i++){
            for(int j = i+1;j<N;j++){
                //i까지 왔던 비용이랑 j까지 갈 비용 중 큰값 선택
                long power = Math.max((j-i)*(1+Math.abs(arr[i]-arr[j])),dp[i]);
                // 만약 dp[i]가 -1 즉 아직 초기 값이면 들어온게 없다는 의미이기 때문에 long.MAX_VALUE넣어줌
                dp[j] = (dp[j] == -1)? Long.MAX_VALUE : dp[j];
                //i까지 올 수 있는 값중 제일 작은 값 선택
                dp[j] = Math.min(dp[j], power);
            }
        }
        System.out.println(dp[N-1]);

    }
}
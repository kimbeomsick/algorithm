import java.util.*;


public class Main {


    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int[] memories = new int[N];
        int[] costs = new int[N];

        for (int i = 0; i < N; i++) {
            memories[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            costs[i] = sc.nextInt();
        }

        int[] dp = new int[10001]; // 100이 100번 나오는게 최대니까 10001이 최대값임

        // dp[i] : cost 를 사용해서 확보할 수 있는 최대 메모리
        for (int i = 0; i < N; i++) {
            int cost = costs[i];
            for (int j = 10000; j >= cost; j--) {
                
                if (dp[j - cost] + memories[i] > dp[j]) {
                    dp[j] = dp[j - cost] + memories[i];
                }
            }
        }

//        System.out.println(Arrays.toString(dp));

        for( int i = 0;i<10001;i++){
            if(dp[i] >= M){
                System.out.println(i);
                break;
            }
        }
    }
}


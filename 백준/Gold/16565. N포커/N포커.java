import java.util.*;
public class Main {
    //0~52를 고를 수 있기 때문에 53개로 만듬
    static int[][] nCr = new int[53][53];
    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        //nCr 배열 초기화 과정
        // i 가 1인건 하나 선택할 경우임
        for (int i = 0; i <= 52; i++) {
            //이 두가지는 항상 고정임
            nCr[i][0] = 1;
            nCr[i][i] = 1;
            for (int r = 1; r < i; r++) { // r이 0 부터 시작하면 범위를 넘어가기 때문에 1부터 시작할 수 밖에 없다.
                nCr[i][r] = nCr[i - 1][r - 1] + nCr[i - 1][r];
                nCr[i][r] %= MOD;
                nCr[i][i-r] = nCr[i][r];
            }
        }

        int result = 0;
        for (int i = 4; i <= N; i += 4) { //4개씩 더하는 이유는 포카드 이기 때문이다.
            if ((i / 4) % 2 == 1) { // 홀수 번째 차례라면
                result += nCr[13][i / 4] * nCr[52 - i][N - i] ;
            } else {
                result -= nCr[13][i / 4] * nCr[52 - i][N - i] ;
            }
            result %= MOD;
        }

        if(result < 0){
            result += MOD;
        }
        System.out.println(result);
    }
}
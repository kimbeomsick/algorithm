
import java.util.*;

public class Main {
    static int N, M, result;
    static int[][] visited, dp, map;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        result = 0;

        visited = new int[N][M]; //0은 아직 방문 안한거임
        dp = new int[N][M]; //나에게로 오는 수 의 dp, 계산은 이 배열에서 전부 다함 
        map = new int[N][M]; //지도 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }


        result = dfs(N-1,M-1);
        System.out.println(result);


    }

    static int dfs(int r, int c) {
        if (r == 0 && c == 0) { //목표지점에 도달 했을 때
            return 1;
        }


        //방문한곳 0으로 초기화
        dp[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            //거르는 조건
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue; //지도를 벗어난다면 탈출
            if (map[r][c] >= map[nr][nc]) continue; //자기보다 작거나 같으면 통과

            //-1이면 아직 dfs가 이루어지지 않았다는것 ,dp에 값이 있으면 그거 가져옴
            dp[r][c] += (dp[nr][nc] == -1) ? dfs(nr, nc) : dp[nr][nc];
        }

        return dp[r][c];

    }
}

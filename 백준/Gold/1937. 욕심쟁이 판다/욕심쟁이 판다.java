

import java.util.Scanner;

public class Main {
    static int [][]map,dp ;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1}; //아래 오른쪽 위 왼쪽
    static int result = 0, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //map 초기화
        map = new int[N][N];
        dp = new int[N][N];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                int a = DFS(i,j);
//                System.out.printf("[%d, %d] = %d\n",i,j,a);
                result = Math.max(result,a);
            }
        }
        System.out.println(result);


    }

    static int DFS(int r, int c){ // 이걸했다는건 그위치에서 갈수 있는 최대한은 다 가봤다는 이야기
        //dp[r][c]가 0 이 아니라는 것은 그 자리에서 갈 수 있는 최대길이가 이미 갱신되었다는 뜻이다.
        if(dp[r][c] != 0) return dp[r][c]; // 만약 0 대신 다른 숫자가 있다면 출력

        dp[r][c] = 1; // 자기자신을 기본적으로 세팅

        for(int i = 0 ;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= N || nr < 0 || nc >= N || nc < 0) continue;
            if(map[r][c] < map[nr][nc]){
                //dp[r][c]는 처음에는 1 임 ,  DFS(nr,nc)+1 로 계속 갱신되는 거임
                dp[r][c] = Math.max(dp[r][c], DFS(nr,nc)+1);
            }
        }
        return dp[r][c];
    }
}


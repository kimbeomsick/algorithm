import java.util.Scanner;

public class Main {

    /**
     * 1. 모든 점을 돌면서 dfs 의 깊이가 4인경우를 모두 찾음
     * 2. 깊이가 4에 도달하면 result에 저장후 return;
     * 3. 제일 긴 길이 반환
     */

    static int R,C,result;
    static int[][] map, visited;
    static int[]dr = {1,0,-1,0};
    static int[]dc = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        visited = new int[R][C];
        map = new int[R][C];

        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                dfs(i,j,0,map[i][j]);
                visited[i][j] = 0;
            }
        }

        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){

                int sum_val = 0;

                // ㅏ
                if(i-1 >= 0 && i+1 < R && j+1 < C){
                    sum_val = map[i][j] + map[i-1][j] + map[i+1][j] + map[i][j+1];
                    result = Math.max(result, sum_val);
                }

                // ㅓ
                if(i-1 >= 0 && i+1 < R && j-1 >= 0 ){
                    sum_val = map[i][j] + map[i-1][j] + map[i+1][j] + map[i][j-1];
                    result = Math.max(result, sum_val);
                }

                // ㅜ
                if(i+1 < R && j-1 >= 0 && j+1 < C){
                    sum_val = map[i][j] + map[i+1][j] + map[i][j-1] + map[i][j+1];
                    result = Math.max(result, sum_val);
                }

                // ㅗ
                if(i-1 >= 0 && j-1 >= 0 && j+1 < C){
                    sum_val = map[i][j] + map[i-1][j] + map[i][j-1] + map[i][j+1];
                    result = Math.max(result, sum_val);
                }


            }
        }

        System.out.println(result);
    }

    static void dfs(int r, int c,int idx,int sum){
        if(idx == 3){
            result = Math.max(result,sum);
            return;
        }

        //방문처리
        visited[r][c] = 1;

        for(int i = 0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(visited[nr][nc] == 1) continue;

            dfs(nr,nc,idx+1, sum + map[nr][nc]);
            visited[nr][nc] = 0;
        }


    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int R, C, K, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int[][] map = new int[R][C];
            int[][] visited = new int[R][C];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }


            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 1 && visited[i][j] == 0) {
                        dfs(i, j, map, visited, ++cnt);
                    }
                }
            }

            System.out.println(cnt);
            cnt = 0; //초기화
        }

    }

    static void dfs(int r, int c, int[][] map, int[][] visited, int cnt) {
        visited[r][c] = cnt;


        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue; // 범위를 벗어나면 가지마
            if (map[nr][nc] == 0) continue; //배추 없으면 가지마
            if (visited[nr][nc] != 0) continue;// 이미 방문했으면 가지마 
            dfs(nr, nc, map, visited, cnt);

        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dr[] = {1, 0, -1, 0}; //하 우 상 좌
    static int dc[] = {0, 1, 0, -1};
    static char map[][];
    static boolean visited[][][][];
    static int ans = 20;
    static int[] red;
    static int[] blue;
    static int[] gole;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C][R][C];
        red = new int[2];
        blue = new int[2];
        gole = new int[2];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                }
                if (map[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
                if (map[i][j] == 'O') {
                    gole[0] = i;
                    gole[1] = j;
                }
            }
        }

        dfs(0, red[0], red[1], blue[0], blue[1]);
        System.out.println((ans == 20) ? -1 : ans);

    }

    static void dfs(int idx, int redR, int redC, int blueR, int blueC) {
        if (idx > 10) return;

        if (map[redR][redC] == 'O' && map[blueR][blueC] != 'O') {
            ans = (ans > idx) ? idx : ans; //더 작은 값 삽입
            return;
        } else if (map[blueR][blueC] == 'O') {
            return;
        }

        // 10회초과 걸리면 뒤로

        for (int i = 0; i < 4; i++) {

            // 겹친다면 늦게 도착한 공이 뒤로간다.
            int[] redP = arrow(redR, redC, i);
            int[] blueP = arrow(blueR, blueC, i);

            //만약 파란공이 들어온다면 돌아가기..
            if(gole[0] == blueP[0] && gole[1] == blueP[1]) continue;

            //겹치는 경우
            if (redP[0] == blueP[0] && redP[1] == blueP[1]) { //하 우 상 좌
                if (i == 0) { //구슬이 아래로 내려오는데 겹칠경우는 늦게 도착한 구슬이 한발자국 뒤로 물러선다.
                    if (redR > blueR) {
                        blueP[0]--;
                    } else {
                        redP[0]--;
                    }
                }

                if (i == 1) {
                    if (redC < blueC) {
                        redP[1]--;
                    } else {
                        blueP[1]--;
                    }
                }

                if (i == 2) {
                    if (redR > blueR) {
                        redP[0]++;
                    } else {
                        blueP[0]++;
                    }
                }

                if (i == 3) {
                    if (redC < blueC) {
                        blueP[1]++;
                    } else {
                        redP[1]++;
                    }
                }
            }
            //방문처리하기
            if (visited[redP[0]][redP[1]][blueP[0]][blueP[1]]) continue; // 이미 방문했다면 패스!

            visited[redP[0]][redP[1]][blueP[0]][blueP[1]] = true;
            dfs(idx + 1, redP[0], redP[1], blueP[0], blueP[1]);
            visited[redP[0]][redP[1]][blueP[0]][blueP[1]] = false;
        }
    }


    //공의 좌표를 바꾸는 함수
    static int[] arrow(int row, int col, int dir) {
        int r = dr[dir];
        int c = dc[dir];

        while (true) {
            if (map[row + r][col + c] == '#') break; // 벽을 만나면 멈춤고 위치 반환
            if (map[row + r][col + c] == 'O') { // 골을 만나면 들어가 있음
                row += r;
                col += c;
                break; // 골을 만나면 멈추고 위치 반환
            }
            row += r;
            col += c;
        }

        int[] result = {row, col};
        return result;


    }
}

//        3 10
//        ##########
//        #.O....RB#
//        ##########
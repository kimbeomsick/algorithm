


import java.util.*;

public class Main {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static <list> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();

        int[][] map = new int[R][C];

        int idx = 0;
        int[] air = new int[2]; // 에어컨 위치 저장
        //입력받기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    air[idx++] = i; // col은 0로 고정되어 있기 때문에 row위치만 찾으면 된다.
                }
            }
        }


        //시간 순서대로 진행
        for (int t = 1; t <= T; t++) {
            List<int[]> dust = new ArrayList<>();
            //미세먼지 위치 추적
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) { // 먼지가 있다면
                        dust.add(new int[]{i, j, map[i][j]}); //배열에 위치 저장
                    }
                }
            }




            //미세먼지 확산

            for (int[] d : dust) {
                int cnt = 0; // 주변에 얼마나 먼지를 뿌렸는지 체크
                int r = d[0];
                int c = d[1];
                int val = d[2];
                //주변 탐색
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    //범위 밖으로 나가거나, 공기청정기를 만나면 확산이 일어나지 않음
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;
                    //확산 되는 방향으로 확산함
                    map[nr][nc] += val / 5;
                    cnt++; // 4방향중 몇번이나 확산됐는지 기록
                }
                //기존에 있던 값 - 원래 값 + 확산된거 뺀 나머지 값   -> 확산되어 더해진 값에 따라 확산 기준이 변하면 안됨
                map[r][c] = map[r][c] - ((val / 5) * cnt);
            }



            //미세먼지 공기청정기가 밀어버림
            //위쪽 공기청정기
            int[] tp = {air[0] - 1, 0};
            int r = -1;
            int c = 0;
            while (true) {
                if (tp[0] + r < 0) { //다음칸이 천장을 만나면
                    r = 0;
                    c = 1;
                } else if (tp[1] + c == C) { // 다음칸이 오른쪽 벽을 만나면
                    r = 1;
                    c = 0;
                } else if (tp[0] + r == air[0] + 1) { // 아래 공기청정기 영역을 침범할 것 같으면
                    r = 0;
                    c = -1;
                } else if (map[tp[0] + r][tp[1] + c] == -1) { // 한바퀴 돌아서 공기청정기를 만나면
                    map[tp[0]][tp[1]] = 0; //땡겨온 자리 0으로 만듬
                    break;
                }
                map[tp[0]][tp[1]] = map[tp[0] + r][tp[1] + c];
                tp[0] += r;
                tp[1] += c;



            }

            //아래쪽 공기청정기
            int[] bp = {air[1] + 1, 0};
            r = 1;
            c = 0;
            while (true) {
                if (bp[0] + r == R) { // 천장을 만나면
                    r = 0;
                    c = 1;
                } else if (bp[1] + c == C) { // 오른쪽 벽을 만나면
                    r = -1;
                    c = 0;
                } else if (bp[0] + r == air[1] - 1) { // 위쪽 공기청정기 영역을 침범할 것 같으면
                    r = 0;
                    c = -1;
                } else if (map[bp[0] + r][bp[1] + c] == -1) { // 한바퀴 돌아서 공기청정기를 만나면
                    map[bp[0]][bp[1]] = 0;
                    break;
                }
                map[bp[0]][bp[1]] = map[bp[0] + r][bp[1] + c];
                bp[0] += r;
                bp[1] += c;


            }

        }


        //남은 먼지의 개수
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (map[i][j] == -1) continue;
                result += map[i][j];
            }
        }

        System.out.println(result);
    }
}

//           7 8 1   //row, col, time
///         0 0 0 0 0 0 0 9
//         0 0 0 0 3 0 0 8
//         -1 0 5 0 0 0 22 0
//         -1 8 0 0 0 0 0 0
//         0 0 0 0 0 10 43 0
//         0 0 5 0 15 0 0 0
//         0 0 40 0 0 0 20

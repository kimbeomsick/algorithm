

import java.util.*;

public class Solution {

    static int[] length = {0, 0, 0, 0};
    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {-1, 1, 1, -1};
    static int N, result;
    static int[][] map;
    static Stack<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //테스트 케이스
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            //결과값
            result = -1;

            //크기
            N = sc.nextInt();

            //초기화
            map = new int[N][N];

            //디져트를 담을 배열
            list = new Stack<>();


            //초기화
            for (int i = 0; i < N * N; i++) {
                map[i / N][i % N] = sc.nextInt();
            }

            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
//                    System.out.printf("i:%d, j:%d\n",i,j);
                    dfs(i, j, 0);
//                    System.out.println("----");
                }
            }

            System.out.printf("#%d %d\n",t,result);
        }


    }

    //(r,c) 현제 위치 , side 몇 사분면인지
    static void dfs(int r, int c, int side) {

        //임시 출력
//        System.out.print("(" + r + "," + c + ")" + "val:" + map[r][c] + "   side:" + side + "   ");
//        for (int a : list) {
//            System.out.print(a + " ");
//        }
//        System.out.println();


        //3변에서 오고 있고 간 거리를 측정해서 원래 자리로 돌아왔는지 측정
        if (side == 3 && length[0] == length[2] && length[1] == length[3]) {
//            System.out.println("마지막에 도착했나? 값 :" + list.size());
            result = Math.max(result, list.size());
            return;
        }



        //0~3사분면 돌기
        int deadline = (side == 3)? 4 : side+2; //이게 제일 중요했음
        for (int i = side; i < deadline; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue; //범위를 벗어나면 통과
            if(list.contains(map[nr][nc])) continue; //다음값이 이미 들어있으면 통과   -> 탈출조건의 위치 중요

            //갈 수 있는 길일 때
            length[i] += 1; //i번째 길 길이 추가
            list.push(map[nr][nc]);
            dfs(nr, nc, i);
            //나올 때
            length[i] -= 1; //i번째 길 삭제
            list.pop(); //들어갈 때 넣은 값 삭제
        }
    }
}


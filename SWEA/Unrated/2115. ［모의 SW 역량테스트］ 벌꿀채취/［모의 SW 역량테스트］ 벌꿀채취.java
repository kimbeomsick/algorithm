

import java.util.Scanner;
import java.util.Stack;


public class Solution {


    static int N, M, C;
    static int cnt1, cnt2, result;
    static int map[][];
    static int visited[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            result = 0;
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();

            map = new int[N][N];
            visited = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (N - M - j >= 0) {
                        dfs(i, j, j + M, new Stack<Integer>(), 1);

                        for (int q = (N-j-M > M)? i : i+1 ; q < N; q++) {
                            for (int k = (N-j-M > M)? j+M:0; k < N; k++) {
                                if (N - M - k >= 0) {
                                    dfs(q, k, k + M, new Stack<Integer>(), 2);
                                    result = Math.max(cnt1 + cnt2, result);
//                                    System.out.printf("(%d,%d) 와 (%d,%d) 의 최고값 %d\n",i,j,q,k,cnt1+cnt2);
                                    cnt2 = 0;
                                }
                            }
                        }
                        cnt1 = 0;

                    }

                }
            }


            System.out.printf("#%d %d\n", t, result);
        }


    }

    static void dfs(int row, int st, int ed, Stack<Integer> stack, int cnt) {
        int sum = 0;
        int max = 0;
        for (int s : stack) {

            sum += s;
            max += Math.pow(s, 2);
        }


        if (sum > C) return;

        if (cnt == 1) {
            cnt1 = Math.max(cnt1, max);
        } else {
            cnt2 = Math.max(cnt2, max);
        }

        for (int i = st; i < ed; i++) {
            stack.add(map[row][i]);
            dfs(row, i+1, ed, stack,cnt);
            stack.pop();

        }


    }


}





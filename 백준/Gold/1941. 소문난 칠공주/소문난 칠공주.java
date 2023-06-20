import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] select = new boolean[5][5];
    static int result = 0;
    static char[][] map = new char[5][5];

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        combination(0, 0,0);
        System.out.println(result); //결과 출력
        sc.close(); //명시적으로 해주는게 좋음 
    }

    public static void fun() {

    }

    public static void combination(int idx, int y, int depth) {
        if (y > 3) return; // 임도연파가 3명 초과면 아웃
        if (depth == 7) {
           if (find((idx-1)/5,(idx-1)%5)){
               result++;
           }
            return;
        }

        for (int i = idx; i < 25; i++) {
            int r = i/5;
            int c = i%5;

            select[r][c] = true;
            combination(i + 1, map[r][c] == 'Y' ? y + 1 : y, depth+1);
            select[r][c] = false;
        }
    }


    public static boolean find(int R, int C){
        boolean visited[][] = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{R,C});
        visited[R][C] = true;
        int cnt = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            cnt++; //하나 선택

            int r = curr[0];
            int c = curr[1];

            for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >=5 || nc < 0 || nc >= 5)continue;
                if(!visited[nr][nc] && select[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return cnt == 7 ? true : false;

    }
}
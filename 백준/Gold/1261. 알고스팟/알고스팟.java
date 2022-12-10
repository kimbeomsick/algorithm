


import java.util.*;


public class Main {
    static class Node implements Comparable<Node>{
        public int r;
        public int c;
        public int val;


        public Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) { // 값 순서대로 정렬
            return this.val - o.val;
        }
    }
    // 아래 오른 위 에
    static int dr[] = {1, 0, -1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int C, R, result = -1;
    static int[][] map, dp, visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        R = sc.nextInt();

        dp = new int[R][C];
        map = new int[R][C];
        visited = new int[R][C];

        for(int d[] : dp ){
            Arrays.fill(d,100000000);
        }


        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }



        dfs(0, 0);
        System.out.println(dp[R-1][C-1]);



    }

    static void dfs(int r, int c) {

        // q생성 q넣기
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(r,c,0));
        // dp 값 0 처리
        dp[0][0] = 0;
        while(!q.isEmpty()){
            Node curr = q.poll();

            if(visited[curr.r][curr.c] == 0){
                visited[curr.r][curr.c] = 1; // 방문처리 하기

                if(curr.r == R-1 && curr.c == C-1) break;

                for(int i = 0;i<4;i++){
                    int nr = curr.r + dr[i];
                    int nc = curr.c + dc[i];

                    if(nc <0 || nc >= C || nr < 0 || nr >= R) continue;

                    //아직 방문하지 않았고, 기존에 왔던 거리보다 작으면 값 변경
                    if(visited[nr][nc] == 0 &&  dp[nr][nc] >  dp[curr.r][curr.c]+map[nr][nc]){
                        dp[nr][nc] = dp[curr.r][curr.c]+map[nr][nc];
                        q.add(new Node(nr,nc,dp[nr][nc]));
                    }

                }
            }

        }


    }
}
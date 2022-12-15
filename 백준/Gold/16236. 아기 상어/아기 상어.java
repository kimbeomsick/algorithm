

import java.util.*;

public class Main {


    static class Node implements Comparable<Node> {
        int r;
        int c;
        int val;

        public Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, R, C, size, eat, distance, result, INF = 1000000000;
    static int[][] map;
    static List<Node> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        result = 0; // 엄마상어 부르는대 까지 걸리는 시간.
        N = sc.nextInt();
        map = new int[N][N];
        list = new ArrayList<>();


        size = 2; //상어의 초기크기
        eat = 0; //잡아먹은 먹이의 개수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int a = sc.nextInt();

                //map에 넣기
                if(a == 9){
                    map[i][j] = 0;
                }else{
                    map[i][j] = a;
                }

                //0이 아니라면
                if (a > 0 && a < 7) {
                    list.add(new Node(i, j, a)); // 나중에 정렬할거임
                } else if (a == 9) {
                    //원 위치 저장하기
                    R = i;
                    C = j;
                }
            }
        }
        Collections.sort(list); // val기준으로 정렬됨



        while (!list.isEmpty()) {
            int idx = -1; // 지워질 index의 위치
            distance = INF;
            //내가 갈 수 있는 위치만 찾기
            for (int i = 0; i < list.size(); i++) {
                Node curr = list.get(i);

                //상어보다 크기가 크면 먹지 못함
                if (curr.val >= size) break;

                //내가 작성했던 크기보다 작으면..
                int d = bfs(curr.r, curr.c);
                if (d!= INF && distance >= d) {
                    if (distance == d) {
                        if (list.get(idx).r == curr.r){ // 둘의 거리, 높이가 같은경우
                            if(list.get(idx).c > curr.c){
                                idx = i;
                            }
                        }else if(list.get(idx).r > curr.r) { // 높이가 다른 경우
                            idx = i; //더 위에 있는것으로 변경
                        }
                    } else {
                        distance = d;// 거리저장
                        //인덱스 저장
                        idx = i;
                    }
                }
            }

            //찾은 위치(idx) 지우기
            if (idx == -1) {
                break;// 못찾는거니까 엄마 찾으러 가야함
            } else {

                result += distance; // 먹을 수 있는게 있기 때문에 거리 증가
                Node n = list.get(idx);
                //시작위치 다시 잡기
                R = n.r;
                C = n.c;
                map[n.r][n.c] = 0;
                list.remove(idx);

                eat++;
                //먹은 갯수랑 사이즈가 같으면
                if (size == eat) {
                    size++;
                    eat = 0;
                }
            }
            //idx == -1이면 엄마상어 불러야함


        }
        System.out.println(result);
    }


    //내가 찾는 먹이까지의 최소거리 구하기
    static int bfs(int r, int c) {
        int dist = INF;
        //거리를 가져올 거임
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[][] visited = new int[N][N];
        int[][] dp = new int[N][N];

        for (int[] d : dp) {
            Arrays.fill(d, 10000000);
        }
        dp[R][C] = 0; // 시작위치는 전역변수로 다룬다.
        q.add(new Node(R, C, 0));
        while (!q.isEmpty()) {

            //하나꺼냄
            Node curr = q.poll();

            //내가 찾는 위치에 도착
            if (curr.r == r && curr.c == c) {
                dist = curr.val; // 내가 원하는 자리가 나오면 그곳의 최소값을 뺀다.
                break;
            }


            if (visited[curr.r][curr.c] == 0) {
                //방문 안했으면 방문처리함
                visited[curr.r][curr.c] = 1;
                for (int i = 0; i < 4; i++) {
                    int nr = curr.r + dr[i];
                    int nc = curr.c + dc[i];

                    //범위를 벗어나면 통과
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    //방문처리 되어있으면 통과
                    if (visited[nr][nc] == 1) continue;
                    //지나가는 곳에 있는 물고기가 나보다 크면 통과
                    if (map[nr][nc] > size) continue;
                    //지금 길이보다 짧다면 더 짧은 거리로 교체
                    if (dp[nr][nc] > 1 + dp[curr.r][curr.c]) {
                        dp[nr][nc] = 1 + dp[curr.r][curr.c]; // 변경하고 넣어 줌
                        q.add(new Node(nr, nc, dp[nr][nc])); // 변경된 길이를 넣어줌
                    }

                }
            }


        }
        //내가 찾는거리가 발견되지 않으면 INF가 발생한다.
        return dist;
    }
}
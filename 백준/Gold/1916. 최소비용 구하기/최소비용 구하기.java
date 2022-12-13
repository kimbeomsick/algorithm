import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int ed;
        int val;

        public Node(int ed, int val) {
            this.ed = ed;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    static List<Node>[] graph;
    static int[] length, visited;
    static int N, E, st, ed;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();


        //리스트 배열 초기화
        graph = new ArrayList[N + 1]; // 0에서 12까지
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a].add(new Node(b, c));
        }

        //시작지점 종료지점
        st = sc.nextInt();
        ed = sc.nextInt();
        visited = new int[N + 1];
        length = new int[N + 1];
        Arrays.fill(length, 100000000);

        func(st, ed);
        System.out.println(length[ed]);

    }

    static void func(int st, int ed) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        length[st] = 0;
        q.add(new Node(st, 0));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (visited[curr.ed] == 0) {
                visited[curr.ed] = 1;


                for (Node next : graph[curr.ed]) {
                    if (visited[next.ed] == 0) {

                        //전 값보다 지금 값이 더 작으면 삽입
                        if (length[next.ed] > length[curr.ed] + next.val) {
                            length[next.ed] = length[curr.ed] + next.val;
                            q.offer(new Node(next.ed, length[next.ed]));
                        }
                    }
                }
            }
        }
    }


}
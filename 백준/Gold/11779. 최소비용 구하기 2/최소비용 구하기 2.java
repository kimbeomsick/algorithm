import java.util.*;


public class Main {

    static int N;
    static List<Node>[] list;
    static int dist[][];

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        N = sc.nextInt(); // 노드의 개수
        int R = sc.nextInt();

        //거리 경로 초기화
        dist = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            dist[i][0] = 1000000000; // 거리 최대화
            dist[i][1] = i; //자기 자신을 가리키고 있음
        }

        //리스트 배열 초기화
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list[a].add(new Node(b, c));
        }

        int st = sc.nextInt();
        int ed = sc.nextInt();
        int result = func(st, ed);
        System.out.println(result);

        Stack<Integer> stack = new Stack<>();

        int path = ed;
        while (true) {
            stack.push(path);
            if (path == st) break;
            path = dist[path][1];
        }
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }


    }

    static int func(int st, int ed) {

        int result = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(st, 0));
        int[] visited = new int[N + 1];
        dist[st][0] = 0; //거리 초기화

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.ed == ed) {
                result = curr.val;
                break;
            }

            if (visited[curr.ed] == 0) {
                visited[curr.ed] = 1;

                for (Node next : list[curr.ed]) {
                    if (visited[next.ed] == 0 && dist[next.ed][0] > next.val + dist[curr.ed][0]) {
                        dist[next.ed][0] = next.val + dist[curr.ed][0];
                        q.add(new Node(next.ed, dist[next.ed][0]));
                        dist[next.ed][1] = curr.ed; // 여기서 왔다는 표시
                    }
                }
            }
        }
        return result;

    }
}

import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        public int ed;
        public int val;

        public Node(int ed, int val) {
            this.ed = ed;
            this.val = val;
        }


        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    static int N, M, X, result = Integer.MIN_VALUE;
    static List<Node>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();


        //리스트 초기화
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list[a].add(new Node(b, c));
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {

            int a = djk(i, X); // i에서 x로 가는 길
            int b = djk(X, i); // x에서 i로 가는 길

            result = Math.max(result, a + b);
        }

        System.out.println(result);


    }

    static int djk(int start, int end) {
        if (start == end) return 0;

        int result = 0;
        int[] arr = new int[N + 1]; //start에서 각각의 노드까지 최단거리 저장
        int[] visited = new int[N + 1]; //방문처리
        PriorityQueue<Node> q = new PriorityQueue<Node>(); //짧은거리순으로 꺼냄
        Arrays.fill(arr, 100000000);//최단 거리를 찾기위해 일단 크게 만듬
        arr[start] = 0;
        q.add(new Node(start, 0)); // 시작점으로 가는 길은 0 임


        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (visited[curr.ed] == 0) { // 방문 처리해줌
                visited[curr.ed] = 1;


                if (curr.ed == end) { // 내가 원하는 거리에 들어왔다면
                    result = curr.val; // 그거리를 저장 다른건 볼 필요 없음
                    break;
                }

                for (Node next : list[curr.ed]) {
                    if (visited[next.ed] == 0 && arr[next.ed] > arr[curr.ed] + next.val) {
                        arr[next.ed] = arr[curr.ed] + next.val;
                        q.add(new Node(next.ed, arr[next.ed]));
                    }
                }
            }
        }

        return result;
    }

}
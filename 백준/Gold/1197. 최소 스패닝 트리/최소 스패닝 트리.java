
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int val;

        public Node(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        //preorityQ에 넣기위한 초석
        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }


    static int N, E, result; //노드, 간선의 개수, 결과값
    static int[] parent; // 부모
    static Queue<Node> q; // 간선 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //보모찾는 find 함수
        //둘을 합치는 union 함수 필요
        q = new PriorityQueue<>();
        result = 0;
        N = sc.nextInt();
        E = sc.nextInt();

        //부모찾기 초기화
        parent = new int[N+1];
        for(int i = 0;i<N;i++){
            parent[i] = i;
        }

        for(int i = 0;i<E;i++){
            int st = sc.nextInt(); //시작점
            int ed = sc.nextInt(); //끝점
            int v = sc.nextInt(); //간선

            //넣으면
            // 알아서 간선크기순으로 정렬됨
            q.add(new Node(st,ed,v));
        }

        int cnt = 0; // 간선을 몇개 선택했는지 보기위한 변수
        while(true){ //혹시 간선이 모자랄 수도 있으니까..?
            Node curr = q.poll();

            if(find(curr.start) != find(curr.end)){
                union(curr.start, curr.end);
                result += curr.val;
                cnt++;
            }

            if(cnt == N-1) break;
        }

        System.out.println(result);




    }

    static int find(int x){
        //늘 최상위 부모를 데려옴
        //자기자신을 가리키면 최상위 부모임
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    static void union(int x, int y){
        //각자의 부모를 데려옴
        x = find(x);
        y = find(y);
        //부모 합병
        parent[y] = x;
    }
}

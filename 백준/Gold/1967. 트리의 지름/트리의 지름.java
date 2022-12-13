import java.util.*;

public class Main {

    static List<int[]>[] graph;
    static int[] visited;
    static int N,result = 0;
    static int end_idx = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();


        //리스트 배열 초기화
        graph = new ArrayList[N+1]; // 0에서 12까지
        for(int i = 0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        //그래프 값 넣기
        for(int i = 0;i<N-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a].add(new int[]{b,c});
            graph[b].add(new int[]{a,c});
        }

        visited = new int[N+1];
        visited[1] = 1;
        dfs(1,0); // 루트에서 다른곳으로 가는 최장거리

        visited = new int[N+1];
        visited[end_idx] =1;
        dfs(end_idx,0); // 제일 멀리 있는거 골랐으니 거기서부터 제일 먼것을 고르면 됨

        System.out.println(result);
    }

    static void dfs(int idx, int sum){
        if(result < sum){
            result = sum;
            end_idx = idx;
        }


        for(int[] node: graph[idx]){
            //방문하지 않았다면
            if(visited[node[0]] == 0){
                visited[node[0]] = 1;
                dfs(node[0],sum + node[1]);
            }
        }
    }
}

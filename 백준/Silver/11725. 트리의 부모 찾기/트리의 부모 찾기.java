
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {


    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        result = new int[N + 1];
        visited = new boolean[N + 1];

        List<Integer>[] list = new ArrayList[N + 1]; // 1번부터 시작하기 때문에 1부터
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1,list);

        for(int i = 2;i<=N;i++){
            System.out.println(result[i]);
        }


    }

    static void dfs(int start, List<Integer>[] list){
        visited[start] = true;
        for(int child : list[start]){
            if(!visited[child]){
                result[child] = start;
                dfs(child, list);
            }
        }
    }
}



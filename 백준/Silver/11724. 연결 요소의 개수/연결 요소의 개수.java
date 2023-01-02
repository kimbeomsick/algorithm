
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점 n 간선 m
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n+1]; // 노드의 개수만큼
        for(int i = 0;i<=n;i++){
            list[i] = new ArrayList<>(); //초기화
        }

        int visited[] = new int[n+1]; //전부다 0으로 초기화

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        //간선이 없다면 n이 답이 됨 
        if(m == 0){
            System.out.println(n);
            return;
        }

        Queue<Integer> q = new LinkedList<>();

        int idx = 0;
        for(int i = 1;i<=n;i++){
            if(visited[i] == 0){
                idx++;
                q.add(i);
            }

            while(!q.isEmpty()){
                int curr = q.poll();

                if(visited[curr] == 0){
                    visited[curr] = idx;

                    for(int next : list[curr]){
                        q.add(next);
                    }
                }
            }


        }
        System.out.println(idx);

    }
}

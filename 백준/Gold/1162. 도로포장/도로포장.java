import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
   static class Node implements Comparable<Node>{
       int num;
       long val;
       int cnt = 0;

       public Node(int num, long val) {
           this.num = num;
           this.val = val;
       }

       public Node(int num, long val, int cnt) {
           this.num = num;
           this.val = val;
           this.cnt =  cnt;
       }

       @Override
       public int compareTo(Node o) {
           return Long.compare(this.val, o.val);
       }
   }

    static int N, M, K;
    static List<Node>[] list ;

    static String str = "4 4 1\n" +
            "1 2 10\n" +
            "2 4 10\n" +
            "1 3 1\n" +
            "3 4 100";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new StringReader(str));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //초기화
        list  = new ArrayList[N+1];
        for(int i = 0;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,val));
            list[b].add(new Node(a,val));
        }

        System.out.println(func(1));

    }

    static long  func(int start){
        long[][] dist = new long[K+1][N+1];
        boolean[][] visited = new boolean[K+1][N+1];

        //초기화
        for(int i = 0;i<=K;i++){
            Arrays.fill(dist[i],Long.MAX_VALUE);
         }
            dist[K][start] = 0;


        PriorityQueue<Node> pq = new PriorityQueue();
        pq.offer(new Node(start,0,K));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            

            if(!visited[curr.cnt][curr.num]){ //방문하지 않았다면...
                visited[curr.cnt][curr.num] =true; //방문처리함
                for(Node next : list[curr.num]){

                    //cnt == 0 일때 dist[K][K-1]
                    if(!visited[curr.cnt][next.num] && dist[curr.cnt][next.num] > dist[curr.cnt][curr.num] + next.val ){
                        dist[curr.cnt][next.num] = dist[curr.cnt][curr.num] + next.val;
                        pq.offer(new Node(next.num,dist[curr.cnt][next.num],curr.cnt));
                    }

                    //cnt >0 일때
                    if(curr.cnt > 0){
                        if(!visited[curr.cnt-1][next.num] && dist[curr.cnt-1][next.num] > dist[curr.cnt][curr.num] ){
                            dist[curr.cnt-1][next.num] = dist[curr.cnt][curr.num] ;
                            pq.offer(new Node(next.num,dist[curr.cnt-1][next.num],curr.cnt-1));
                        }
                    }


                }
            }
        }
        long result = Long.MAX_VALUE;
        for(int i = 0;i<=K;i++){
            result = Math.min(dist[i][N],result);
        }

    return result;

    }

}

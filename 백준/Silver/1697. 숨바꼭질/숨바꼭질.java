import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
    static class Node implements Comparable<Node>{
        int val;
        int dist;

        public Node(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }


        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }


    static int N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        if(N == K){
            System.out.println(0);
        }else{

            System.out.println(dfs(N,K));
        }

    }

    static int dfs(int n, int k){
        int result = 0;
        int[] visited = new int[100001];
        int[] distance = new int[100001];
        PriorityQueue<Node> q = new PriorityQueue<>();
        Arrays.fill(distance,100000000);
        distance[n] = 0;
        q.add(new Node(n,0));

        while(!q.isEmpty()){

            Node curr = q.poll();
            int val = curr.val;
            int dist = curr.dist;


            if(val == k){

                result = dist;
                break;
            }

            if(visited[curr.val] == 0){
                visited[val] = 1;

                if(val+1 <= 100000 && visited[val+1] == 0 &&  distance[val+1] > dist + 1){
                    distance[val+1] = dist+1;
                    q.add(new Node(val+1,dist+1));
                }
                if(val-1 >= 0 && visited[val-1] == 0 &&  distance[val-1] > dist + 1){
                    distance[val-1] = dist+1;
                    q.add(new Node(val-1,dist+1));
                }
                if(val*2 <= 100000 && visited[val*2] == 0 &&  distance[val*2] > dist + 1){
                    distance[val*2] = dist+1;
                    q.add(new Node(val*2,dist+1));
                }
            }
        }

        return result;
    }

}

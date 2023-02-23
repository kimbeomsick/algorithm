import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static boolean[] done, visited ;
    static int arr[];
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc =  Integer.parseInt(br.readLine());
        for(int t=  1;t<=tc;t++){
            int N =  Integer.parseInt(br.readLine());

            arr = new int[N+1]; //바신의 다음노드를 가리키는 배열
            done = new boolean[N+1]; //사이클 완성
            visited = new boolean[N+1]; //방먼처리
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1;i<=N;i++){
                arr[i] = Integer.parseInt(st.nextToken());

                //자기자신을 가리킨다면 사이클이 만들어진 것
                if(arr[i] == i){
                    done[i] = true;
                    result++;
                }
            }

            for(int i = 1;i<=N;i++){
                if(!done[i]) dfs(i); // 완탐하면서 사이클을 찾음
            }
            System.out.println(N-result);

        }

    }

    static void dfs(int n){

        if(visited[n]){ //이미 방문한 적이 있으면 사이클생성
            done[n] = true; //n은 사이클이 만들어졌음을 증명
            result++;
        }else{
            visited[n] = true; //방문안했다면 방문처리 다음에 와서 방문처리가 되어있다면 사이클 되는것
        }

        if(!done[arr[n]]){ // 다음에올 수가 아직 사이클이 만들어지지 않았다면 들어감
           dfs(arr[n]);
        }

        visited[n] = false; //나올때는 방문취소
        done[n] = true;

    }
}

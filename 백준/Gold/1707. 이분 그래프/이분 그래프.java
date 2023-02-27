import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {


    static int [] visited;
    static List<Integer>[] list;
    static int result ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());


        for(int t = 1;t<=tc;t++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            //그래프 초기화
            list = new ArrayList[M+1];
            visited = new int[M+1];
            for(int i = 1;i<=M;i++){
                list[i] = new ArrayList<>();
            }

            //그래프 설정하기
            for(int i = 0;i<R;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            result = 1;
            for(int i = 1;i<=M;i++){
                if(visited[i] != 0) continue;
                visited[i] = 1; // color는 1부터 시작하는걸로하자
                dfs(i,1);

                if(result == -1)break;
            }

            System.out.println((result == -1)? "NO":"YES");

//            System.out.println(Arrays.toString(visited));


        }
    }

    //color는 1과 -1로 이루어진다. visited==0 이라면1과2가 들어갈 수 있는것이다. 근데 이미 있거나 다른값이 들어갈 수 없다면 아웃!
    static void dfs(int start, int color){
        if(result == -1) return; // 만약 같은 color가 인접한 노드에 동시에 존재한다면 바로 뒤로가기

        for(int i : list[start]){
            if(visited[i] != 0 ){ //방문했다면
                if(visited[i] == color) { //지금 컬러가 다음 컬러랑 겹치면 NO
                    result = -1; //no 싸인을 주어야함
                    break;
                }
            }else{ // 방문하지 않았면
                int newColor = color * (-1);
                visited[i] = newColor;
                dfs(i,newColor); //칼라를 반전시키고 한칸 들어간다.
            }

        }



    }
}


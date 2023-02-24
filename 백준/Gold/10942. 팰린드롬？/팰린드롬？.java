import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N, result;
    static int[][] dp;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            result = 0;
            func(start,end);
            sb.append((result== 1 ? 1 : 0)+"\n");

        }

        System.out.println(sb);

    }

    //되면 1 모르면 0 안되면 -1
    /*
    1. dp = 1 저장되어있는경우 나오면서 dp[start][end]를 1로 만들어 준다.
    2. dp = 0 더들어가서 무슨 값이 있는지 확인한ㄷ.ㅏ
    3. dp = -1 안되는거니까 나오면서 dp에 -1을 넣는다.
    4. return != 0 값이 이미 정해진거니까 나오면서 dp 에result 값을 넣는다.
    * */

    static void func(int start, int end){


        //dp에 저장되어 있는 값이 있다면 그 값으로 세팅하고 배출함
        if(dp[start][end] == 1){
           result = 1;
           return;
        }

        //dp 에 자장되어있는 값이 있다면 그 값으로 세팅하고 배출함
       if(dp[start][end] == -1){
           result =  -1;
           return;
       }

       //저장되어있는 값이 없다면..
       if(arr[start] == arr[end]){ //둘이 같은지 확인한다.
           if(end- start < 3){
               result = 1;
               dp[start][end] = 1;
           }else{
               func(start+1, end-1);
           }
       }else{
           result = -1;
           dp[start][end] = result;
           return;
       }

        if(result != 0){
            dp[start][end] = result;
        }
    }
}

//7
//        1 2 1 3 1 2 1
//        4
//        1 3
//        2 5
//        3 3
//        5 7
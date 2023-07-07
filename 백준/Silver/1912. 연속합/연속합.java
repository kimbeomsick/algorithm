import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int []arr, sum;
    static int N;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            result = Math.max(result, arr[i]);
        }

       sum[0] = arr[0];

        for(int i = 1;i<N;i++){
            sum[i] = Math.max(sum[i-1]+arr[i], arr[i]);
            result = Math.max(result, sum[i]);
        }

        System.out.println(result);

    }
}
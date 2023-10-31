
import java.sql.Array;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());


        int arr[] = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int answer = 0;
        int end = 0;
        int start = -1;
        int sum = arr[end];
        while(true){
            if(end == start || sum <= M){
                answer = Math.max(answer,sum);
                end++;
                if(end == N) break;
                sum += arr[end];
            }else{
                start++;
                sum -= arr[start];
            }
        }

        System.out.println(answer);
    }
}



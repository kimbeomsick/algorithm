import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int result = 1; // 0이면 무슨 차이가 있지?
        int[] arr = new int[N];
        boolean[] index = new boolean[10000001];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            index[num] = true;
            arr[i] = num;
        }


        for (int n = 0; n <= 10000000; n++) {
            if (index[n]) {
                int pre = arr[0];
                int cnt = 1;
                for (int i = 1; i < N; i++) {
                    //통과해야하는 값
                    if (arr[i] == n) continue;

                    //만약 pre랑 동일하면
                    if (pre == arr[i]) {
                        cnt++;
                        result = Math.max(cnt, result);
                    } else { //전꺼랑 동일하지 않다면
                        cnt = 1;
                    }
                    pre = arr[i];
                }
            }
        }

        System.out.println(result);

    }
}
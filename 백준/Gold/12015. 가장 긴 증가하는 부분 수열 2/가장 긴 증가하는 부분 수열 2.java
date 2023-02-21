import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result.add(arr[0]);


        //result에 넣기
        for (int i = 1; i < N; i++) {
            if (result.get(result.size() - 1) < arr[i]) { //나보다 크다면 추가하기
                result.add(arr[i]);
            } else {

                    int left = 0;
                    int right = result.size()-1;

                    while (left < right) {

                        int mid = (left + right) / 2;

                        if (result.get(mid) < arr[i]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    //같으면 통과 다르면 대치
                        result.set(left, arr[i]);
            }
        }

        System.out.println(result.size());

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                high = Math.max(high, num); // 제일 높은 값
                sum += num; //평균 값을 구하기 위한 총합
            }
        }

        high = Math.min((sum+b)/(r*c),high); //내가있는 값으로 만들 수 있는제일 큰값, 제일 높은 블럭
        

        int result = Integer.MAX_VALUE; // 결과값
        int idx = low; //평지의 높이
        low = sum/(r*c); //각 밭의 평균이 만들수 있는 평지의 최소값임

        for (int k = low; k <= high; k++) {
            int second = 0;
            //각 맵을 돌면서 확인하기
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int val = map[i][j];
                    if(k - val >=0){
                        second += k-val;
                    }else{
                        second += 2*(val-k);
                    }
                }
            }
//            System.out.println("k : "+k+",   second : "+second);
            if(result >= second){
                result = second;
                idx = k;
            }
        }

        System.out.printf("%d %d",result, idx);



    }
}

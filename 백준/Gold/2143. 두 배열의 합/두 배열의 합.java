

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합을 구하는 코드
        for (int i = 1; i < n; i++) {
            a[i] += a[i - 1];
        }

        for (int i = 1; i < m; i++) {
            b[i] += b[i - 1];
        }

        //왜지?
        int aSize = n*(n+1)/2;
        int bSize = m*(m+1)/2;
        long[] aSum = new long[aSize];
        int idx = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                int av = a[j];
                if(i > 0) av = av - a[i-1];
                aSum[idx++] = av;
            }
        }


        long[] bSum = new long[bSize];
        idx = 0;
        for(int i  =0;i<m;i++){
            bSum[idx++] = b[i];
            for(int j = 0;j<i;j++){
                bSum[idx++] = b[i]-b[j];
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        int left = 0;
        int right = bSize-1;
        long cnt = 0;

        while(left < aSize && right >=0){
            long asv = aSum[left], bsv = bSum[right];
            long sum = asv + bsv;
            if(sum == t){ // 원하는 값이 나오면
                long ac = 0, bc = 0;
                while(left < aSize && asv == aSum[left]){
                    left++;
                    ac++; // 얼마나 같은 값이 존재하는가.
                }

                while(right >= 0 && bsv == bSum[right]){
                    right--;
                    bc++;
                }
                cnt += ac*bc;
            }

            if(sum > t){
                right--; //크면 줄여야 한다.
            }else if(sum<t){
                left++; //작으면 늘려야 한다.
            }


        }

        System.out.println(cnt);


    }
}
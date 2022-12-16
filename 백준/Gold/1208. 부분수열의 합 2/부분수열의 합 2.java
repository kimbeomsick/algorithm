

import java.util.*;

/**
 * 1. N 이 최대 40 이라 부분순열 찾으면 1,000,000,000,000 까지 경우의 수가 늘어난다.
 * 2. 그래서 N을 2개의 집합으로 나눈뒤 그것들의 부분집합의 합을 구하면 2,000,000로 바뀜
 * 3. 2개로 나눈 집합을 각각 정렬한뒤 투포인터 알고리즘을 사용하여 S가 되는 경우의 수를 구한다.
 * 4. S == 0인 경우는 투포인터를 사용했을 때 0과 0 이 선택 될 수 있기 때문에 결과 값에서 -1 해준다.
 */

public class Main {

    static int N, S;
    static int[] arr;
    static List<Long>left = new ArrayList<>();
    static List<Long>right = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];


        for(int i = 0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        dfs(0,N/2,0l, left);
        dfs(N/2 ,N ,0l,right);


        Collections.sort(left);
        Collections.sort(right);

        Long result = twoPointfunc();
        if(S == 0){
            result -= 1;
        }
        System.out.println(result);



    }
   static void dfs(int st, int ed, Long sum, List<Long> list){
        if(st == ed){
            list.add(sum);
            return;

        }

        dfs(st+1,ed,sum+arr[st],list);
        dfs(st+1,ed,sum,list);
    }

    static long twoPointfunc(){
        int pl =0 ;
        int pr = right.size()-1;
        long cnt = 0; //S와 비슷한 값을 얼마나 찾을 수 있는지 확인

        //두 포인터가 아직 범위를 벗어나지 않았다면
        while(pl < left.size() && pr >= 0){

            // 두 포인터가 가리키는 값을 더함 => 부분집합의 합
            Long sum = left.get(pl)+ right.get(pr);


            if(sum == S){ // 결과 값이 나왔을 때
                long a = left.get(pl);
                long cnt1 = 0;
                //left를 이동시킬건데 얼마나 갈 수 있는지 확인하고 그 개수를 cnt1에 저장한다.
                while(pl < left.size() && left.get(pl) == a){
                    pl++;
                    cnt1++;
                }

                long b = right.get(pr);
                long cnt2 = 0;
                while(pr >= 0 && right.get(pr) == b){
                    pr--;
                    cnt2++;
                }
                cnt += cnt1 * cnt2;
            }else if(sum < S){
                pl++;
            }else{
                pr--;
            }

        }
        return cnt;
    }
}

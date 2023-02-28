import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int Max = Integer.MIN_VALUE;
    static int Min = Integer.MAX_VALUE;
    static int [] numList, calList;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            // 숫자를 받아온다.
            numList[i] = Integer.parseInt(st.nextToken());
        }

//        연산자 받아오기

        calList = new int[N-1]; //모든 사칙연산에 대한 규칙이 담겨있다.
        visited = new boolean[N-1]; //어떤 사칙연산을 선택했는지 보여준다.
        int calc= 0, idx = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<4;i++){
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0;j<cnt;j++){
                calList[idx++] = calc;
            }
            calc++;
        }

        func();

        System.out.println(Max);
        System.out.println(Min);


    }

    static void func(){
        if(stack.size() == N-1){
            //계산하기
            int val = calc();
            Max = Math.max(val, Max);
            Min = Math.min(val, Min);
            return;
        }

        for(int i = 0;i < calList.length;i++){
            if(visited[i]) continue;

            visited[i] = true;
            stack.push(calList[i]);
            func();
            stack.pop();
            visited[i] = false;
        }

    }

    static int calc(){
        int num = numList[0];

        for(int i = 0;i<N-1;i++){
            int option = stack.get(i);

            if(option == 0){
                num += numList[i+1];
            }

            if(option == 1){
                num -= numList[i+1];
            }

            if(option == 2){
                num *= numList[i+1];
            }

            if(option == 3){
                num /= numList[i+1];
            }

        }

        return num;
    }
}

//          3`
//        3 4 5
//        1 0 1 0`
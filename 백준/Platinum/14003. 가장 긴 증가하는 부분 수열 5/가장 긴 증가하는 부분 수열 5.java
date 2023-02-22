import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] order = new int[N]; //누가 몇번째에 들어갔는지 트래킹 => 뒤에서 순서대로 뽑는다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result.add(arr[0]);
        order[0] = 0;


        //result에 넣기
        for (int i = 1; i < N; i++) {
            if (result.get(result.size() - 1) < arr[i]) { //나보다 크다면 추가하기
                order[i] = result.size();
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
                    order[i] = left;
            }
        }
        System.out.println(result.size());


//        for( int m : result){
//            System.out.print(m+" ");
//        }
//        System.out.println();
//        for( int m : order){
//            System.out.print(m+" ");
//        }
//        System.out.println("\n\n");

        int length = result.size()-1;

        //백트레킹
        Stack<Integer> stack = new Stack<>();
        for(int i = N-1;i>=0;i--){
            if(order[i] == length){
                length--;
                stack.push(arr[i]);
            }
        }

        //백트레킹한거 꺼내서 빌더에 넣음 
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        System.out.println(sb);


    }
}

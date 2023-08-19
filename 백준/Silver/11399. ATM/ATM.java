import java.util.*;

class Main{
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int num = 0;
        int answer = 0;
        for(int i = 0;i<N;i++){
            num += arr[i];
            answer += num;
        }

        System.out.println(answer);
    }


}
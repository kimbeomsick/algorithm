import java.util.*;

class Main{
    static int N ,target;
    static int[] arr;
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        N = sc.nextInt();
        target = sc.nextInt();

        arr = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        for(int i= N-1;i>=0;i--){
            if(target >= arr[i]){
                answer += target/arr[i];
                target = target%arr[i];
            }
        }
        System.out.println(answer);

    }


}
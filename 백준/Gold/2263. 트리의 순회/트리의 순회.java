import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static int N, cnt = 0;
    static int[] inOrder, postOrder;
    static List<Integer> preOrder;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();
        inOrder = new int[N];
        postOrder = new int[N];
        preOrder = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            inOrder[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            postOrder[i] = sc.nextInt();
        }


        func(0, N, N - 1);

        for(int i:preOrder){
            System.out.print(i+" ");
        }
    }

    static void func(int st, int ed, int val) {


        for (int i = st; i < ed; i++) {
            if(postOrder[val] == inOrder[i]){
                preOrder.add(postOrder[val]);
                func(st, i,val-(ed-i));
                func(i+1,ed,val-1);
            }
        }

    }
}
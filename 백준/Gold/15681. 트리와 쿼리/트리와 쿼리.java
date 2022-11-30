import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int map[][];
    static List<Integer>[] list;
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          int N = sc.nextInt();
          int R = sc.nextInt();
          int Q = sc.nextInt();

          map = new int [N+1][2]; // 방문처리 + 자식 노드의 개수 삽입

        list = new ArrayList[N+1]; //1부터 시작해야하니까..
        //초기화
        for(int i = 0;i<=N;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0;i<N-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        //루트노드를 기준으로 서브트리의 크기 만들기
        makeTree(R);

        for(int i =0 ; i<Q;i++){
            int a = sc.nextInt();
            System.out.println(map[a][1]);
        }


    }

    static int makeTree(int root){
        map[root][0] = 1; //들어오면서 방문처리
        int sum = 1;

        for(int i : list[root]){
            if(map[i][0] == 0){ // 아직 방문하지 않았다면
                sum += makeTree(i); // 들어가면 방문처리해줌
            }
        }
        map[root][1] = sum;
        return sum;
    }
}
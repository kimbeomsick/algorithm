
import java.util.Scanner;

public class Main{

    static int []parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();

        //부모배열
        parent = new int[N+1];

        //초기화
        for(int i = 0;i<=N;i++){
            parent[i] = i;
        }

        for(int i = 0;i<M;i++){
            int op = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt();
            switch(op){
                case 0:
                    union(x,y);
                    break;
                case 1:
                    isUnion(x,y);
                    break;
            }
        }
    }
    //부모 찾아주는 함수
    static int find(int x){
        if( parent[x] == x ) return x;
        return parent[x] = find(parent[x]); //부모 통일
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return;
        parent[y] = x;
    }

    static void isUnion(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
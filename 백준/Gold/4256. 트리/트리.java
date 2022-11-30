

import java.util.Scanner;

public class Main{
    static int preOrder[];
    static int inOrder[];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        //테스트 케이스
        for(int t= 1;t<=tc;t++){
            int N = sc.nextInt();

            //전위 순회
            preOrder = new int[1001];

            //중위 순회
            inOrder = new int[1001];

            for(int i=0;i<N;i++){
                preOrder[i] = sc.nextInt();
            }
            for(int i=0;i<N;i++){
                inOrder[i] = sc.nextInt();
            }

            postOrder(0,N,0);
            System.out.println();

        }

    }

    private static void postOrder(int s, int e, int r) { //r: 갈라치기 하는 기준
            for(int i=s;i<e;i++){
                if(preOrder[r] == inOrder[i]){
                    postOrder(s,i,r+1);
                    postOrder(i+1,e,r+i-s+1); //r: 갈라치기 index ,  i-s : 왼쪽 서브루트 크기 , +1 크기 다음이 오른쪽 서브루트의 루트노드임
                    System.out.print(preOrder[r]+" "); //루트노드 출력
                }
            }
    }
}


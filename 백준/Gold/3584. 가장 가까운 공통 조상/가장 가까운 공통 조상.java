
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        //테스트 케이스
        for(int t = 1;t <=tc;t++){

            int N = sc.nextInt(); //노드의 개수

            int []arr = new int[N+1];
            for(int i = 0;i<=N;i++){
                arr[i] = i;
            }

            //N-1 만큼 간선의 정보가 들어옴
            for(int i = 0;i<N-1;i++){
                int parent = sc.nextInt();
                int child = sc.nextInt();

                arr[child] = parent; //부모노드 저장
            }

            //가장 가까운 부모 찾기
            int a = sc.nextInt();
            int b = sc.nextInt();

            //a의 모든 부모 담기
            List<Integer> ap = new ArrayList<>();
            ap.add(a); //자기자신 넣음
            while(true){
                int curr = a;
                int up = arr[a];
                if(curr == up) break;
                ap.add(up);
                a = up;
            }
            //부모 담기 끝
            while(true){
                //내가 고른넘이 ap안에 있으면 조상 겹치는거임
                if(ap.indexOf(b) >= 0) {
                    System.out.println(b);
                    break;
                }
                //더이상 올라갈 부모가 없으면 종료
                if(b == arr[b]) break;
                b = arr[b];
            }


        }
    }

}
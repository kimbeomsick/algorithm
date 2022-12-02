
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int cnt = 1;
        int idx = 0;
        while (true) {

            //탈출
            if (list.size() == 1) break;

            //몇번 이동해야하는지 1, 8, 27...  -1
            long count = (long) Math.pow(cnt++, 3) -1; //나 자신을 1로 세야하기 때문에 -1함

            //사이즈로 나눠도 한바퀴 도는 경우는 다 버림
            int move =(int)(count % list.size());

            // 지워야할 idx 위치, 크가가 list.size을 넘어갈 수 있기 때문에 나머지를 사용
            idx = (idx + move) % list.size();

            //걸린사람 자리 지우기
            list.remove(idx); //지워도 idx의 값은 변하지 않음

        }


            System.out.println(list.get(0));

    }
}
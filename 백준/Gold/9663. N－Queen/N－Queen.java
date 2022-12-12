import java.util.*;


//n*n 에 서로다른 퀸 n이 놓이려면 1줄에 하나씩 퀸이 있어야함

public class Main {

    static List<Integer> map; //결과 값 담을 배열
    static int N, result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new ArrayList<>();

        dfs(map);
        System.out.println(result);


    }

    static void dfs(List<Integer> map) {
        int r = map.size();
        //경우의 수 증가
        if(N == map.size()){

            result++;
            return;
        }

        // 내자리 오기전까지 겹치는게 있는지 확인한다.
        for(int i = 0;i<N;i++){ // 열 확인하기
            boolean check = true;

            //r행의 i열이 유효한지 검사한다.
            for(int j = 0;j<map.size();j++){
                //이전 코드에 걸리는지 확인
                if(i == map.get(j) || r+i == j+map.get(j) || r-i == j- map.get(j)) check = false;
            }

            if(check){
                map.add(i); // 해당 행열 삽입
                dfs( map);
                map.remove(map.size()-1); // 마지막 값 삭제
            }

        }
    }

}

import java.util.Scanner;
import java.util.Stack;

/**
 * 1. 0.0 부터 탐색하면서 상하좌우를 stack에 담아둠
 * 2. contains() 함수로 다음 상하좌우에 이미 stack에 담긴 값이랑 똑같은거 있는지 확인
 * 3. 없으면 담고 있으면 다음 상하좌우 탑색
 * 4. stack의 size()의 최대값이 곧 결과
 */

public class Main {

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int R, C, result = 0;
    static char[][] map;
    static int visited[] = new int[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        R = sc.nextInt();
        C = sc.nextInt();

        //map초기화
        map = new char[R][C];
        for(int i = 0;i<R;i++){
            String str = sc.next();
            for(int j = 0;j<C;j++){
                map[i][j] = str.charAt(j);
            }
        }
        Stack<Character> stack = new Stack<>();
        stack.add(map[0][0]);
        visited[map[0][0]-'0'] = 1;
        func(0, 0, stack);
        System.out.println(result);

    }

    static void func(int r, int c, Stack<Character> stack){

        if(stack.size() > result){
            result = stack.size();
        }


        for(int i = 0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= R || nc < 0 || nc >=C) continue;
            if(visited[map[nr][nc]-'0'] == 1) continue;


            stack.add(map[nr][nc]);
            visited[map[nr][nc]-'0'] = 1;
            func(nr,nc,stack);
            visited[map[nr][nc]-'0'] = 0;
            stack.pop();


        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] cctv = {{0,0,0,0},{0,1,0,0},{0,1,0,1},{1,1,0,0},{1,1,0,1},{1,1,1,1}};

    static int map[][] ;
    static ArrayList<int[]> list;
    static Stack<Integer> stack = new Stack<>();
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        map = new int[R][C]; //배열

       list = new ArrayList<>(); // 시작 지점 저장

        for(int i = 0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<C;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num > 0 && num < 6){
                    list.add(new int[]{i,j});
                }
            }
        }


        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int depth){
        if(list.size() == depth){
            emptyPlace(map);
            return;
        }

        for(int i = 0;i<4;i++){
            stack.add(i);
            dfs(depth+1);
            stack.pop();
        }

    }

    //빈공간 찾기
    public static void emptyPlace(int MAP[][]){
        int R = MAP.length;
        int C = MAP[0].length;
        int newMap[][] = new int[R][C];

        //복사하기
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                newMap[i][j] = MAP[i][j];
            }
        }


//        System.out.println("== >");
        //cctv의 위치와 각 cctv의 회전방향을 뽑아 색칠하기
        for(int i = 0;i<stack.size();i++){
            int direction = stack.get(i); //방향

            //cctv가 있는 위치
            int r = list.get(i)[0];
            int c = list.get(i)[1];

            //감시영역 색칠하기 => 색칠한 부분은 -1로 통일
            drawPath(r,c,newMap, direction, R, C); // 길 그리고 오기
        }

        //빈공간 갯수 구하기
        int cnt = 0;
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(newMap[i][j] == 0){
                    cnt++;
                }
            }
        }

//        //그려보기
//        if(cnt == 1){
//            paint(newMap);
//        }
//        System.out.println("<== ");
//
//        System.out.println();

        result = Math.min(cnt,result); // 가장 적은 사각지대 구하기
    }

    //cctv 방향 색칠하기
    static public void drawPath(int r, int c, int MAP[][], int direction, int R, int C){


        int cctvNum = MAP[r][c];

//        System.out.printf("(%d,%d)에 있는 %d번 cctv [%d]방향으로 그림",r,c,cctvNum, direction);
        for(int i = 0;i<4;i++){
            if(cctv[cctvNum][(i+direction)%4] == 0)continue; // i를 direction (0~3)방향으로 밀면서 보기
            int nr = r;
            int nc = c;
            while(true){
                nr += dr[i];
                nc += dc[i];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C) break; // 범위에서 벗어나면 안됨
                if(MAP[nr][nc] == 6)break; // 벽에 닿아도 안됨
//                System.out.printf(" (%d, %d) ",nr,nc);
                if(MAP[nr][nc] == 0){ // cctv가 없는자리면 -1로 만들기
                    MAP[nr][nc] = -1;
                }

            }
//            System.out.println();
        }
    }

    static public void paint(int[][] MAP){
        int R = MAP.length;
        int C = MAP[0].length;

        for(int i = 0;i<R;i++){
            System.out.println();
            for(int j = 0;j<C;j++){
                System.out.print(MAP[i][j]+" ");
            }
        }

    }

}
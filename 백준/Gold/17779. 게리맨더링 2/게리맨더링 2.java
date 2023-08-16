import java.util.*;

class Main {
    static int answer = 0;
    static int[][] map;
    static int total = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = Integer.MAX_VALUE;

        map = new int[N+1][N+1];

        for(int i = 1;i<=N;i++){
            for(int j = 1;j<=N;j++){
                map[i][j] = sc.nextInt();
                total += map[i][j];
            }
        }

        //4중 for문으로 경계 설정
        for(int i = 1;i<=N;i++){
            for(int j = 1;j<=N;j++){
                for(int d1 = 1;d1<=N-i-1;d1++){
                    for(int d2 = 1;d2<=N-i-1;d2++){
                        if(d1+d2+i > N) continue;
                        if(j-d1 < 1 || j+d2 >N) continue;

                        answer = Math.min(answer,func(i,j,d1,d2,N));
                    }
                }

            }
        }
        System.out.println(answer);
    }

    public static int func(int x,int y, int d1, int d2, int N){
        boolean[][] visited = new boolean[N+1][N+1]; // 방문 배열
        int[] place = new int[5];
        int cnt = 0;

        //경계 만들기
        for(int i = 0;i<=d1;i++){
            visited[x+i][y-i] = true;
            visited[x+d2+i][y+d2-i] = true;
        }

        for(int i = 0;i<=d2;i++){
            visited[x+i][y+i] = true;
            visited[x+d1+i][y-d1+i] = true;
        }



        //1 구역
        for(int i =1 ;i<x+d1;i++){
            for(int j = 1;j<=y;j++){
                if(visited[i][j])break;
                place[0] += map[i][j];
                cnt += map[i][j];
            }
        }

        //4 구역
        for(int i =x+d1 ;i<=N;i++){
            for(int j = 1;j<y-d1+d2;j++){
                if(visited[i][j])break;
                place[3] += map[i][j];
                cnt += map[i][j];
            }
        }

        //2 구역
        for(int i = 1;i <= x+d2;i++){
            for(int j = N;j >= y+1;j--){
                if(visited[i][j])break;
                place[1] += map[i][j];
                cnt += map[i][j];
            }
        }

        //3 구역
        for(int i = x+d2+1;i<=N;i++){
            for(int j = N;j >= y-d1+d2;j--){
                if(visited[i][j])break;
                place[2] += map[i][j];
                cnt += map[i][j];
            }
        }



        //5구역 값
        place[4] = total - cnt;
        Arrays.sort(place);



        return place[4]-place[0];


    }

}
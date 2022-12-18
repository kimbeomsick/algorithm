import java.util.Scanner;

public class Main {

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int N,cnt1, cnt2;
    static char[][] map, RGmap;
    static int[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new char[N][N];
        RGmap = new char[N][N];

        for(int i = 0;i<N;i++){
            String str = sc.next();
            for(int j = 0;j<N;j++){
                char c = str.charAt(j);
                map[i][j] = c;
                if(c == 'R' || c == 'G'){
                    RGmap[i][j] = 'R';
                }else{
                    RGmap[i][j] = c;
                }
            }
        }

        cnt1 = 0;
        visited = new int[N][N];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(visited[i][j] == 0){
                    func(i,j,++cnt1,map);
                }
            }
        }

        cnt2 = 0;
        visited = new int[N][N];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(visited[i][j] == 0){
                    func(i,j,++cnt2,RGmap);
                }
            }
        }

        System.out.println(cnt1+" "+cnt2);

    }


    static void func(int r,int c, int cnt, char[][] map ){
        visited[r][c] = cnt;

        for(int i = 0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N)continue; //범위 벗어나면 안됨
            if(visited[nr][nc] > 0)continue; // 방문안한곳
            if(map[r][c] != map[nr][nc]) continue; // 같아야함

            func(nr,nc, cnt, map);
        }
    }
}
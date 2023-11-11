import java.io.*;
import java.util.*;



class Main{
	static int[][] dp ; //경로 경우의 수를 담기위한 배열
	static int[] dr = {0,1,-1,0};
	static int[] dc = {1,0,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		dp = new int[R][C]; 		
		int[][] map = new int[R][C];
		for(int i = 0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// -1로 모든 지역을 초기화 해주므로써 visited를 대신함 
		for(int[] d : dp) {
			Arrays.fill(d,-1);
		}
	
		//결과값 출력
		System.out.println(func(map,0,0,R,C));
		
	}
	
	static public int func(int[][] map, int r, int c,int R, int C) {
		
		//도달하면 1 리턴
		if(r == R-1 && c == C-1) {
			return 1; 
		}
		
		// -1이 아니라는건 이길로 이미 목표까지 가봤다는 뜻 => 0이면 못간다는뜻
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		
		// 길은 맞는데 이길로 목표지점에 도달할수 있을지는 모르니까 0
		dp[r][c] = 0; 
		for(int i = 0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nc < 0 || nr >=R || nc >=C) continue;
			if(map[r][c] <= map[nr][nc] ) continue;

			//r, c 보다 낮은지점 nr,nc 로 갔을때 목표지점에 도달할 수 있는 경우의 수를 dp[r][c]에 저장
			dp[r][c] += func(map, nr,nc,R,C);
		}
		
		//결과 값 반환
		return dp[r][c];
	}
}


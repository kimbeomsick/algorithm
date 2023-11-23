

import java.io.*;
import java.util.*;

// tip: each public class is put in its own file
public class Main
{
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int R,C;
	static boolean end = false;
	static int result = 0;
	
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        
        
        map = new int[R][C];
        
        for(int i = 0;i<R;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0;j<C;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        func(r,c,dir);
        
        //지나간 길 개수확인 
        int sum = 0;
        for(int i = 0;i<R;i++) {
        	
        	for(int j = 0;j<C;j++) {
        		if(map[i][j] == 2) {
        			sum ++;
        		}
        	}
        }
//        show();
        System.out.println(-result);
        
    }
    
    static public void func(int r,int c, int dir) {

    	
    	if(end) return ;
    	if(map[r][c] == 0 ) {
    		map [r][c] = --result;
    	}
    	
    	
    	//주변에 청소되지 않은 칸이 있는지 확인 
    	for(int i = 3;i>=0;i--) {
    		int ndir = (dir+i)%4;
    		int nr = r+dr[ndir];
    		int nc = c+dc[ndir];
    		if(nr < 0 || nr >=R || nc <0 || nc >=C)continue; // 길에서 벗어나면 안됨 
    		if(map[nr][nc] == 0) {
    			func(nr,nc,ndir);
    		}
    	}
    	
    	
    	//청소되지 않은곳이 없어서 뒤로가기 
    	int reverse = (dir+2)%4;
    	int nr = r+dr[reverse];
    	int nc = c+dc[reverse];
    	
    	//뒤로가는데 벽이고 , 혹은 화면 밖으로 나간다면 아웃...
    	if((nr < 0 || nr >=R || nc <0 || nc >=C)|| map[nr][nc] == 1 ) {
    		end = true; // 이제부터 뒤로가겠다는 이야기 
    		return ;
    	}
    	func(nr,nc,dir);
    }

    static public void show() {
    	for(int[] m : map) {
    		System.out.println(Arrays.toString(m));
    	}
    }

}
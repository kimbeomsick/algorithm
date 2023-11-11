import java.io.*;
import java.util.*;



class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		
		for(int t = 0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			//주어진 동전의 개수 
			int N = Integer.parseInt(st.nextToken());
			int[] coins = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++) {
				coins[i] =  Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			
			int[] dp = new int[M+1]; // 하나더 많게 해야함 
			
			for(int i = 0;i<N;i++) {
				int coin = coins[i];
				for(int j = coin;j<M+1;j++) {
					if(coin == j) {
						dp[j]++;
					}else {
						dp[j] = dp[j] + dp[j-coin];
					}
				}
				
			}
			
			System.out.println(dp[M]);
			
		}
		
	}
}

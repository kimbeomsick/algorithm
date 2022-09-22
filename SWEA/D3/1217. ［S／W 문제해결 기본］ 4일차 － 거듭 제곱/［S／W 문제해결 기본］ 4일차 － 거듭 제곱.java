
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {

			int t = sc.nextInt();

			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.printf("#%d %d\n",t,(long)pow(N,M));	
			
		}
	}
	static int pow(int N, int M) {
		
		if(M == 1) {
			return N;
		}
		
		if(M%2 == 1) {
			return pow(N,M/2) * pow(N,M/2+1);
		}else {
			return pow(N,M/2) * pow(N,M/2);
		}
		
	
	}
	
}

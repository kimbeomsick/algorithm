import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		String Astr = br.readLine();
		String Bstr = br.readLine();
		int Alen = Astr.length();
		int Blen = Bstr.length();
		
		//배열 만들기 
		int[][] dp = new int[Blen+1][Alen+1];
		
		//문자열 배열 
		
		char Alist[] = new char[Alen+1];
		char Blist[] = new char[Blen+1];
		
		for(int i = 1;i<=Alen;i++) {
			Alist[i] = Astr.charAt(i-1);
		}
		
		for(int i = 1;i<=Blen;i++) {
			Blist[i] = Bstr.charAt(i-1);
		}
		
		

		
		for(int i = 1;i<=Alen;i++) {
			for(int j = 1;j<=Blen;j++) {
				if(Alist[i]-'0' == Blist[j]-'0') {  
					dp[j][i] = dp[j-1][i-1]+1; //둘이 같으면 대각선에 있는 값 +1
				}else {
					dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]); //둘이 다르면 아래위에 있는놈 비교해서 제일 큰거 넣기 
				}
			}
		}
		
		
		System.out.println(dp[Blen][Alen]);
	}
}
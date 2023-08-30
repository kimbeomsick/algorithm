import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static char[] charr = {'B','O','J'};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] dp = new int[N];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i = 0;i<N;i++){
            if(dp[i] != -1){ //-1이 아닌경우를 찾음 => 뛰어서 갈 수 있는자리임
                for(int j = i+1;j<N;j++){ //다음 뛸 자리를 끝까지 순회함
                    char s = str.charAt(i);
                    char e = str.charAt(j);

                    if(s == 'B' && e == 'O'){
                        func(str,dp, i,j);
                    }
                    if(s == 'O' && e == 'J'){
                        func(str,dp, i,j);
                    }
                    if(s == 'J' && e == 'B'){
                        func(str,dp, i,j);
                    }
                }
            }
        }


        System.out.println(dp[N-1]);
    }

    public static void func(String str,int[] dp ,int i,int j){
        if(dp[j] == -1){
            dp[j] = ((j-i)*(j-i))+dp[i]; // 제곱 넣기
        }else{
            dp[j] = Math.min(((j-i)*(j-i))+dp[i],dp[j]);
        }
    }
}
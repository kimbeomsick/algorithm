
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int alpha[] = new int[26]; // 해당 알파벳의 가치가 얼마나 큰지 저장한다.

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(str.length() - 1 - j); //제일 우측에 있는 알파벳이 1의자리이기 때문에 오른쪽 부터 왼쪽으로 탐색
                //ch - 'A' 를 하면 대문자에 대한 index가 나온다. 'A'-'A' = 0   'Z'-'A' = 25
                //알파벳에 해당하는 index에 가치를 넣는데 A가 10의 자리에 있다면 alpha[0] += 10 을 저장하게 된다.
                //'B'가 100의 자리에 있다면 alpha[1] += 100
                alpha[ch - 'A'] += Math.pow(10, j);
            }
        }


        Arrays.sort(alpha); //가치의 순서대로 정렬한다.
        int num = 9; // 알파벳은 9~0까지의 수를 갖는다.
        int result = 0; //결과
        for(int i = 25;i>=0;i--){
            if(alpha[i] ==0) continue; //해당 알파벳이 없다면 통과
            result += alpha[i]*num--; //제일 가치가 큰 알파벳이 9를 갖고 나머지가 8 7 6 하나씩 작은 수를 갖는다.
            if(num == 0 )break;
        }

        System.out.println(result); //결과출력

    }
}

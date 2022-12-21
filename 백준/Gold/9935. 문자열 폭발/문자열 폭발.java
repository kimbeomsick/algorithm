import java.util.*;


public class Main {


    static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        str = sc.next();
        String point = sc.next();
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            stack.add(ch);

            if (stack.size() < point.length()) continue;

            if (ch - point.charAt(point.length() - 1) == 0) {
                int pcnt = point.length() - 1;
                int scnt = stack.size() - 1;
                int cnt = 0;
                while (true) {
                    if (pcnt < 0) break;
                    if (scnt < 0) break;

                    if (point.charAt(pcnt) - stack.get(scnt) == 0) {
                        cnt++;
                        pcnt--;
                        scnt--;
                    } else {
                        break;
                    }
                }
                if (cnt == point.length()) {
                    for (int j = 0; j < cnt; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}


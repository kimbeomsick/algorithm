
import java.util.*;



public class Main {

    static String correct = "123456780";
    static Map<String, Integer> map = new HashMap<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "";

        for(int i = 0;i<9;i++){
            String s = sc.next();
            str += s;
        }

        map.put(str, 0);
        System.out.println(bfs(str));



    }
    static int bfs(String str){
        Queue<String> q = new LinkedList<>();
        q.add(str);
        while(!q.isEmpty()){
            String curr = q.poll();
            int move = map.get(curr); // 배열이 아니라 맵으로 출결 관리함 ㄹㅇ
            int empty = curr.indexOf('0');
            int px = empty%3;
            int py = empty/3;

            if(curr.equals(correct)){
                return move; // 발견한다면 이동횟수 리턴
            }

            for(int i = 0;i<4;i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || nx > 2 || ny < 0 ||ny > 2) continue;

                int nPos = ny*3 + nx;
                char ch = curr.charAt(nPos);
                String next = curr.replace(ch,'c'); // 새로운 자리에 넣음
                next = next.replace('0',ch);
                next = next.replace('c','0'); // 자리변경

                if(!map.containsKey(next)) // map에 들어가있는것 자체가 visited된거임
                {
                    q.add(next);
                    map.put(next,move+1);
                }
            }

        }
        return -1;
    }


}


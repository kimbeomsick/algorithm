
import java.sql.Array;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //SringTokenizer st = new StringTokenizer(br.readLine()); //여기서 하나씩 뽑으면 됨

        //배열 받기
        ArrayList<Integer>[] list = new ArrayList[5]; //1~4번까지 사용함
        for(int i = 1;i<5;i++){
            list[i] = new ArrayList<>();
            String str = br.readLine();
            for(int j = 0;j<str.length();j++){
                list[i].add(str.charAt(j)-'0');
            }
        }


        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0;i<N;i++){ //명령을 받는 횟수
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()); //톱니바퀴 이름
            int direction = Integer.parseInt(st.nextToken()); //방향 1 시계 -1 반시계

            Queue<Integer> q = new LinkedList<>();
            int visited[] = new int[5]; // 여기에 방향을 넣자
            q.add(idx);
            visited[idx] = direction;
            while(!q.isEmpty()){
                int curr = q.poll();

                //3을 넣었다면 방문을하지 않았다면 1, 2를 넣을 수 있는지 확인한다
                if( (curr-1 > 0 && visited[curr-1] == 0) && list[curr].get(6) != list[curr-1].get(2)){
                    q.add(curr-1);
                    visited[curr-1] = (-1)*visited[curr];
                }

                if( (curr+1 <= 4 && visited[curr+1] == 0) && list[curr].get(2) != list[curr+1].get(6)){
                    q.add(curr+1);
                    visited[curr+1] = (-1)*visited[curr];
                }
            }

            for(int j = 1;j<5;j++){
                if(visited[j] == -1 ){
                     int num = list[j].get(0);
                     list[j].remove(0);
                     list[j].add(num);
                }else if(visited[j] == 1){
                    int num = list[j].get(7);
                    list[j].add(0,num);
                    list[j].remove(8);
                }
            }


        }
        int result = 0;
        for(int i = 1;i<=4;i++){
            int num = (list[i].get(0) == 0)? 0 : (int)Math.pow(2,i-1);
            result+= num;
        }

        System.out.println(result);
    }
}
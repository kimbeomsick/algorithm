
import java.util.*;
import java.io.*;


public class Main {
    static int  result = 0;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine()); //여기서 하나씩 뽑으면 됨

        int N =  Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int map[][] = new int[N][N];



        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 0. 경사로가 1이상 차이나면 false
        //1. 다음경사로가 높음 => 뒤로 몇개까지 나랑 같은지 확인 => 경사로 만든후 true배열
        //2. 다음경사로가 낮음 => 앞으로 몇개까지 나랑 같은지 확인  => 경사로 만든후 true배열
        //4. 경사로가 겹치면 false
        //5. 경사로가 동일하면 통과?

       for(int i = 0;i<N;i++){


           boolean flag = true;
           boolean visited[] = new boolean[N];
           for(int j = 1;j<N;j++){
             if(map[i][j] == map[i][j-1]){ //크기가 동일할때
                 continue;
             }else if(Math.abs(map[i][j] - map[i][j-1]) == 1){ // 차이가 1 일때
                    if( map[i][j] > map[i][j-1]){ //경사로가 높아짐
                        // 뒤에 있을 수 있는 경사로가 L보다 작은지 확인
                        if(L <= j){
                            int same = map[i][j-1];
                            for(int k = j-L ;k < j;k++){
                                if(same == map[i][k] && !visited[k]){ // 경사로가 아직 없고 전거랑 경사가 같으면
                                    visited[k] = true; //방문처리함
                                }else{ //경사로가 만들어질 수 없는경우 for문 탈출
                                    flag = false;
                                    break;
                                }
                            }
                        }else{
                            flag=false;
                            break;
                        }
                    }else{ //경사로가 낮아짐
                        // 앞으로 있는 경사가 L보다 큰지 확인
                        if(j+L <= N){
                            int same = map[i][j];
                            for(int k = j;k<j+L;k++){
                                if(map[i][k] == same && !visited[k]){
                                    visited[k] = true;
                                }else{
                                    flag = false;
                                    break;
                                }
                            }
                        }else{
                            flag=false;
                            break;
                        }
                    }
             }else{
                 flag = false;
                 break; //같지도 않고 차이가 1이상이면 이줄은 아닌거임
             }
           }
            if(flag)result++;
//=========================================================================================================
            flag = true;
           visited = new boolean[N];
            //방문배열 생성해야함!!!
           for(int j = 1;j<N;j++){
               if(map[j][i] == map[j-1][i]){ //크기가 동일할때
                   continue;
               }else if(Math.abs(map[j][i] - map[j-1][i]) == 1){ // 차이가 1 일때
                   if( map[j][i] > map[j-1][i]){ //경사로가 높아짐
                       // 뒤에 있을 수 있는 경사로가 L보다 작은지 확인
                       if(L <= j){
                           int same = map[j-1][i];
                           for(int k = j-L ;k < j;k++){
                               if(same == map[k][i] && !visited[k]){ // 경사로가 아직 없고 전거랑 경사가 같으면
                                   visited[k] = true; //방문처리함
                               }else{ //경사로가 만들어질 수 없는경우 for문 탈출
                                   flag = false;
                                   break;
                               }
                           }
                       }else{
                           flag=false;
                           break;
                       }
                   }else{ //경사로가 낮아짐
                       // 앞으로 있는 경사가 L보다 큰지 확인
                       if(j+L <= N){
                           int same = map[j][i];
                           for(int k = j;k<j+L;k++){
                               if(map[k][i] == same && !visited[k]){
                                   visited[k] = true;
                               }else{
                                   flag = false;
                                   break;
                               }
                           }
                       }else{
                           flag=false;
                           break;
                       }
                   }
               }else{
                   flag = false;
                   break; //같지도 않고 차이가 1이상이면 이줄은 아닌거임
               }
           }
           if(flag)result++;

       }

        System.out.println(result);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] distance = new int[D+1];

        Map<Integer , ArrayList<int[]>> map = new HashMap<>();
        for(int i= 0 ;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // a 에서 갈수 있는 거리 b와 그거리인 c를 연속적으로 저장해야한다.
            if(map.containsKey(a)){
                map.get(a).add(new int[]{b,c}); // 새롭게 추가
            }else{
                ArrayList<int[]> list = new ArrayList<>();
                list.add(new int[]{b,c});
                map.put(a,list);
            }
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        for(int i = 0;i<D;i++){
            distance[i+1] = Math.min(distance[i+1],distance[i]+1); //더 작은거 선택

            //지름길 있나 확인
            if(map.containsKey(i)){
                for(int[] a : map.get(i)){ //해당위치에서 갈 수 있는 지름길 다 찾아봄
                    int end = a[0];
                    int dist = a[1];

                    if(end <= D){ //내가 가려는 거리보다 멀면 소용 없음
                        //지금까지 온거리에서 지름길을 가냐, 아니면 원래 있던 길이 더 짧은가 확인
                        distance[end] = Math.min(distance[end],dist+distance[i]);
                    }
                }
            }
        }

        System.out.println(distance[D]);
    }
}

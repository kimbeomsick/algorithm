import java.util.*;



class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        int size;
        
        int picker_number = 0;
        for(int p : picks){
            picker_number+=p;
        }
        
        //5개씩 끊을 수 있는 크기
        if(minerals.length%5 == 0){
            size = minerals.length/5;
        }else{
            size = minerals.length/5+1;
        }
        
        //초기화
        for(int i = 0;i<size;i++){
            list.add(new int[3]); // 12면 3개 넣어줌 //[dia, iron, stone]
        }
        
        int cnt = 0;
        int idx = 0;
        for(String m : minerals){

            //다시 셋팅
            if (cnt == 5) {
                cnt = 0;
                idx++;   
                if(--picker_number == 0) break;
            }
            
            //피로도 계산하기
            if(m.equals("diamond")){
                list.get(idx)[0] += 1;
                list.get(idx)[1] += 5;
                list.get(idx)[2] += 25;
            }else if( m.equals("iron")){
                list.get(idx)[0] += 1;
                list.get(idx)[1] += 1;
                list.get(idx)[2] += 5;
            }else{
                list.get(idx)[0] += 1;
                list.get(idx)[1] += 1;
                list.get(idx)[2] += 1;
            }
            
            //카운트 증가
            cnt++;
            
        }
        for(int[] i :  list){
            System.out.println(Arrays.toString(i));
        }
        
        Collections.sort(list, (a,b)-> Integer.compare(b[2],a[2])); // 정렬
        
        //뽑음 
      idx = 0; // 다이아 곡괭이 부터 확인함 
        for(int i = 0;i<list.size();i++){
            
            while(idx < 3 && picks[idx] == 0 ){
                idx++;
            }
            if(idx == 3)break; // 없으면 종료
            
            int[] tired = list.get(i);
            answer += tired[idx];
            picks[idx]--;
        }
        
        
        
        
        return answer;
    }
}
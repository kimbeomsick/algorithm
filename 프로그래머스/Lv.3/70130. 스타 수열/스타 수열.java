import java.util.*;


class Solution {
    
    public int solution(int[] a) {
        int result = 0;
        int size = a.length;
        int[][] arr = new int[size][2];
        
        
        //어느 숫자가 몇번 씌였는지 확인
        for(int i = 0;i<size; i++){
            arr[a[i]][0]++; 
        }
        
        //순서 보장
        for(int i = 0;i<size;i++){
            arr[i][1]=i;
        }
        
        //정렬
        Arrays.sort(arr,(x,y)->{
            return y[0]-x[0];
        });
        
        // for(int i = 0;i<size;i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        
        for(int i = 0;i<size;i++){
            // if(arr[i][0] == 0) break;
            if(i == 2 ) break;
            
            int answer = 0;
            int num = arr[i][1]; // 제일 많은 숫자 or 그다음 많은 숫자 
            boolean[] visited = new boolean[size];
            
            //체크하기
            for(int j = 0;j<size;j++){
                if(a[j] == num) visited[j] = true;                
            }
            
            for(int j = 0;j<size;j++){
                if(a[j] == num){
                    if(j-1 >=0 && !visited[j-1]){ // 전이 넘기는게 아니고 방문처리가 안되어있다면 
                        visited[j-1] = true;
                        answer++;
                    }else if(j+1 < size && !visited[j+1]){
                        visited[j+1] = true;
                        answer++;
                    }else{
                        continue;
                    }
                }
            }
            result = Math.max(result, answer*2);
        }
        
        
        return result ;
    }
};
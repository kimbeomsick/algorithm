import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 도달했는데 못한사람/클리어한 사람
        
        
        int[] arr = new int[N+2]; //스테이지 통과한사람의 수 N+1은 5번째 스테이지 통과한 사람임 
        int[] sum = new int[N+2]; // 누적합 
        
        
        
        //스테이지별로 멈춘 사람 수 
        for(int i = 0;i< stages.length;i++){
            arr[stages[i]]++;
        }
        
        //누적합 계산
        for(int i = 1;i<=N+1;i++){
            sum[i] = sum[i-1]+arr[i];
        }
        
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(sum));
        
        
        //i까지의 누적합 n+1까지의 누적합은 통과한 사람 arr[i]는 거기서 멈춘사람
        
        ArrayList<double[]> list = new ArrayList<>();
        for(int i = 1;i<=N;i++){
            double cal = (sum[N+1]-sum[i-1] == 0) ? 0 : (double)arr[i]/(double)(sum[N+1]-sum[i-1]);
            // System.out.printf("i : %d,  cal : %f, arr[%d]:%d, sum[N+1]:%d, sum[ %d]: %d \n",i,cal,i,arr[i],sum[N+1],i,sum[i-1]);
            list.add(new double[]{i,cal});
        }
        
        // for(double[] a : list){
        //     System.out.println(Arrays.toString(a));
        // }
        
        Collections.sort(list,(a,b)->{
            if(a[1] == b[1]){
                return Double.compare(a[0],b[0]); //방번호는 오름차순
            }else{
                return Double.compare(b[1],a[1]); // 실패율 내림차순
            }
        });
        
        for(int i = 0;i<list.size();i++){
            answer[i] = (int)list.get(i)[0];
        }
        
       
        
        
        
        
        return answer;
    }
}
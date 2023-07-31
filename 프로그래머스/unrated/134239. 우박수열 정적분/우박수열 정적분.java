import java.util.*;


// 구간을 적분하라 
// [0.0] 이면 전 구간을 적분하는 것이고, 
// [0,-1] dlaus 0~2까지 

class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        
        List<Double> list = new ArrayList<>();
        list.add((double)0);
        int cnt = 0;
        while(true){
            int nk = 0;
            if(k%2 == 0){
                nk = k/ 2; 
            }else{
                nk = k*3+1;
            }
            list.add(Math.min(nk,k)+(double)Math.abs(nk-k)/2);
            if(nk == 1)break;
            k = nk;
        }
      //
        
        
        double[] arr = new double[list.size()];
        arr[0] = list.get(0);
        for(int i = 1;i<list.size();i++){
            arr[i] = list.get(i)+arr[i-1]; 
        }
        //System.out.println(Arrays.toString(arr));
        
        double []answer = new double[ranges.length];
        for(int i = 0;i<ranges.length;i++){
            int a  = ranges[i][0];
            int b  = ranges[i][1]+list.size()-1;
            
           // System.out.printf("(%d,%d)\n",a,b);/
            
            answer[i] = a > b ? -1 : arr[b] - arr[a];
        }
        
        //System.out.println(Arrays.toString(answer));
        return answer;
    }
}
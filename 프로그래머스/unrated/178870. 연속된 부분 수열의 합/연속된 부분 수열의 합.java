class Solution {
    public int[] solution(int[] sequence, int k) {
        int len = Integer.MAX_VALUE;
        int[] answer = new int[2];
        int size = sequence.length;
     
        int p = 0;
        int m = -1;
        
        int sum = sequence[p];
        while(m < p){
            
            // System.out.printf("\nm:%d, p:%d\n",m,p);
            //     System.out.printf("sum:%d, k:%d\n",sum,k);
            
            if(sum < k){
                ++p;
                if(p == size) break;
                sum+=sequence[p];
            }
            
            if(sum > k){
                ++m;
                if(m == size) break;
                sum -= sequence[m];
            }
            
             
            if(sum == k){
               ;
                
                if(len > p-m){
                    len = p-m;
                    answer[0] = m+1;
                    answer[1] = p;
                }
                if(m == p){
                    p++;
                    sum+=sequence[p];
                } else{
                    m++;
                    sum -= sequence[m];
                }
            }
        }
        
        
        
        return answer;
    }
}
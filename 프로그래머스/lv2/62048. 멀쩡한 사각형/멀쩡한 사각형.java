class Solution {
    public long solution(int w, int h) {
        long answer = 0;

        int n = gcd(w,h);
      return ((long)w*h)-(((w/n)+(h/n)-1)*n);
        
        
    }
    
  
    
        private int gcd(int n, int m)
    {
        while (n != m) 
        {
            if(n > m){
                n -= m;
            }else{
                m -= n;
            }
        }
        
        return n;
    }
}
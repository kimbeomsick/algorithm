

import java.io.*;
import java.util.*;

// tip: each public class is put in its own file
public class Main
{
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int T = Integer.parseInt(br.readLine());
        
        
        //  97~122
        for(int t = 0;t<T;t++) {
        	String str = br.readLine();
        	int len = Integer.parseInt(br.readLine());
        	
        	for(int i = 97 ;i <= 122;i++) {
        		List<Integer> list = new ArrayList<>();
        		char alpha = (char)i;
        		
        		for(int j = 0;j<str.length();j++) {
        			char ch = str.charAt(j);
        			
        			if(ch == alpha) {
        				list.add(j);
        			}
        			
        		}
        		
        		
        		
        		if(list.size() >= len) {
//        			System.out.printf("\n alpha %c\n",alpha);
        			for(int k = 0;k<=list.size()-len;k++) {
        				int start = list.get(k);
        				int end = list.get(len+k-1);
//        				System.out.printf("start:%d, end:%d\n",start,end);
        				
        				max = Math.max(max, end-start+1);
        				min = Math.min(min, end-start+1);
        				
        			}
        		}
        	}
        	
        	if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
        		System.out.println(-1);
        	}else {
        		System.out.printf("%d %d\n",min,max);
        		
        	}
        	
        	max = Integer.MIN_VALUE;
        	min = Integer.MAX_VALUE;
        }
    }
    
}
import java.io.*;
import java.util.*;



class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> plus_list = new ArrayList<>();
		ArrayList<Integer> minus_list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > 0) {
				plus_list.add(num);
			}else {
				minus_list.add(-num);
			}
		}
		
		ArrayList<Integer> result_list = new ArrayList<>();
		
		Collections.sort(plus_list);
		Collections.sort(minus_list);
		
		int idx = plus_list.size()-1;
		while(idx >= 0) {
			result_list.add(plus_list.get(idx));
			idx -= M;
		}

		idx = minus_list.size()-1;
		while(idx >= 0) {
			result_list.add(minus_list.get(idx));
			idx -= M;
		}
		
		Collections.sort(result_list);
		
		int result = 0;
		for(int i = 0;i<result_list.size();i++) {
			if(i == result_list.size()-1) {
				result+=result_list.get(i);
			}else{
				result+=result_list.get(i)*2;
			}
		}
		
			System.out.println(result);
		
	}

}

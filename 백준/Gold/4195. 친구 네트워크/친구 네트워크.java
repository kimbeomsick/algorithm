import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
	
	static HashMap<String, Integer> network;
	static int[] p;
	static int[] rank;
	public static void main(String []args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1;t<=tc;t++) { // 테스트케이스
			network = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			p = new int[N*2]; //부모 저장 
			rank = new int[N*2]; //크기 저장 
			Arrays.fill(rank, 1);
			makeSet();
			for(int i = 0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String str1 = String.valueOf(st.nextToken());
				String str2 = String.valueOf(st.nextToken());
				if(!network.containsKey(str1)) {
					network.put(str1,cnt++);
				}
				if(!network.containsKey(str2)) {
					network.put(str2,cnt++);
				}
				
				union(network.get(str1), network.get(str2));
			}
			
		}
		
	}
	
	static void makeSet() {
		for(int i = 0;i<p.length;i++) {
			p[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	
	//x가 부모가 됨 
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x != y) { //달라야만 변화가 생김, 같으면 의미가 없음  
			p[y] = x;
			rank[x] += rank[y];
		}
		
		System.out.println(rank[p[x]]);
	}
}


//2
//3
//Fred Barney
//Barney Betty
//Betty Wilma
//3
//Fred Barney
//Betty Wilma
//Barney Betty
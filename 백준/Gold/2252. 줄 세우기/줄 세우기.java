import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Stack<Integer> stack;
	static List<Integer>[] list;
	static boolean visited[] ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		stack = new Stack<>();
		//초기화 
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		int [] in_degree =new int[N+1]; 
		for(int i = 1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[b].add(a); // b에서a로 갈 수 있음 
			in_degree[a]++; //진입차수 증가 
		}
		
		for(int i = 1;i<=N;i++) {
			if(in_degree[i] == 0) {
				func(i);
			}
		}
		
		
	}
	static void func(int start) {
		visited[start] = true;
		
		
		for(int next : list[start]) {
			if(!visited[next] ) {
				func(next);
			}
		}
//		stack.add(start);
		System.out.print(start+" ");
	}

}
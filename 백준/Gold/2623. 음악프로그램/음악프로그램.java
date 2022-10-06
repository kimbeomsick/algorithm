
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 가수의 수
		int M = Integer.parseInt(st.nextToken()); // 보조 pd
		// 초기화
		list = new ArrayList[N + 1];
		int[] in_degree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken()); // 몇개 받아올지
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt - 1; j++) {
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b); // 갈수있는것 리스트로 받기
				a = b;
				in_degree[b]++; // 진입차수 증가
			}
		}
		
		Queue<Integer> q = new LinkedList<>();

		int cnt = 0;
		// 진입차수가 0인것 부터 시작
		for (int i = 1; i <= N; i++) {
			if (in_degree[i] == 0) {
				q.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int node = q.poll();
			sb.append(node).append("\n");
			cnt++;
			for(int next : list[node]) {
				if(--in_degree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		if(cnt != N) {
			System.out.println(0);
		}else {
			System.out.println(sb);
		}
	 

	}
 

}

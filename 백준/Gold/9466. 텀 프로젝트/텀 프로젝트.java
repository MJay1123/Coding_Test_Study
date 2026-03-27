import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] students;
	static int answer;
	static boolean[] visited;
	static int[] isCycle;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			n = Integer.parseInt(br.readLine());
			students = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}
			visited = new boolean[n+1];
			isCycle = new int[n+1];
			answer = n;
			for(int i=1; i<=n; i++) {
				if(!visited[i]) {
					DFS(i);					
				}
			}
			for(int i=1; i<=n; i++) {
			}
			sb.append(answer).append("\n");
//			System.out.println(Arrays.toString(visited));
//			System.out.println(Arrays.toString(isCycle));
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void DFS(int start) {
		if(visited[start]) {
			return;
		}
		List<Integer> list = new ArrayList<>();
		int current = start;
		while(!visited[current]) {
			list.add(current);
			visited[current] = true;
			current = students[current];
		}
		if(isCycle[current] == 0) {
			checkCycle(current);
		}
		for(int i : list) {
			if(isCycle[i] == 0) {
				isCycle[i] = -1;
			} else {
				break;
			}
		}
	}
	public static void checkCycle(int num) {
		while(true) {
			if(isCycle[num] == 0) {
				isCycle[num] = 1;
				answer--;
				num = students[num];
			} else {
				return;
			}
		}
	}
}

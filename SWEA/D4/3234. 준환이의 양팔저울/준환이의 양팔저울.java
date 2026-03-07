import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> list;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			visited = new boolean[N];
			list = new ArrayList<>();
			P();
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void P() {
		if(list.size() == N) {
			putOn(0, 0, 0);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				list.add(arr[i]);
				visited[i] = true;
				P();
				visited[i] = false;
				list.remove(list.size()-1);
			}
		}
	}
	public static void putOn(int index, int left, int right) {
		if(left < right) {
			return;
		}
		if(index == N) {
			answer++;
			return;
		}
		putOn(index+1, left + list.get(index), right);
		putOn(index+1, left, right + list.get(index));
	}
}

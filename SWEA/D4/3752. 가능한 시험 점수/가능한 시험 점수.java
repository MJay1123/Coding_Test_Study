import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] scores;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			scores = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			Set<Integer>[] sets = new Set[N];
			for(int i=0; i<N; i++) {
				sets[i] = new HashSet<>();
			}
			sets[0].add(0);
			sets[0].add(scores[0]);
			for(int i=1; i<N; i++) {
				for(int prevScore : sets[i-1]) {
					sets[i].add(prevScore);
					sets[i].add(prevScore + scores[i]);
				}
			}
			int answer = sets[N-1].size();
			sb.append(String.format("#%d %d\n", testCase, answer));
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

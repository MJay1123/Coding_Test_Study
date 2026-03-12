import java.util.*;
import java.io.*;

public class Solution {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			/*
			 * N : 8 ~ 28
			 * 16진수 숫자 범위 : 7자리 -> 16의 7승 -> 2의 28승
			 * 숫자의 개수 : 28개
			 * */
			K = Integer.parseInt(st.nextToken());
			String line = br.readLine();
			line = line + line;
			List<Long> list = new ArrayList<>();
			int len = N / 4;
			for(int i=0; i<N; i++) {
				long num = Long.parseLong(line.substring(i, i + len), 16);
				if(!list.contains(num)) {
					list.add(num);
				}
			}
			Collections.sort(list);
			long answer = list.get(list.size()-K);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

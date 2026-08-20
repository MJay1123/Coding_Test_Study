import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static int[] trees;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			trees = new int[N];
			st = new StringTokenizer(br.readLine());
			int low = 0;
			int high = 0;
			int answer = 0;
			for(int i=0; i<N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				high = Math.max(high, trees[i]);
			}
			while(low < high) {
				int middle = (low + high) / 2;
				long sum = 0;
				for(int i=0; i<N; i++) {
					sum += (trees[i] > middle) ? trees[i] - middle : 0;
				}
				if(sum >= M) {
					answer = Math.max(answer, middle);
					low = middle + 1;
				} else {
					high = middle;
				}
			}			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}

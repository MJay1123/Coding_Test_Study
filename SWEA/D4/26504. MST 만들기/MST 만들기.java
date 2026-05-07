import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			M = N * (N-1) / 2;
			arr = new int[M];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			long min = 0;
			long max = 0;
			for(int i=0; i<N-1; i++) {
				min += arr[i];
			}
			if(N == 2) {
				max = arr[0];
			} else {
				max += arr[0];
				max += arr[1];
				int count = 2;
				int index = 3;
				while(count < N-1) {
					max += arr[index];
					index++;
					for(int i=0; i<count; i++) {
						index++;
					}
					count++;
				}
			}
			sb.append(min).append(" ").append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
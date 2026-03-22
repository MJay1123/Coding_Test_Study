import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long[] liquids;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		liquids = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			liquids[i] = Long.parseLong(st.nextToken());
		}
		int leftIndex = 0;
		int rightIndex = N-1;
		long min = Long.MAX_VALUE;
		long left = 0L;
		long right = 0L;
		while(leftIndex < rightIndex) {
			long sum = liquids[leftIndex] + liquids[rightIndex];
			if(Math.abs(min) >= Math.abs(sum)) {
				min = sum;
				left = liquids[leftIndex];
				right = liquids[rightIndex];
			}
			if(sum > 0) {
				rightIndex--;
			} else if(sum < 0) {
				leftIndex++;
			} else {
				break;
			}
		}
		bw.write(left + " " + right + "\n");
		bw.flush();
	}
}
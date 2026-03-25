import java.util.*;
import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		long[] liquids = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			liquids[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(liquids);
		long min = Long.MAX_VALUE;
		long[] result = new long[3];
		boolean flag = false;
		for(int i=0; i<N-2; i++) {
			if(flag) {
				break;
			}
			int leftIndex = i + 1;
			int rightIndex = N - 1;
			while(leftIndex < rightIndex) {
				long sum = liquids[i] + liquids[leftIndex] + liquids[rightIndex];
				if(Math.abs(min) > Math.abs(sum)) {
					min = sum;
					result[0] = liquids[i];
					result[1] = liquids[leftIndex];
					result[2] = liquids[rightIndex];
				}
				if(sum > 0) {
					rightIndex--;
				} else if(sum < 0) {
					leftIndex++;
				} else {
					flag = true;
					break;
				}
			}
		}
		Arrays.sort(result);
		for(int i=0; i<3; i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
	}

}

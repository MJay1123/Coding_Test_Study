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
		int[] result = {0, N-1};
		int left = 0;
		int right = N-1;
		long sum = liquids[left] + liquids[right];
		long min = Math.abs(sum);
		while(left < right) {
//			System.out.println("left : " + left + ", right : " + right);
			if(sum > 0) {
				right--;
			} else if(sum < 0) {
				left++;
			} else {
				break;
			}
			if(left == right) {
				break;
			}
			sum = liquids[left] + liquids[right];
			if(min >= Math.abs(sum)) {
				min = Math.abs(sum);
				result[0] = left;
				result[1] = right;
			}
		}
		bw.write(liquids[result[0]] + " " + liquids[result[1]] + "\n");
		bw.flush();
	}

}

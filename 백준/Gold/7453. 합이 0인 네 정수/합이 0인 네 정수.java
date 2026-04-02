import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		long[] AB = new long[n * n];
		long[] CD = new long[n * n];
		int index = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				AB[index] = A[i] + B[j];
				CD[index] = C[i] + D[j];
				index++;
			}
		}
		Arrays.sort(AB);
		Arrays.sort(CD);
		long answer = 0;
		int left = 0;
		int right = n * n - 1;
		while(true) {
			if(left >= n * n || right < 0) {
				break;
			}
			long sum = AB[left] + CD[right];
			if(sum > 0) {
				long r = CD[right];
				while(right >= 0 && CD[right] == r) {
					right--;
				}
			} else if(sum < 0) {
				long l = AB[left];
				while(left < n * n && AB[left] == l) {
					left++;
				}
			} else {
				long c1 = 0;
				long l = AB[left];
				while(left < n * n && AB[left] == l) {
					left++;
					c1++;
				}
				long c2 = 0;
				long r = CD[right];
				while(right >= 0 && CD[right] == r) {
					right--;
					c2++;
				}
				answer += c1 * c2;
			}
		}
		bw.write(answer + "\n");
		bw.flush();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		int[] arr = new int[N+1];
		int answer = 0;
		for(int i=0; i<N; i++) {
			if(i > 0) {
				arr[i] = Math.max(arr[i], arr[i-1]);
			}
			if(i + T[i] <= N) {
				arr[i+T[i]] = Math.max(arr[i+T[i]], arr[i] + P[i]);
				answer = Math.max(answer, arr[i+T[i]]);
			}
		}
		bw.write(answer + "\n");
		bw.flush();
	}
}

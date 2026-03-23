import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] numbers;
	static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		memo = new int[N*2 + 1];
		for(int i=1; i<=N; i++) {
			for(int d=0; i-d>=1 && i+d<=N; d++) {
				if(numbers[i-d] == numbers[i+d]) {
					memo[i+i] = d+d;
				} else {
					break;
				}
			}
		}
		for(int i=1; i<=N; i++) {
			int leftIndex = i;
			int rightIndex = i+1;
			while(leftIndex >= 1 && rightIndex <= N) {
				if(numbers[leftIndex] == numbers[rightIndex]) {
					memo[leftIndex+rightIndex] = rightIndex - leftIndex;
					leftIndex--;
					rightIndex++;
				} else {
					break;
				}
			}
		}
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			if(isPalendrome(S, E)) {
				bw.write(1 + "\n");
			} else {
				bw.write(0 + "\n");
			}
		}
		bw.flush();
	}
	public static boolean isPalendrome(int S, int E) {
		if((E-S) <= memo[S+E]) {
			return true;
		} else {
			return false;
		}
	}
}

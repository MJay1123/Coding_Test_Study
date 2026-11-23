import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		P = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int minimum = 0;
		for(int i=0; i<N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
			if(P[minimum] > P[i]) {
				minimum = i;
			}
		}
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int first = 0;
		for(int i=1; i<N; i++) {
			if(first == 0) {
				if(P[i] <= M) {
					first = i;
				}
			} else {
				if(P[i] <= M && P[first] > P[i]) {
					first = i;
				}
			}
		}
		if(first == 0) {
			sb.append(0);
		} else {
			int price = 0;
			int l = (M - P[first]) / P[minimum] + 1;			
			int[] number = new int[l];
			number[0] = first;
			for(int i=1; i<l; i++) {
				number[i] = minimum;
			}
			price += P[first] + P[minimum] * (l-1);			
			for(int i=0; i<l; i++) {
				for(int next=0; next<N; next++) {
					int current = number[i];
					if(price - P[current] + P[next] <= M) {
						price -= P[current];
						price += P[next];
						number[i] = next;
					}
				}
			}
			for(int i=0; i<l; i++) {
				sb.append(number[i]);
			}
		}
		sb.append("\n");
		bw.write(sb.toString());
		bw.flush();
	}
}

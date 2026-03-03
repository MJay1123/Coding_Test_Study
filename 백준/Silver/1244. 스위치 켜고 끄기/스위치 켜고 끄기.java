
import java.util.*;
import java.io.*;

public class Main {	
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int[] LED = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			LED[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			changeLED(gender, num, LED);
		}
        for(int i=1; i<=N; i++) {
        	sb.append(LED[i]).append(" ");
            if (i % 20 == 0) {
            	sb.append("\n");
            }
        }
		System.out.print(sb);
	}
	public static void changeLED(int gender, int num, int[] LED) {
		if(gender == 1) {	// 남자
			for(int i=1; i<=N; i++) {
				if(i % num == 0) {
					LED[i] = 1 - LED[i];
				}
			}
		} else {			// 여자
			LED[num] = 1 - LED[num];
			for(int d=1; (num - d >= 1 && num + d <= N); d++) {
				if(LED[num-d] == LED[num+d]) {
					LED[num-d] = 1 - LED[num-d];
					LED[num+d] = 1 - LED[num+d];
				} else {
					break;
				}
			}
		}
	}
}

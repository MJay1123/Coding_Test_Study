import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			int speed = 0;
			int distance = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if(command == 1) {
					int change = Integer.parseInt(st.nextToken());
					speed += change;
				} else if(command == 2) {
					int change = Integer.parseInt(st.nextToken());
					speed = (speed < change) ? 0 : speed - change;
				}
				distance += speed;
			}
			sb.append("#").append(testCase).append(" ").append(distance).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

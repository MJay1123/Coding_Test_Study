import java.util.*;
import java.io.*;

class Solution {
    static int D, L, N;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)	{
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
			int answer = 0;
            for(int n=0; n<N; n++){
                answer += D * (100 + n * L) / 100;
            }
            sb.append(String.format("#%d %d\n", test_case, answer));
		}
		bw.write(sb.toString());
        bw.flush();
	}
}
import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<String> leftCards = new LinkedList<>();
			Queue<String> rightCards = new LinkedList<>();
			for(int i=0; i<(N-1)/2+1; i++) {
				leftCards.offer(st.nextToken());
			}
			for(int i=(N-1)/2+1; i<N; i++) {
				rightCards.offer(st.nextToken());
			}
			while(!rightCards.isEmpty()) {
				sb.append(leftCards.poll()).append(" ");
				sb.append(rightCards.poll()).append(" ");
			}
			if(!leftCards.isEmpty()) {
				sb.append(leftCards.poll());
			}
            sb.append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}
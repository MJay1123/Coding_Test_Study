import java.util.*;
import java.io.*;

class Solution {
	static int[] answer = new int[2];
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arrA = new int[9];
			boolean[] visited = new boolean[19];
			for(int i=0; i<9; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
				visited[arrA[i]] = true;
			}
			int[] arrB = new int[9];
			answer = new int[2];
			P(0, visited, arrA, arrB);
            sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static void P(int index, boolean[] visited, int[] arrA, int[] arrB) {
		if(index == 9) {
			int reA = 0;
			int reB = 0;
			for(int i=0; i<9; i++) {
				if(arrA[i] < arrB[i]) {
					reB += arrA[i] + arrB[i];
				} else {
					 reA += arrA[i] + arrB[i];
				}
			}
			if(reA > reB) {
				answer[0]++;
			} else {
				answer[1]++;
			}
			return;
		}
		for(int i=1; i<=18; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arrB[index] = i;
				P(index+1, visited, arrA, arrB);
				visited[i] = false;
			}
		}
	}
}
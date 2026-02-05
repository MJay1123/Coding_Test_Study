import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());	// 항상 100
			int[][] map = new int[100][100];
			for(int r=0; r<100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            for(int c=0; c<100; c++) {
            	stack.clear();
            	for(int r=0; r<100; r++) {
            		if(map[r][c] == 1) {
            			stack.push(map[r][c]);
            		}
            		if(map[r][c] == 2) {
            			if(!stack.isEmpty()) {
            				stack.clear();
            				answer++;
            			}
            		}
            	}
            }
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}
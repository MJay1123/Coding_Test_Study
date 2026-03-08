import java.util.*;
import java.io.*;

public class Solution {
	static int K;
	static int[][] magnets;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			K = Integer.parseInt(br.readLine());
			magnets = new int[5][8];
			for(int i=1; i<=4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					magnets[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int magnetNum = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				visited = new boolean[5];
				rotate(magnetNum, direction);
			}
			int answer = 0;
			for(int i=1; i<=4; i++) {
				answer += magnets[i][0] * Math.pow(2, i-1);
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void rotate(int num, int direction) {
		visited[num] = true;
		if(num + 1 <= 4 && magnets[num][2] != magnets[num+1][6] && !visited[num+1]) {
			rotate(num+1, -direction);
		}
		if(num - 1 >= 1 && magnets[num][6] != magnets[num-1][2] && !visited[num-1]) {
			rotate(num-1, -direction);
		}
		if(direction == 1) {
			int temp = magnets[num][7];
			for(int i=7; i>=1; i--) {
				magnets[num][i] = magnets[num][i-1];
			}
			magnets[num][0] = temp;
		} else {
			int temp = magnets[num][0];
			for(int i=0; i<7; i++) {
				magnets[num][i] = magnets[num][i+1];
			}
			magnets[num][7] = temp;
		}
	}
}

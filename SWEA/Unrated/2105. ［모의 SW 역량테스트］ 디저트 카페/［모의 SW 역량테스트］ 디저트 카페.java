import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] map;
	static int[][] around = {{1,1},{1,-1},{-1,-1},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
		 	int answer = -1;
		 	int t = checkCircle(1, 1, 0, 1);
		 	for(int r=0; r<N; r++) {
		 		for(int c=0; c<N; c++) {
		 			answer = Math.max(answer,  check(r, c));
		 		}
		 	}
		 	sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	public static int check(int startR, int startC) {
		int result = -1;
		for(int w=1; w<N; w++) {
			for(int h=1; h<N; h++) {
				int temp = checkCircle(w, h, startR, startC);
				result = Math.max(result,  temp);
			}
		}
		return result;
	}
	public static int checkCircle(int w, int h, int startR, int startC) {
		boolean[] desserts = new boolean[101];
		int count = 0;
		int r = startR;
		int c = startC;
		int dessert = 0;
		for(int i=0; i<w; i++) {
			r += around[0][0];
			c += around[0][1];
			if(!checkRange(r, c)) {
				return -1;
			}
			dessert = map[r][c];
			if(desserts[dessert]) {
				return -1;
			}
			desserts[dessert] = true;
			count++;
		}
		for(int i=0; i<h; i++) {
			r += around[1][0];
			c += around[1][1];
			if(!checkRange(r, c)) {
				return -1;
			}
			dessert = map[r][c];
			if(desserts[dessert]) {
				return -1;
			}
			desserts[dessert] = true;
			count++;
		}
		for(int i=0; i<w; i++) {
			r += around[2][0];
			c += around[2][1];
			if(!checkRange(r, c)) {
				return -1;
			}
			dessert = map[r][c];
			if(desserts[dessert]) {
				return -1;
			}
			desserts[dessert] = true;
			count++;
		}
		for(int i=0; i<h; i++) {
			r += around[3][0];
			c += around[3][1];
			if(!checkRange(r, c)) {
				return -1;
			}
			dessert = map[r][c];
			if(desserts[dessert]) {
				return -1;
			}
			desserts[dessert] = true;
			count++;
		}
		return count;
	}
}
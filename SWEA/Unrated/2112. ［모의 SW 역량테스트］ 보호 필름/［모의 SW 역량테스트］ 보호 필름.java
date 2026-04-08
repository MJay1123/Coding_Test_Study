import java.util.*;
import java.io.*;

public class Solution {
	static int D, W, K;
	static int[] cells;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cells = new int[D];
			for(int r=0; r<D; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<W; c++) {
					int num = Integer.parseInt(st.nextToken());
					cells[r] = cells[r] | (num << c);
				}
			}
			answer = 100000;
			combination(0, 0);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void combination(int r, int count) {
		if(count > K) {
			return;
		}
		if(r == D) {
			if(check()) {
				answer = Math.min(answer, count);
			}
			return;
		}
		int bitO = cells[r];
		int bitA = 0;
		int bitB = (1 << W) - 1;
		combination(r+1, count);
		cells[r] = bitA;
		combination(r+1, count+1);
		cells[r] = bitB;
		combination(r+1, count+1);
		cells[r] = bitO;
	}
	public static boolean check() {
		for(int c=0; c<W; c++) {
			int max = 1;
			int count = 1;
			for(int r=1; r<D; r++) {
				if((cells[r] & (1 << c)) == (cells[r-1] & (1 << c))) {
					count++;
				} else {
					count = 1;
				}
				max = Math.max(max, count);
			}
			if(max < K) {
				return false;
			}
		}
		return true;
	}
}

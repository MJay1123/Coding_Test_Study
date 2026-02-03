import java.io.*;
import java.util.*;

public class Solution {
	static int[][] move = {{1, 0}, {0,1}, {-1,0}, {0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			int[][] arr = new int[4][4];
			for (int r = 0; r < 4; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 4; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			HashSet<String> hs = new HashSet<>();
			for(int r=0; r<4; r++) {
				for(int c=0; c<4; c++) {
					List<Integer> list = new ArrayList<>();
					DFS(r, c, arr, list, hs);
				}
			}
			int answer = hs.size();
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static void DFS(int r, int c, int[][] arr, List<Integer> list, HashSet<String> hs) {
		if(list.size() == 7) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<7; i++) {
				sb.append(list.get(i));
			}
			hs.add(sb.toString());
			return;
		}
		list.add(arr[r][c]);
		for(int m=0; m<4; m++) {
			int nr = r + move[m][0];
			int nc = c + move[m][1];
			if(checkRange(nr, nc)) {
				DFS(nr, nc, arr, list, hs);
			}
		}
		list.remove(list.size()-1);
	}

	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}
}
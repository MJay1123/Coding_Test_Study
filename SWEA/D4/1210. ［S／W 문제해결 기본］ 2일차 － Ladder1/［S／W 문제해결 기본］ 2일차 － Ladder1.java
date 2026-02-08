import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= 10; testCase++) {
			br.readLine();
			sb.append("#").append(testCase).append(" ");
			int[][] ladders = new int[100][100];
			List<Integer> lineList = new ArrayList<>();
			int endC = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 100; c++) {
				ladders[0][c] = Integer.parseInt(st.nextToken());
				if (ladders[0][c] == 1) {
					lineList.add(c);
				}
			}
			for (int r = 1; r < 99; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					ladders[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 100; c++) {
				ladders[99][c] = Integer.parseInt(st.nextToken());
				if (ladders[99][c] == 2) {
					endC = c;
				}
			}
			int lineIndex = 0;
			for(int i=0; i<lineList.size(); i++) {
				if(lineList.get(i) == endC) {
					lineIndex = i;
				}
			}
			int answer = goUp(99, endC, ladders, lineIndex, lineList);
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < 100 && c >= 0 && c < 100;
	}

	public static int goUp(int r, int c, int[][] ladders, int lineIndex, List<Integer> lineList) {
		while (true) {
			if (r == 0) {
				return c;
			}
			if (checkRange(r, c - 1) && ladders[r][c - 1] == 1) {
				lineIndex--;
				c = lineList.get(lineIndex);
			} else if (checkRange(r, c + 1) && ladders[r][c + 1] == 1) {
				lineIndex++;
				c = lineList.get(lineIndex);
			}
			r--;
		}
	}
}

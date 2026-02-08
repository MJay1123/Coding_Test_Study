import java.util.*;
import java.io.*;

class Solution {
	static int start = 0;
	static int distance = 0;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			sb.append("#").append(test_case).append(" ");
			int[][] ladders = new int[100][100];
			List<Integer> startList = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<100; c++) {
				ladders[0][c] = Integer.parseInt(st.nextToken());
				if(ladders[0][c] == 1) {
					startList.add(c);
				}
			}
			for(int r=1; r<100; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<100; c++) {
					ladders[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			distance = 10000;
			start = -1;
			for(int i=0; i<startList.size(); i++) {
				int r = 0;
				int c = startList.get(i);
				int dist = goDown(r, c, ladders, i, startList);
				if(distance >= dist) {
					distance = dist;
					start = c;
				}
			}
            sb.append(start).append("\n");
           
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static boolean checkRange(int r, int c) {
		return r >= 0 && r < 100 && c >= 0 && c < 100;
	}
	public static int goDown(int r, int c, int[][] ladders, int lineIndex, List<Integer> startList) {
		int dist = 0;
		while(true) {
			if(r == 99) {
				return dist;
			}
			if(checkRange(r, c+1) && ladders[r][c+1] == 1) {
				dist += startList.get(lineIndex+1) - startList.get(lineIndex);
				lineIndex++;
				c = startList.get(lineIndex);
			} else if(checkRange(r, c-1) && ladders[r][c-1] == 1) {
				dist += startList.get(lineIndex) - startList.get(lineIndex-1);
				lineIndex--;
				c = startList.get(lineIndex);
			}
			r++;
			dist++;
		}
	}
}
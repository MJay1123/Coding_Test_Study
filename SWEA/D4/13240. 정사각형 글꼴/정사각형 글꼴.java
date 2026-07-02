import java.util.*;
import java.io.*;

public class Solution {
	static int H, W, N;
	static String[] words;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			words = new String[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				words[i] = st.nextToken();
			}
			int answer = 0;
			for(int tileLength=Math.min(H, W); tileLength>=1; tileLength--) {
				if(check(tileLength)) {
					answer = tileLength;
					break;
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static boolean check(int tileLength) {
		boolean possible = true;
		int hCount = H / tileLength;
		int wCount = W / tileLength;
		int row = 0;
		int column = 0;
		for(int i=0; i<N; i++) {
			String word = words[i];
			while(row < hCount && column + word.length() > wCount) {
				row++;
				column = 0;
			}
			if(row >= hCount) {
				possible = false;
				break;
			}
			column += word.length() + 1;
		}
		return possible;
	}
}
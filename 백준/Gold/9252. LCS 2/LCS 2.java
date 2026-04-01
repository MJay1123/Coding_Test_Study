import java.util.*;
import java.io.*;

public class Main {
	static int l1, l2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str1 = br.readLine();	// ACAYKP
		String str2 = br.readLine();	// CAPCAK
		l1 = str1.length();
		l2 = str2.length();
		int[][] dp = new int[l1+1][l2+1];
		for(int r=1; r<=l1; r++) {
			for(int c=1; c<=l2; c++) {
				if(str1.charAt(r-1) == str2.charAt(c-1)) {
					dp[r][c] = dp[r-1][c-1] + 1;
				} else {
					if(dp[r-1][c] > dp[r][c-1]) {
						dp[r][c] = dp[r-1][c];
					} else {
						dp[r][c] = dp[r][c-1];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int row = l1;
		int column = l2;
		while(true) {
			if(row == 0 || column == 0) {
				break;
			}
			if(str1.charAt(row-1) == str2.charAt(column-1)) {
				sb.append(str1.charAt(row-1));
				row--;
				column--;
			} else {
				if(dp[row-1][column] > dp[row][column-1]) {
					row = row - 1;
				} else {
					column = column - 1;
				}
			}
		}
		sb.reverse();
		bw.write(dp[l1][l2] + "\n");
		bw.write(sb.toString() + "\n");
		bw.flush();
	}
}

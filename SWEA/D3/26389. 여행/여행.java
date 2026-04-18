import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		boolean[] possible = new boolean[16];
		possible[15] = true;
		possible[12] = true;
		possible[3] = true;
		for(int testCase=1; testCase<=TC; testCase++) {
			String plan = br.readLine();
			int bit = 0;
			for(int i=0; i<plan.length(); i++) {
				if(bit == 15) {
					break;
				}
				char ch = plan.charAt(i);
				switch(ch) {
				case 'N':
					bit = (bit | (1 << 3));
					break;
				case 'S':
					bit = (bit | (1 << 2));
					break;
				case 'E':
					bit = (bit | (1 << 1));
					break;
				case 'W':
					bit = (bit | (1 << 0));
					break;
				}
			}
			if(possible[bit]) {
				sb.append("Yes\n");
			} else {
				sb.append("No\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

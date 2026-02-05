import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#").append(test_case).append(" ");
			br.readLine();
			String target = br.readLine();
			String str = br.readLine();
			boolean atEnd = true;
			for(int i=0; i<target.length(); i++) {
				if(target.charAt(i) != str.charAt(str.length()-target.length()+i)) {
					atEnd = false;
					break;
				}
			}
			int answer = str.split(target).length - 1;
			if(atEnd) {
				answer++;
			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

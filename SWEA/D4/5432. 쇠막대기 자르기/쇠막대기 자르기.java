import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			int answer = 0;
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(ch == '(') {
					stack.push(ch);
				} else {
					if(str.charAt(i-1) == '(') {
						stack.pop();
						answer += stack.size();
					} else {
						stack.pop();
						answer += 1;
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

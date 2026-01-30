import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<N; i++) {
				char ch = str.charAt(i);
				if(stack.isEmpty()) {
					stack.push(ch);
				} else {
					if(stack.peek() == '(' && ch == ')'){
						stack.pop();
					} else if(stack.peek() == '{' && ch == '}') {
						stack.pop();
					} else if(stack.peek() == '[' && ch == ']') {
						stack.pop();
					} else if(stack.peek() == '<' && ch == '>') {
						stack.pop();
					} else {
						stack.push(ch);
					}
				}
			}
            int answer = (stack.isEmpty()) ? 1 : 0;
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}

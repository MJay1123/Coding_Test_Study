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
			String changedString = change(str);
            int answer = calculate(changedString);
            sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static int calculate(String str) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				stack.push(str.charAt(i) - '0');
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				if(str.charAt(i) == '+') {
					stack.push(num1 + num2);
				} else if(str.charAt(i) == '*') {
					stack.push(num1 * num2);
				}
			}
		}
		return stack.peek();
	}
	public static String change(String str) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		sb.append(str.charAt(0));
		stack.push(str.charAt(1));
		for(int i=2; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= '0' && ch <= '9') {
				sb.append(ch);
				if(stack.peek() == '*') {
					sb.append(stack.pop());
				}
			} else {
				if(ch == '+') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					stack.push(ch);
				} else if(ch == '*') {
					stack.push(ch);
				}
			}
		}
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
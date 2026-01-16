import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<N; i++){
                if(stack.isEmpty()){
                    stack.push(str.charAt(i));
                } else {
                    if(str.charAt(i) == 'x' && !stack.isEmpty() && stack.peek() == 'o'){
                        stack.pop();
                        if(stack.peek() == 'f'){
                            stack.pop();
                        } else {
                            stack.push('o');
                            stack.push('x');
                        }
                    } else {
                        stack.push(str.charAt(i));
                    }
                }
            }
            int answer = stack.size();
            bw.write(answer + "\n");
		}
        bw.flush();
	}
}
import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#").append(test_case).append(" ");
			br.readLine();
			String target = br.readLine();
			String str = br.readLine();
			int answer = 0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == target.charAt(0) && exists(str, target, i)) {
					answer++;
				}
			}
            sb.append(answer).append("\n");           
		}
		bw.write(sb.toString());
        bw.flush();
	}

	public static boolean exists(String str, String target, int index) {
		for (int i = 0; i < target.length(); i++) {
			if (index + i >= str.length()) {
				return false;
			}
			if (target.charAt(i) != str.charAt(index + i)) {
				return false;
			}
		}
		return true;
	}
}

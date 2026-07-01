import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int answer = 0;
            for(int i=0; i<N; i+=2){
                answer += (str.charAt(i) - '0');
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
}
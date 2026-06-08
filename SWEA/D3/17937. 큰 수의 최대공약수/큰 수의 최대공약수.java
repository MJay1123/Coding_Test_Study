import java.util.*;
import java.io.*;
class Solution {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            sb.append("#").append(test_case).append(" ");
            if(A.equals(B)){
                sb.append(A).append("\n");
            } else {
                sb.append(1).append("\n");
            }
		}
        bw.write(sb.toString());
        bw.flush();
	}
}
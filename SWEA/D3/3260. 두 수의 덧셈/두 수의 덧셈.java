import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			int[][] arr = new int[3][Math.max(A.length(), B.length()) + 1];
			for(int i=0; i<A.length(); i++) {
				arr[0][i] = A.charAt(A.length()-1-i) - '0';
			}
			for(int i=0; i<B.length(); i++) {
				arr[1][i] = B.charAt(B.length()-1-i) - '0';
			}
			for(int i=0; i<arr[2].length-1; i++) {
				arr[2][i] += arr[0][i] + arr[1][i];
				if(arr[2][i] >= 10) {
					arr[2][i] -= 10;
					arr[2][i+1]++;
				}
			}
			int startIndex = 0;
            for(int i=arr[2].length-1; i>=0; i--) {
            	if(arr[2][i] > 0) {
            		startIndex = i;
            		break;
            	}
            }
            for(int i=startIndex; i>=0; i--) {
            	sb.append(arr[2][i]);
            }
            sb.append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
}
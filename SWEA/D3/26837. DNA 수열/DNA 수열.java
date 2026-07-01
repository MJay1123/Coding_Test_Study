import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static String S;
	static int[][] arr;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = st.nextToken();
			answer = 0;
			arr = new int[N+1][4];
			for(int i=1; i<=N; i++) {
				count(i);
			}
			for(int i=0; i<=N; i++) {
				for(int j=i+2; j<=N; j++) {
					if(arr[j][0] - arr[i][0] == arr[j][1] - arr[i][1] && arr[j][2] - arr[i][2] == arr[j][3] - arr[i][3]) {
						answer++;
					}
				}
			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void count(int index) {
		char ch = S.charAt(index-1);
		if(ch == 'A') {
			arr[index][0] = arr[index-1][0] + 1;
			arr[index][1] = arr[index-1][1];
			arr[index][2] = arr[index-1][2];
			arr[index][3] = arr[index-1][3];
		} else if(ch == 'T') {
			arr[index][0] = arr[index-1][0];
			arr[index][1] = arr[index-1][1] + 1;
			arr[index][2] = arr[index-1][2];
			arr[index][3] = arr[index-1][3];
		} else if(ch == 'C') {
			arr[index][0] = arr[index-1][0];
			arr[index][1] = arr[index-1][1];
			arr[index][2] = arr[index-1][2] + 1;
			arr[index][3] = arr[index-1][3];
		} else if(ch == 'G') {
			arr[index][0] = arr[index-1][0];
			arr[index][1] = arr[index-1][1];
			arr[index][2] = arr[index-1][2];
			arr[index][3] = arr[index-1][3] + 1;		
		}
	}
}

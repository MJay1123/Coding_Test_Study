import java.util.*;
import java.io.*;

public class Solution {
	static int X, Y, Z;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			Z = Integer.parseInt(st.nextToken());
			int[][] arr = new int[2][3];
			String[] result = new String[3];
			arr[0][0] = X;
			arr[0][1] = Y;
			arr[0][2] = Z;
			getSequence(arr);
			int max = 0;
			StringBuilder sb2 = new StringBuilder();
			for(int i=0; i<3; i++) {
				if(arr[1][i] == 0) {
					int num = arr[0][i];
					max = num;
					for(int j=0; j<num; j++) {
						sb2.append(1);
					}
					result[i] = sb2.toString();
					break;
				}
			}
			
			for(int i=0; i<3; i++) {
				if(arr[1][i] == 1) {
					int num = arr[0][i];
					for(int j=0; j<num; j++) {
						sb2.append(0);
					}
					result[i] = sb2.toString();
					break;
				}
			}
			
			for(int i=0; i<3; i++) {
				if(arr[1][i] == 2) {
					 int num = arr[0][i];
					 for(int j=0; j<num; j++) {
						 sb2.append(1);
					 }
					 result[i] = sb2.toString().substring(max);
				}
			}
			for(int i=0; i<3; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void getSequence(int[][] arr) {
		if(arr[0][0] >= arr[0][1]) {
			if(arr[0][0] >= arr[0][2]) {
				if(arr[0][1] >= arr[0][2]) {
					arr[1][0] = 0;
					arr[1][1] = 1;
					arr[1][2] = 2;
				} else {
					arr[1][0] = 0;
					arr[1][2] = 1;
					arr[1][1] = 2;
				}
			} else {
				arr[1][2] = 0;
				arr[1][0] = 1;
				arr[1][1] = 2;
			}
		} else {
			if(arr[0][0] >= arr[0][2]) {
				arr[1][1] = 0;
				arr[1][0] = 1;
				arr[1][2] = 2;
			} else {
				if(arr[0][1] >= arr[0][2]) {
					arr[1][1] = 0;
					arr[1][2] = 1;
					arr[1][0] = 2;
				} else {
					arr[1][2] = 0;
					arr[1][1] = 1;
					arr[1][0] = 2;
				}
			}
		}
	}
}

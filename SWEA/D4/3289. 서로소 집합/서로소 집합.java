import java.io.*;
import java.util.*;

public class Solution {
	static int n, m;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int calc = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(calc == 0) {
					if(getRoot(a) != getRoot(b)) {
						arr[getRoot(b)] = a;
					}
				} else {
					if(getRoot(a) == getRoot(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int getRoot(int num) {
		List<Integer> list = new ArrayList<>();
		while(true) {
			if(arr[num] == 0) {
				break;
			}
			list.add(num);
			num = arr[num];
		}
		for(int n : list) {
			arr[n] = num;
		}
		return num;
	}
}

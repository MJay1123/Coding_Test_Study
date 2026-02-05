import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 2];
			int[] index = new int[N + 2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				index[arr[i]] = i;
			}
			arr[N + 1] = N + 1;
			index[N + 1] = N + 1;
			List<Integer> list = new ArrayList<>();
			while (!finished(arr, index)) {
				for (int i = N; i >= 1; i--) {
					if (index[i] != i) {
						list.add(index[i]);
						change(i, N + 1, arr, index);
						break;
					}
				}
				while (true) {
					list.add(index[index[N + 1]]);
					change(N + 1, index[N + 1], arr, index);
					if (index[N + 1] == N + 1) {
						break;
					}
				}
			}
			sb.append(list.size()).append("\n");
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static void change(int num1, int num2, int[] arr, int[] index) {
		int index1 = index[num1];
		int index2 = index[num2];

		int temp = arr[index2];
		arr[index2] = arr[index1];
		arr[index1] = temp;

		temp = index[num2];
		index[num2] = index[num1];
		index[num1] = temp;
	}

	public static boolean finished(int[] arr, int[] index) {
		for (int i = arr.length - 1; i >= 1; i--) {
			if (index[i] != i) {
				return false;
			}
		}
		return true;
	}
}
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[N][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Long, Integer> hm = new HashMap<>();
		int start = 0;
		int end = 0;
		List<Integer> indexList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr[i][1] = Long.parseLong(st.nextToken());
			hm.put(arr[i][1], i);
		}
		for(int i=0; i<N; i++) {
			long num1 = arr[i][1] * 3;
			long num2 = arr[i][1] % 2 == 0 ? arr[i][1] / 2 : -1;
			if(hm.containsKey(num1)) {
				arr[i][0] = num1;
			} else if(hm.containsKey(num2)) {
				arr[i][0] = num2;
			} else {
				arr[i][0] = -1;
			}
			num1 = arr[i][1] * 2;
			num2 = arr[i][1] % 3 == 0 ? arr[i][1] / 3 : -1;
			if(hm.containsKey(num1)) {
				arr[i][2] = num1;
			} else if(hm.containsKey(num2)) {
				arr[i][2] = num2;
			} else {
				arr[i][2] = -1;
			}
			if(arr[i][0] == -1) {
				start = i;
			}
			if(arr[i][2] == -1) {
				end = i;
			}
		}
		int index = start;
		while(true) {
			sb.append(arr[index][1]).append(" ");
			if(index == end) {
				break;
			}
			index = hm.get(arr[index][2]);
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

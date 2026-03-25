import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		for(int i=1; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int num = arr[i];
			if(num > list.get(list.size()-1)) {
				list.add(num);
			} else {
				int replacedIndex = findIndex(list, num);
				list.set(replacedIndex, num);
			}
		}
		int answer = list.size();
		bw.write(answer + "\n");
		bw.flush();
	}
	public static int findIndex(List<Integer> list, int num) {
		int left = 0;
		int right = list.size()-1;
		while(left < right) {
			int middle = (left + right) / 2;
			if(list.get(middle) < num) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		return left;
	}
}

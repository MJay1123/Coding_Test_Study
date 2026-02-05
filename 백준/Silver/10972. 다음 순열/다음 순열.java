import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int index = -1;
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				index = i;
				break;
			}
		}
		if (index >= 0) {
			change(arr, index);
			for(int i=0; i<N; i++) {
				sb.append(arr[i]).append(" ");
			}
		} else {
			sb.append(-1);
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static void change(int[] arr, int index) {
		int temp = arr[index];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		for(int i=index+1; i<arr.length; i++) {
			pq.offer(arr[i]);
		}
		while(!pq.isEmpty()) {
			int num = pq.poll();
			if(num < temp) {
				pq2.offer(num);
			} else if(num > temp) {
				arr[index] = num;
				pq.offer(temp);
				while(!pq2.isEmpty()) {
					pq.offer(pq2.poll());
				}
				break;
			}
		}
		for(int i=index+1; i<arr.length; i++) {
			arr[i] = pq.poll();
		}
	}
}
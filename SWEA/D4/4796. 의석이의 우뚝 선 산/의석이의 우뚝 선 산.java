import java.util.*;
import java.io.*;

class Solution {
	static int N;
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			int[] arr = new int[N];
			Queue<Integer> queue = new LinkedList<>();
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			int change = arr[0] < arr[1] ? 1 : -1;
			for (int i = 1; i < N-1; i++) {
				if (change > 0) {
					if (arr[i] < arr[i+1]) {
						change++;
					} else {
						queue.offer(change);
						change = -1;
					}
				} else if (change < 0) {
					if (arr[i] > arr[i+1]) {
						change--;
					} else {
						queue.offer(change);
						change = 1;
					}
				}
			}
			queue.offer(change);
			while(!queue.isEmpty() && queue.peek() < 0){
				queue.poll();
			}
			int answer = 0;
			while(queue.size() >= 2) {
				answer += queue.poll() * queue.poll() * (-1);
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

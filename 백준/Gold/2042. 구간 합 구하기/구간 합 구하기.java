import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static long[] numbers;
	static long[] segmentTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		numbers = new long[N+1];
		for(int i=1; i<=N; i++) {
			numbers[i] = Long.parseLong(br.readLine());
		}
		segmentTree = new long[N * 4];
		makeSegmentTree(1, 1, N);
		for(int i=0; i<(M+K); i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				change(b, c);
			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long sum = getSum(1, 1, N, b, c);
				bw.write(sum + "\n");
			}
		}
		bw.flush();
	}
	public static void makeSegmentTree(int index, int start, int end) {
		if(start == end) {
			segmentTree[index] = numbers[start];
		} else {
			makeSegmentTree(index*2, start, (start+end)/2);
			makeSegmentTree(index*2+1, (start+end)/2+1, end);
			segmentTree[index] = segmentTree[index*2] + segmentTree[index*2+1];
		}
	}
	public static void change(int index, long num) {
		int node = 1;
		int start = 1;
		int end = N;
		while(true) {
			if(start == index && end == index) {
				break;
			}
			if(index <= (start+end)/2) {
				node = node * 2;
				end = (start+end)/2;
			} else {
				node = node * 2 + 1;
				start = (start+end)/2 + 1;
			}
		}
		long difference = num - segmentTree[node];
		while(node != 0) {
			segmentTree[node] += difference;
			node /= 2;
		}
	}
	public static long getSum(int index, int start, int end, int left, int right) {
		if(right < start || left > end) {
			return 0;
		}
		if(left <= start && end <= right) {
			return segmentTree[index];
		}
		long leftSum = getSum(index*2, start, (start+end)/2, left, right);
		long rightSum = getSum(index*2+1, (start+end)/2+1, end, left, right);
		return leftSum + rightSum;
	}
}

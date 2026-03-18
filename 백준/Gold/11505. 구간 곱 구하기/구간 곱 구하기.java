import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static long[] numbers;
	static long[] segmentTree;
	static long aaa = 1000000007L;
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
		Arrays.fill(segmentTree, 1L);
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
				long value = getValue(1, 1, N, b, c);
				bw.write(value + "\n");
			}
		}
		bw.flush();
	}
	public static void change(int index, long after) {
		int current = 1;
		int left = 1;
		int right = N;
		while(true) {
			if(left == index && index == right) {
				break;
			}
			if(index <= (left+right)/2) {
				current = current * 2;
				right = (left+right)/2;
			} else {
				current = current * 2 + 1;
				left = (left+right)/2 + 1;
			}
		}
		segmentTree[current] = after;
		current /= 2;
		while(current > 0) {
			segmentTree[current] = segmentTree[current*2] * segmentTree[current*2 + 1] % aaa;
			current /= 2;
		}			
	}
	public static long getValue(int index, int start, int end, int left, int right) {
		if(right < start || end < left) {
			return 1L;
		}
		if(left <= start && end <= right) {
			return segmentTree[index];
		}
		long leftValue = getValue(index*2, start, (start+end)/2, left, right);
		long rightValue = getValue(index*2+1, (start+end)/2+1, end, left, right);
		return leftValue * rightValue % aaa;			
	}
	
	public static void makeSegmentTree(int index, int start, int end) {
		if(start == end) {
			segmentTree[index] = numbers[start];
		} else {
			makeSegmentTree(index*2, start, (start+end)/2);
			makeSegmentTree(index*2+1, (start+end)/2+1, end);
			segmentTree[index] = segmentTree[index*2] * segmentTree[index*2 + 1] % aaa;
		}
	}
}

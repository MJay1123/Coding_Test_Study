import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Stack<Integer> numStack = new Stack<>();
		Stack<Integer> indexStack = new Stack<>();
		find(A, B, numStack, indexStack);
		StringBuilder sb = new StringBuilder();
		sb.append(numStack.size()).append("\n");
		if (numStack.size() != 0) {
			for (int i = 0; i < numStack.size(); i++) {
				sb.append(numStack.get(i) + " ");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

	public static void find(int[] A, int[] B, Stack<Integer> numStack, Stack<Integer> indexStack) {
		for (int i = 0; i < A.length; i++) {
			Stack<Integer> tempNumStack = new Stack<>();
			Stack<Integer> tempIndexStack = new Stack<>();
			while (!numStack.isEmpty() && numStack.peek() < A[i]) {
				tempNumStack.push(numStack.pop());
				tempIndexStack.push(indexStack.pop());
			}
			int start = 0;
			if (!indexStack.isEmpty()) {
				start = indexStack.peek() + 1;
			}
			boolean inserted = false;
			for (int j = start; j < B.length; j++) {
				if (A[i] == B[j]) {
					numStack.push(B[j]);
					indexStack.push(j);
					inserted = true;
					break;
				}
			}
			if (!inserted) {
				while (!tempNumStack.isEmpty()) {
					numStack.push(tempNumStack.pop());
					indexStack.push(tempIndexStack.pop());
				}
			}
		}
	}
}

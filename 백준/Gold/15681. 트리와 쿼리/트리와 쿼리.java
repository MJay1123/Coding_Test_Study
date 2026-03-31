import java.util.*;
import java.io.*;

public class Main {
	static int N, R, Q;
	static List<Integer>[] connections;
	static int[] tree;
	static int[] subTreeSize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		connections = new List[N+1];
		for(int i=1; i<=N; i++) {
			connections[i] = new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			connections[U].add(V);
			connections[V].add(U);
		}
		tree = new int[N+1];
		tree[R] = R;
		subTreeSize = new int[N+1];
		makeTree(R);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<Q; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(getSubTreeSize(num)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int getSubTreeSize(int num) {
		if(subTreeSize[num] != 0) {
			return subTreeSize[num];
		}
		int sum = 1;
		for(int child : connections[num]) {
			if(child == tree[num]) {
				continue;
			}
			sum += getSubTreeSize(child);
		}
		subTreeSize[num] = sum;
		return sum;
	}
	public static void makeTree(int root) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(root);
		visited[root] = true;
		while(!queue.isEmpty()) {
			int parent = queue.poll();
			for(int child : connections[parent]) {
				if(child == tree[parent]) {
					continue;
				}
				tree[child] = parent;
				queue.offer(child);
			}
		}
	}
}

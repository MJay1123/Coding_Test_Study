import java.util.*;
import java.io.*;

class Solution {
	static int V, E;
	static int[] tree;
	static int[] depth;
	static List<Integer>[] connectedTo;
	static int[] subTreeSizes;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			tree = new int[V+1];
			depth = new int[V+1];
			connectedTo = new List[V+1];
			subTreeSizes = new int[V+1];
			for(int i=1; i<=V; i++) {
				connectedTo[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				tree[child] = parent;
				connectedTo[parent].add(child);
			}
			BFS();
			int commonParent = getCommonParent(num1, num2);
			int subTreeSize = getSubTreeSize(commonParent);
			sb.append("#").append(test_case).append(" ").append(commonParent).append(" ").append(subTreeSize).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> depthQueue = new LinkedList<>();
		queue.offer(1);
		depthQueue.offer(0);
		while(!queue.isEmpty()) {
			int num = queue.poll();
			int d = depthQueue.poll();
			depth[num] = d;
			for(int child : connectedTo[num]) {
				queue.offer(child);
				depthQueue.offer(d + 1);
			}
		}
	}
	public static int getCommonParent(int num1, int num2) {
		while(depth[num1] < depth[num2]) {
			num2 = tree[num2];
		}
		while(depth[num1] > depth[num2]) {
			num1 = tree[num1];
		}
		while(num1 != num2) {
			num1 = tree[num1];
			num2 = tree[num2];
		}
		return num1;
	}
	public static int getSubTreeSize(int parent) {
		if(subTreeSizes[parent] != 0) {
			return subTreeSizes[parent];
		}
		if(connectedTo[parent].size() == 0) {
			return 1;
		}
		int result = 1;
		for(int child : connectedTo[parent]) {
			result += getSubTreeSize(child);
		}
		return result;
	}
}
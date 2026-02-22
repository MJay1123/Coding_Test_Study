import java.util.*;
import java.io.*;

class Solution {
	static int V, E;
	static int[] tree;
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
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				tree[child] = parent;
			}
			int commonParent = getCommonParent(num1, num2);
			int subTreeSize = getSubTreeSize(commonParent);
			sb.append("#").append(test_case).append(" ").append(commonParent).append(" ").append(subTreeSize).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
	}
	public static int getCommonParent(int num1, int num2) {
		boolean[] visited = new boolean[V+1];
		int n = num1;
		while(true) {
			n = tree[n];
			visited[n] = true;
			if(n == 1) {
				break;
			}
		}
		n = num2;
		while(true) {
			n = tree[n];
			if(visited[n]) {
				return n;
			}
		}
	}
	public static int getSubTreeSize(int parent) {
		int result = 1;
		for(int i=1; i<=V; i++) {
			if(tree[i] == parent) {
				result += getSubTreeSize(i);
			}
		}
		return result;
	}
}
import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] tree;
	static int treeCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int testCase = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n == 0 && m == 0) {
				break;
			}
			tree = new int[n+1];
			treeCount = n;
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			sb.append("Case ").append(testCase).append(": ");
			if(treeCount > 1) {
				sb.append("A forest of ").append(treeCount).append(" trees.");
			} else if(treeCount == 1) {
				sb.append("There is one tree.");
			} else if(treeCount == 0) {
				sb.append("No trees.");
			}
			sb.append("\n");
			testCase++;
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static void union(int num1, int num2) {
		int root1 = find(num1);
		int root2 = find(num2);
		if(root1 == root2) {
			if(tree[root1] == 0) {
				tree[root1] = -1;
				treeCount--;
			}
		} else {
			if(tree[root1] == 0 && tree[root2] == 0) {
				tree[root1] = root2;
				treeCount--;
			} else if(tree[root1] == 0 && tree[root2] == -1) {
				tree[root1] = root2;
				treeCount--;
			} else if(tree[root1] == -1 && tree[root2] == 0) {
				tree[root2] = root1;
				treeCount--;
			}
		}
	}
	public static int find(int num) {
		if(tree[num] <= 0) {
			return num;
		}
		tree[num] = find(tree[num]);
		return tree[num];
	}
}

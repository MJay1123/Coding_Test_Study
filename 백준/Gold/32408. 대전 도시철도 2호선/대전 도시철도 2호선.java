import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] tree;
	static List<Integer>[] connectedTo;
	static HashSet<Integer> line1;
	static int[] depths;
	static Integer[] subTreeSizes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		tree = new int[N + 1];
		connectedTo = new List[N + 1];
		depths = new int[N + 1];
		subTreeSizes = new Integer[N + 1];
		for (int i = 1; i <= N; i++) {
			connectedTo[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			connectedTo[u].add(v);
			connectedTo[v].add(u);
		}
		getTree();
		line1 = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		int current = N;
		int previous = N;
		while(true) {
			if(current == 0) {
				break;
			}
			line1.add(current);
			for(int child : connectedTo[current]) {
				if(child == tree[current] || child == previous) {
					continue;
				}
				list.add(child);
			}
			previous = current;
			current = tree[current];
		}
//		for (int i : line1) {
//			for (int child : connectedTo[i]) {
//				if (!line1.contains(child) && child != tree[i]) {
//					list.add(child);
//				}
//			}
//		}
//		System.out.println("tree : " + Arrays.toString(tree));
//		System.out.println("depths : " + Arrays.toString(depths));
//		System.out.println("line1 : " + line1);
//		System.out.println("list : " + list);
		long answer = C((long)N - line1.size());
		for (int i : list) {
			int n = getSubTreeSize(i);
			answer -= C(n);
		}
		bw.write(answer + "\n");
		bw.flush();
	}

	public static long C(long n) {
		return n * (n - 1) / 2;
	}

	public static void getTree() {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : connectedTo[current]) {
				if(!visited[next]) {
					tree[next] = current;
					depths[next] = depths[current] + 1;
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
	}

	public static int getSubTreeSize(int parent) {
		if (subTreeSizes[parent] == null) {
			int result = 1;
			for (int child : connectedTo[parent]) {
				if(child == tree[parent]) {
					continue;
				}
				result += getSubTreeSize(child);
			}
			subTreeSizes[parent] = result;
		}
		return subTreeSizes[parent];
	}

	public static HashSet<Integer> getPath(int num1, int num2) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(num1);
		hs.add(num2);
		while (depths[num1] > depths[num2]) {
			num1 = tree[num1];
			hs.add(num1);
		}
		while (depths[num1] < depths[num2]) {
			num2 = tree[num2];
			hs.add(num2);
		}
		while (num1 != num2) {
			num1 = tree[num1];
			hs.add(num1);
			num2 = tree[num2];
			hs.add(num2);
		}
		return hs;
	}
}

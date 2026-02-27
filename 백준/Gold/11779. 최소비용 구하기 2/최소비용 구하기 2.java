import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int start, end;
	static List<Integer>[] busNumbers, busCosts;
	static int[] minDistance;
	static int[] visitedCounts;
	static int[] previous;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		busNumbers = new List[n+1];
		busCosts = new List[n+1];
		for(int i=1; i<=n; i++) {
			busNumbers[i] = new ArrayList<>();
			busCosts[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(!busNumbers[s].contains(e)) {	// 같은 경로의 버스가 여러 대일 수 있어서?
				busNumbers[s].add(e);
				busCosts[s].add(c);
			} else {
				for(int j=0; j<busNumbers[s].size(); j++) {
					if(busNumbers[s].get(j) == e) {
						busCosts[s].set(j, Math.min(busCosts[s].get(j), c));
						break;
					}
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		gogogo();
		List<Integer> list = new ArrayList<>();
		bw.write(minDistance[end] + "\n");
		bw.write(visitedCounts[end] + "\n");
		DFS(end, bw);
		bw.flush();
	}
	public static void DFS(int num, BufferedWriter bw) throws IOException {
		if(num != start) {
			DFS(previous[num], bw);
		}
		bw.write(num + " ");		
	}

	public static void gogogo() {
		minDistance = new int[n+1];
		visitedCounts = new int[n+1];
		previous = new int[n+1];
		Arrays.fill(minDistance, 1000000000);
		Queue<Integer> numQueue = new LinkedList<>();
		Queue<Integer> distQueue = new LinkedList<>();
		Queue<Integer> countQueue = new LinkedList<>();
		minDistance[start] = 0;
		numQueue.offer(start);
		distQueue.offer(0);
		countQueue.offer(1);
		while(!numQueue.isEmpty()) {
			int num = numQueue.poll();
			int dist = distQueue.poll();
			int count = countQueue.poll();
			for(int i=0;i<busNumbers[num].size(); i++) {
				int next = busNumbers[num].get(i);
				int nextDist = dist + busCosts[num].get(i);
				if(minDistance[next] > nextDist) {
					minDistance[next] = nextDist;
					visitedCounts[next] = count+1;
					previous[next] = num;
					numQueue.offer(next);
					distQueue.offer(nextDist);
					countQueue.offer(count+1);
				}
			}
		}
	}
}

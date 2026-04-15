import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static List<Integer>[] connectedFrom;
	static List<Integer>[] connectedTo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			connectedFrom = new List[N+1];
			connectedTo= new List[N+1];
			for(int i=1; i<=N; i++) {
				connectedFrom[i] = new ArrayList<>();
				connectedTo[i] = new ArrayList<>();
			}
			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				connectedTo[a].add(b);
				connectedFrom[b].add(a);
			}
			int answer = 0;
			for(int start=1; start<=N; start++) {
				boolean[] visited = new boolean[N+1];
				Queue<Integer> numQueue = new LinkedList<>();
				Queue<Integer> directionQueue = new LinkedList<>();
				visited[start] = true;
				numQueue.offer(start);
				numQueue.offer(start);
				directionQueue.offer(-1);
				directionQueue.offer(1);				
				while(!numQueue.isEmpty()) {
					int current = numQueue.poll();
					int direction = directionQueue.poll();
					if(direction == -1) {
						for(int next : connectedFrom[current]) {
							if(!visited[next]) {
								numQueue.offer(next);
								directionQueue.offer(-1);
								visited[next] = true;
							}
						}
					} else {
						for(int next : connectedTo[current]) {
							if(!visited[next]) {
								numQueue.offer(next);
								directionQueue.offer(1);
								visited[next] = true;
							}
						}
					}
				}
				boolean know = true;
				for(int i=1; i<=N; i++) {
					if(!visited[i]) {
						know = false;
						break;
					}
				}
				if(know) {
					answer++;
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

import java.util.*;
import java.io.*;
class Solution {
    static int N, M;
    static List<int[]>[] connections;
    static int[] distances;
    static int answer;
    static int MAX = 400 * 400 * 10000;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=T; tc++){
			sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            connections = new List[N+1];
            for(int i=1; i<=N; i++){
                connections[i] = new ArrayList<>();
            }
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                connections[s].add(new int[]{e, c});
            }
            answer = MAX;
            for(int start=1; start<=N; start++){
                distances = new int[N+1];
                Arrays.fill(distances, MAX);
                int result = dijkstra(start);
                if(result != -1){
                    answer = Math.min(answer, result);
                }
            }
            sb.append(answer).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
    public static int dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[1] - arr2[1];
            }
        });
        boolean[] visited = new boolean[N+1];
        pq.offer(new int[]{start, 0});
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int cn = arr[0];
            int cd = arr[1];
            if(cn == start && cd != 0){
                return cd;
            }
            visited[cn] = true;
            for(int[] next : connections[cn]){
                int nn = next[0];
                int nd = next[1];
                if((nn == start || !visited[nn]) && cd + nd < distances[nn]){
                    distances[nn] = cd + nd;
                    pq.offer(new int[]{nn, distances[nn]});
                }
            }
        }
        return -1;
    }
}